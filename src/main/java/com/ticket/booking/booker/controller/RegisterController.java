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
public class RegisterController {
	@Autowired
	private BookerServiceImpl bookerService;

	@RequestMapping(value="/registeruser", method=RequestMethod.POST)
	public ModelAndView loginValidate(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("register") Register register){
		ModelAndView mav=null;
		String user = bookerService.checkUser(register);
		if(null==user||!user.isEmpty()) {
			String registered=bookerService.registerUser(register);
			if("success".equals(registered)) {
				mav = new ModelAndView("login");
				mav.addObject("login", new Login());
				mav.addObject("message", "User registeration is success! Login to continue");}
			else if("failed".equals(registered)){
				mav = new ModelAndView("Register");
				mav.addObject("message", "Some error occured");
			}else {
				mav = new ModelAndView("Register");
				mav.addObject("message", "User id already exists. Please try again with different user name");
			}
			return mav;	

		}
		ModelAndView mavs=new ModelAndView("Register");
		mavs.addObject("message", "Error occured");
		return mavs;


	}

}
