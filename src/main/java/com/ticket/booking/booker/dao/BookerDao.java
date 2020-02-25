package com.ticket.booking.booker.dao;

import com.ticket.booking.booker.pojo.Register;

public interface BookerDao {
	
	public String loginValidation(String userName,String passWord);
	public String loginUser(String userName,String passWord);
	public String registerUser(String userName,String passWord);
	public String checkUser(String userName);
	String registerUser(Register register);
	String checkUser(Register register);
}
