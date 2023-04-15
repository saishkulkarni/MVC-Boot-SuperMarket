package org.jsp.supermarket.service;

import org.jsp.supermarket.helper.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class AdminService {

	@Autowired
	Login login;

	public ModelAndView login() {
		ModelAndView andView = new ModelAndView("AdminLogin");
		andView.addObject("login", login);
		return andView;
	}

}
