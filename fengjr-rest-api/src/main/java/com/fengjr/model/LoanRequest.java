package com.fengjr.model;

import java.io.Serializable;


public class LoanRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3880189518823894432L;
	public String id;
	public User user;
	public String title;
	public String purpose;
	public int amount;
	public Duration duration;
	public int rate;
	public String method;
	public String description;
	public String status;
	public long timeSubmit;
	public boolean mortgaged;
	public String source;
	public String mortgageInfo;
	//public guarantyStyle;
	public String riskInfo;
	public Entity guaranteeEntity;
	public String guaranteeInfo;
	//public guarantyStyle;
	public InvestRule investRule;
	public String reviewComment;
	//public clientPriv;
	public RequestProvider requestProvider;
	public String productId;
	public String productKey;
	public boolean hidden;
	public String assignable;
}
