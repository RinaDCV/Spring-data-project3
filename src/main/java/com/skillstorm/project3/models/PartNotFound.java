package com.skillstorm.project3.models;

public class PartNotFound extends Exception {
	
private static final long serialVersionUID = 1668377646834185118L;
	
	public PartNotFound() { }
	
	public PartNotFound(String message) {
		super(message);
	}

}
