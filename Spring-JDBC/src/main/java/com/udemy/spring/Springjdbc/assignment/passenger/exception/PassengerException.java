package com.udemy.spring.Springjdbc.assignment.passenger.exception;

import org.springframework.remoting.RemoteTimeoutException;

public class PassengerException extends RemoteTimeoutException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PassengerException(String msg) {
		super(msg);
	}

}
