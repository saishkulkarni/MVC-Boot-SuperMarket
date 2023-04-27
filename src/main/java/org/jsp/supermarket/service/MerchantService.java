package org.jsp.supermarket.service;

import java.util.Random;

import org.jsp.supermarket.dao.MerchantDao;
import org.jsp.supermarket.dto.Merchant;
import org.jsp.supermarket.helper.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Service
public class MerchantService {

	@Autowired
	Login login;

	@Autowired
	Merchant merchant;

	@Autowired
	MerchantDao dao;

	public ModelAndView login() {
		ModelAndView andView = new ModelAndView("MerchantLogin");
		andView.addObject("login", login);
		return andView;
	}

	public ModelAndView signup() {
		ModelAndView andView = new ModelAndView("CustomerSignup");
		andView.addObject("merchant", merchant);
		return andView;
	}

	public ModelAndView login(Login login,HttpSession session) {
		ModelAndView andView = new ModelAndView();

		Merchant merchant = dao.find(login.getId());
		if (merchant == null) {
			andView.setViewName("MerchantLogin");
			andView.addObject("msg", "Invalid Id");
		} else {
			if (merchant.getPassword().equals(login.getPassword())) {
				if (merchant.isStatus()) {
					session.setAttribute("merchant", merchant);
					andView.setViewName("MerchantHome");
					andView.addObject("msg", "Login Succcess");
				} else {
					andView.setViewName("MerchantLogin");
					andView.addObject("msg", "Verify OTP First");
				}
			} else {
				andView.setViewName("MerchantLogin");
				andView.addObject("msg", "Invalid Password");
			}
		}

		return andView;
	}

	public ModelAndView signup(Merchant merchant, HttpSession session) {
		ModelAndView andView = new ModelAndView("OtpVerify");
		merchant.setOtp(new Random().nextInt(100000, 999999));

		// emailSender.sendEmail(customer);

		Merchant merchant2 = dao.save(merchant);
		session.setAttribute("merchant", merchant2);
		andView.addObject("msg", "Verification Mail Sent verify OTP to create account");
		andView.addObject("msg1", "Your Merchant Id is : " + merchant2.getId() + "");
		return andView;
	}

	public ModelAndView verifyOtp(HttpSession session, int otp) {
		ModelAndView andView = new ModelAndView();
		Merchant merchant = (Merchant) session.getAttribute("merchant");
		if (merchant.getOtp() == otp) {
			merchant.setStatus(true);
			dao.save(merchant);
			andView.setViewName("MerchantLogin");
			andView.addObject("msg", "Account created Successfully");
			session.invalidate();
		} else {
			andView.setViewName("OtpVerify");
			andView.addObject("msg", "Invalid OTP");
		}

		return andView;
	}
}
