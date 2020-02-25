package com.ticket.booking.booker.exception;

public class TicketException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TicketException(){
		
	}
	
	public TicketException(String message){
		System.out.println("Error is:"+message);
	}
	
	public TicketException(Exception e){
		System.out.println(e.getMessage());
	}
	
	public TicketException(String message, Exception e){
		System.out.println("Error is:"+message +"stacktrace is--->"+e.getStackTrace());
	}

}
