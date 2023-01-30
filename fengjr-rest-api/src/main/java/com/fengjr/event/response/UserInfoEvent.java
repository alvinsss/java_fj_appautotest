package com.fengjr.event.response;

import com.fengjr.event.Response;
import com.fengjr.model.UserInfo;


public class UserInfoEvent extends Response {

	public UserInfo userInfo;

	public UserInfoEvent(UserInfo userInfo) {
		super();
		this.userInfo = userInfo;
	}
	
	public UserInfoEvent(String error) {
		super(error);
	}
}
