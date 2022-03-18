package com.ecommerce.java.exception;

@SuppressWarnings("serial")
public class CustomException extends Exception{

	String message;
	String errorMessage;

	public CustomException(String message) {
		super();
		this.message = message;
	}
	
	public CustomException(String message, String errorMessage) {
		super();
		this.message = message;
		this.errorMessage = errorMessage;
	}
}
