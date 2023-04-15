package org.jsp.supermarket.controller;

import org.jsp.supermarket.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("merchant")
public class MerchantController {

	@Autowired
	MerchantService service;

	@GetMapping("login")
	public ModelAndView login() {
		return service.login();
	}
}
