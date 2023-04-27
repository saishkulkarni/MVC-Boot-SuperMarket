package org.jsp.supermarket.service;

import java.util.Random;

import org.jsp.supermarket.dao.CustomerDao;
import org.jsp.supermarket.dao.MerchantDao;
import org.jsp.supermarket.dao.ProductDao;
import org.jsp.supermarket.dto.Cart;
import org.jsp.supermarket.dto.Customer;
import org.jsp.supermarket.dto.Item;
import org.jsp.supermarket.dto.ShoppingOrder;
import org.jsp.supermarket.helper.Login;
import org.jsp.supermarket.helper.VerificationEmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Service
public class CustomerService {

	@Autowired
	VerificationEmailSender emailSender;

	@Autowired
	CustomerDao dao;

	@Autowired
	MerchantDao merchantDao;

	@Autowired
	ProductDao productDao;

	@Autowired
	Cart cart;

	@Autowired
	Item item;

	@Autowired
	ShoppingOrder order;

	@Autowired
	Login login;

	@Autowired
	Customer customer;

	public ModelAndView login() {
		ModelAndView andView = new ModelAndView("CustomerLogin");
		andView.addObject("login", login);
		return andView;
	}

	public ModelAndView signup() {
		ModelAndView andView = new ModelAndView("CustomerSignup");
		andView.addObject("customer", customer);
		return andView;
	}

	public ModelAndView login(Login login,HttpSession session) {
		ModelAndView andView = new ModelAndView();

		Customer customer = dao.find(login.getId());
		if (customer == null) {
			andView.setViewName("CustomerLogin");
			andView.addObject("msg", "Invalid Id");
		} else {
			if (customer.getPassword().equals(login.getPassword())) {
				if (customer.isStatus()) {
					session.setAttribute("customer", customer);
					andView.setViewName("CustomerHome");
					andView.addObject("msg", "Login Succcess");
				} else {
					andView.setViewName("CustomerLogin");
					andView.addObject("msg", "Verify OTP First");
				}
			} else {
				andView.setViewName("CustomerLogin");
				andView.addObject("msg", "Invalid Password");
			}
		}

		return andView;
	}

	public ModelAndView signup(Customer customer, HttpSession session) {
		ModelAndView andView = new ModelAndView("OtpVerify");
		customer.setOtp(new Random().nextInt(100000, 999999));

		// emailSender.sendEmail(customer);

		Customer customer2 = dao.save(customer);
		session.setAttribute("customer", customer2);
		andView.addObject("msg", "Verification Mail Sent verify OTP to create account");
		andView.addObject("msg1", "Your Customer Id is : " + customer2.getId() + "");
		return andView;

	}

	public ModelAndView verifyOtp(HttpSession session, int otp) {
		ModelAndView andView = new ModelAndView();
		Customer customer = (Customer) session.getAttribute("customer");
		if (customer.getOtp() == otp) {
			customer.setStatus(true);
			dao.save(customer);
			andView.setViewName("CustomerLogin");
			andView.addObject("msg", "Account created Successfully");
			session.invalidate();
		} else {
			andView.setViewName("OtpVerify");
			andView.addObject("msg", "Invalid OTP");
		}

		return andView;
	}

}
