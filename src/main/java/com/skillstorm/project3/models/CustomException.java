package com.skillstorm.project3.models;

public class CustomException extends Exception {

private static final long serialVersionUID = 8888L;
	
	public CustomException() { }
	
	public CustomException(String message) {
		super(message);
	}
}
