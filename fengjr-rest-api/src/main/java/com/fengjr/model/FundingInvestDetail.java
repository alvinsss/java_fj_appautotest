package com.fengjr.model;

import java.io.Serializable;

public class FundingInvestDetail implements Serializable {

	private static final long serialVersionUID = 8263342642376812929L;
	public String id;
	public FundingInvest invest;
	public String realName;
	public String contact;
	public String email;
	public String shippingAddress;
	public boolean needInvoice;
	public String description;

	
}
