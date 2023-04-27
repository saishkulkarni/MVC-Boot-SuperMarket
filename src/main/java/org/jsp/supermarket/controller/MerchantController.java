package org.jsp.supermarket.controller;

import org.jsp.supermarket.dto.Merchant;
import org.jsp.supermarket.helper.Login;
import org.jsp.supermarket.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("merchant")
public class MerchantController {

	@Autowired
	MerchantService service;

	@GetMapping("login")
	public ModelAndView login() {
		return service.login();
	}

	@GetMapping("signup")
	public ModelAndView signup() {
		return service.signup();
	}

	@PostMapping("login")
	public ModelAndView login(@ModelAttribute Login login, HttpSession session) {
		return service.login(login,session);
	}

	@PostMapping("signup")
	public ModelAndView signup(@ModelAttribute Merchant merchant, HttpSession session) {
		return service.signup(merchant, session);
	}

	@PostMapping("verifyotp")
	public ModelAndView verifyOtp(HttpSession session, @RequestParam int otp) {
		return service.verifyOtp(session, otp);
	}

}
