package com.fengjr.event.response;

import com.fengjr.event.Response;
import com.fengjr.model.ApiResult;



public class LoginResponse extends Response {

	public LoginResponse(ApiResult result) {
		super(result);
	}
	
	public LoginResponse(String error) {
		super(error);
	}
}
