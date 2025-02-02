/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.kotagiri.hybris.controller;

import static com.kotagiri.hybris.constants.HacimpexauditConstants.PLATFORM_LOGO_CODE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kotagiri.hybris.service.HacimpexauditService;


@Controller
public class HacimpexauditHelloController
{
	@Autowired
	private HacimpexauditService hacimpexauditService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(final ModelMap model)
	{
		model.addAttribute("logoUrl", hacimpexauditService.getHybrisLogoUrl(PLATFORM_LOGO_CODE));
		return "welcome";
	}
}
