package com.fengjr.model;

import java.io.Serializable;

public class LoginErrorResult implements Serializable{
	private static final long serialVersionUID = -6907025358217324699L;
	
	public String result;
	public int failedAttempts;
	
}
