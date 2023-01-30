package com.fengjr.model;

import java.io.Serializable;

public class ContactInfo implements Serializable {

	private static final long serialVersionUID = 2373397409256532017L;
	// 紧急联系人
	public Contact emergency;
	// 工作联系人
	public Contact colleague;
	// 其他联系人
	public Contact other;

}
