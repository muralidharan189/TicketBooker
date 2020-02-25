package com.ticket.booking.booker.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ticket.booking.booker.impl.BookerServiceImpl;
import com.ticket.booking.booker.pojo.Login;
import com.ticket.booking.booker.pojo.Register;

@Controller
public class LoginController {
	@Autowired
	private BookerServiceImpl bookerService;

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView loginControl(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new Login());
		return mav;

	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView("Register");
		mav.addObject("register", new Register());
		return mav;

	}

	@RequestMapping(value="/userlogin", method=RequestMethod.POST)
	public ModelAndView loginValidate(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("login") Login login){
		ModelAndView mav = new ModelAndView("UserBook");
		String user = bookerService.loginValidate(login);
		if(null==user) {
			ModelAndView mavs=new ModelAndView("login");
			mavs.addObject("message", "Error User not found! please register");
			return mavs;
		}
		mav.addObject("user", user);
		return mav;

	}

}
