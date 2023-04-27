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

	public ModelAndView login(Login login) {
		ModelAndView andView = new ModelAndView();
		if (login.getId().equals("admin")) {
			if (login.getPassword().equals("admin")) {
				andView.setViewName("AdminHome");
			} else {
				andView.setViewName("AdminLogin");
				andView.addObject("msg", "Invalid Password");
			}
		} else {
			andView.setViewName("AdminLogin");
			andView.addObject("msg", "Invalid Id");
		}
		return andView;
	}

}
