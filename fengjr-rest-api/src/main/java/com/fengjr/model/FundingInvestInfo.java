package com.fengjr.model;

import java.io.Serializable;

/**
 * @author suetming ( suetming.ma@gmail.com )
 * 
 *         2014-10-20 下午6:44:48
 * 
 */

public class FundingInvestInfo implements Serializable {

	/**
	 * 
	 */
	public static final long serialVersionUID = -2204651021643565715L;

	/**
	 * same with FundingInvest
	 */
	public String id;

	public FundingInvest invest;

	public String realName;

	/**
	 * 13810002000 or 010-61112222
	 */
	public String contact;

	public String email;

	/**
	 * 全路径:北京市海淀区西直门外大街金贸中心1627室
	 */
	public String shippingAddress;

	public boolean needInvoice;

	/**
	 * 备注信息
	 */
	public String description;
}
