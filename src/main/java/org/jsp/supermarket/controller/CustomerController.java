package org.jsp.supermarket.controller;

import org.jsp.supermarket.helper.Login;
import org.jsp.supermarket.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	CustomerService service;

	@GetMapping("login")
	public ModelAndView login() {
		return service.login();
	}
	
	@GetMapping("signup")
	public ModelAndView signup() {
		return service.signup();
	}
	
	@PostMapping("login")
	public ModelAndView login(@ModelAttribute Login login) {
		return service.login(login);
	}
	
}
