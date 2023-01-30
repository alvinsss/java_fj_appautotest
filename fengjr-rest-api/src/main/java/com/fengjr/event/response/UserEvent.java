package com.fengjr.event.response;

import com.fengjr.event.Response;
import com.fengjr.model.User;

public class UserEvent extends Response {

	public User user;

	public UserEvent(User user) {
		super();
		this.user = user;
	}
	
	public UserEvent(String error) {
		super(error);
	}
}
