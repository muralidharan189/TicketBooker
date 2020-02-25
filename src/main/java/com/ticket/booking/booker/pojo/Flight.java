package com.ticket.booking.booker.pojo;

public class Flight {
	@Override
	public String toString() {
		return "Flight [flightNumber=" + flightNumber + ", flightName=" + flightName + ", flightTiming=" + flightTiming
				+ "]";
	}
	private String flightNumber;
	private String flightName;
	private String flightTiming;
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getFlightTiming() {
		return flightTiming;
	}
	public void setFlightTiming(String flightTiming) {
		this.flightTiming = flightTiming;
	}
}
