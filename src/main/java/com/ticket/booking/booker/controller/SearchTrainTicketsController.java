package com.ticket.booking.booker.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ticket.booking.booker.pojo.Train;

@Controller
public class SearchTrainTicketsController {

	
	@RequestMapping(value="/STT", method=RequestMethod.GET)
	public ModelAndView listTrainDetails(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView("listtrain");
		mav.addObject("Train", new Train());
		return mav;
		
	}
}
