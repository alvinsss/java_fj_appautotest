package com.fengjr.model;

public class ApiError {

	public String message;
	
	public String type;
	
	public String value;
	
	public int code;
	
	public ApiError() {}
	
	public ApiError(String message) {
		this.message = message;
	}
}
