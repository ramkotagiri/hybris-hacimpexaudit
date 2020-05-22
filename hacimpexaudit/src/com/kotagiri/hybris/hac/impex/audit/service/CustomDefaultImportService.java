/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2020 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *
 */
package com.kotagiri.hybris.hac.impex.audit.service;

import com.kotagiri.hybris.model.HacImpexAuditModel;
import de.hybris.platform.core.PK;
import de.hybris.platform.servicelayer.impex.ImpExResource;
import de.hybris.platform.servicelayer.impex.ImportConfig;
import de.hybris.platform.servicelayer.impex.ImportResult;
import de.hybris.platform.servicelayer.impex.impl.DefaultImportService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.util.Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 *
 */
public class CustomDefaultImportService extends DefaultImportService
{

	private static final Logger LOG = LogManager.getLogger(CustomDefaultImportService.class);

	private UserService userService;

	/**
	 * @return the userService
	 */
	public UserService getUserService()
	{
		return userService;
	}

	/**
	 * @param userService
	 *           the userService to set
	 */
	public void setUserService(final UserService userService)
	{
		this.userService = userService;
	}

	@Override
	public ImportResult importData(final ImpExResource script)
	{
		final ImportConfig config = new ImportConfig();
		config.setScript(script);
		return this.importData(config);
	}

	@Override
	public ImportResult importData(final ImportConfig config)
	{

		//Always second argument in the stacktrace is the caller class.
		//As we don't have direct way customizing the hac web/src classes we are trapping the
		//flow using current thread stack trace
		final String callingClass = Thread.currentThread().getStackTrace().length > 2
				? Thread.currentThread().getStackTrace()[2].getClassName()
				: "";
		LOG.debug("Impex Import Calling Class: {}",() -> callingClass);

		if (callingClass.equalsIgnoreCase(Config.getParameter("hac.impex.import.facade.class.name")))
		{
			//Setting Remove on success flag not to remove the cronjobs
			if (Config.getBoolean("impex.cron.job.remove.on.success", false))
			{
				config.setRemoveOnSuccess(Boolean.FALSE);
			}
			//Setting hmc saved values enable to true
			if (Config.getBoolean("impex.import.hmcsavedvaluesenabled", false))
			{
				config.setHmcSavedValuesEnabled(Boolean.TRUE);
			}

			final String userName = getUserService().getCurrentUser() != null ? getUserService().getCurrentUser().getUid() : "";
			final PK pk = config.getScript() != null ? config.getScript().getMedia().getPk() : null;

			final HacImpexAuditModel hacImpexAudit = getModelService().create(HacImpexAuditModel.class);

			if (getUserService().getCurrentUser() != null && pk != null)
			{
				hacImpexAudit.setUser(getUserService().getCurrentUser());
				hacImpexAudit.setMedia(config.getScript().getMedia());
				getModelService().save(hacImpexAudit);
		    }
			LOG.info("Auditing Impex Import from HAC: audit record PK {} User {} trying to import impex media PK {} ",
					hacImpexAudit.getPk(), userName, pk);
		}
		return super.importData(config);
	}
}
