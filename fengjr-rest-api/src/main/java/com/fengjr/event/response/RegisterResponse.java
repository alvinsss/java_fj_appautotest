package com.fengjr.event.response;

import com.fengjr.event.Response;
import com.fengjr.model.ApiResult;


public class RegisterResponse extends Response {

	public RegisterResponse(ApiResult result) {
		super(result);
	}
	
	public RegisterResponse(String error) {
		super(error);
	}
}
