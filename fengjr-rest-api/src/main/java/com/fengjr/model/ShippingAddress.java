package com.fengjr.model;

import java.io.Serializable;


public class ShippingAddress implements Serializable {

	/**
	 * 
	 */
	public static final long serialVersionUID = -6914807871965936919L;

	public String id;

	public String userId;

	public String realName;

	public String contact;

	public String email;

	/**
	 * 北京西城区二环到三环西直门外大街金贸中心A座1627室</p> 全称或json结构化
	 * 
	 */
	public String detail;

	public boolean defaultAddress;

	// 公司地址，老家地址
	public String alias;
	
	public boolean needInvoice;

}
