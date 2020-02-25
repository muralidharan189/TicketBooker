package com.ticket.booking.booker.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ticket.booking.booker.dao.BookerDaoImpl;
import com.ticket.booking.booker.intf.BookerService;
import com.ticket.booking.booker.pojo.Login;
import com.ticket.booking.booker.pojo.Register;

public class BookerServiceImpl implements BookerService {

	@Autowired
	public BookerDaoImpl bookerDaoImpl;
	
	@Override
	public String bookTicket(String userName, String age, String date,
			String gender) {
		// TODO Auto-generated method stub
		return null;
	}

	public String loginValidate(Login login) {
		String userName= login.getUserName();
		String passWord = login.getPassWord();
		String user = bookerDaoImpl.loginValidation(userName, passWord);
		return user;
	}
	
	public String checkUser(Register register) {
		String userName= register.getUserName();
		String user = bookerDaoImpl.checkUser(userName);
		return user;
	}
	
	public String registerUser(Register register) {
		String user = bookerDaoImpl.registerUser(register);
		return user;
	}

}
