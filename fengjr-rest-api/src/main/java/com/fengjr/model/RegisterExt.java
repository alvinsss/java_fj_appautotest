package com.fengjr.model;

import java.io.Serializable;
import java.util.List;

public class RegisterExt implements Serializable {

	private static final long serialVersionUID = 7210114543882905249L;

	public boolean success;
	public List<ApiError> error;
	public RegisterData data;

}
