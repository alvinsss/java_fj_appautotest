package com.fengjr.model;

import java.io.Serializable;



public class UserLoginExt implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9023281891370149707L;
	
	public String access_token;
	public User user;
	public String token_type;
	public boolean encrypted;
	
	public UserLoginExt() {
		this.user = new User();
	}
	
	public void copy(UserLoginExt userLoginExt) {
		this.access_token = userLoginExt.access_token;
		this.user = userLoginExt.user;
		this.token_type = userLoginExt.token_type;
	}
}
