package com.fengjr.event.response;

import com.fengjr.event.Response;
import com.fengjr.model.UserDetail;


public class UserDetailEvent extends Response {

	public UserDetail userDetail;

	public UserDetailEvent(UserDetail userDetail) {
		super();
		this.userDetail = userDetail;
	}
	
	public UserDetailEvent(String error) {
		super(error);
	}
}
