/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.kotagiri.hybris.setup;

import static com.kotagiri.hybris.constants.HacimpexauditConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import com.kotagiri.hybris.constants.HacimpexauditConstants;
import com.kotagiri.hybris.service.HacimpexauditService;


@SystemSetup(extension = HacimpexauditConstants.EXTENSIONNAME)
public class HacimpexauditSystemSetup
{
	private final HacimpexauditService hacimpexauditService;

	public HacimpexauditSystemSetup(final HacimpexauditService hacimpexauditService)
	{
		this.hacimpexauditService = hacimpexauditService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		hacimpexauditService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return HacimpexauditSystemSetup.class.getResourceAsStream("/hacimpexaudit/sap-hybris-platform.png");
	}
}
