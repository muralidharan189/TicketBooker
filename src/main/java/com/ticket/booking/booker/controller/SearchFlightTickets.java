package com.ticket.booking.booker.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ticket.booking.booker.pojo.Train;

@Controller
public class SearchFlightTickets {
	@RequestMapping(value="/SFT", method=RequestMethod.GET)
	public ModelAndView listFlightDetails(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView("listflight");
		mav.addObject("Flight", new Train());
		return mav;
		
	}
}
