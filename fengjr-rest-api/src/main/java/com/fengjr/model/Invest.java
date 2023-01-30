package com.fengjr.model;

import java.io.Serializable;

public class Invest implements Serializable, Comparable<Invest> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3663350754158368629L;

	public double amount;
	
	public String bidMethod;

	public Duration duration;

	public String id;

	public String loanId;

	public String loanTitle;

	public long rate;

	public String repayMethod;

	public String status;

	public long submitTime;

	public String userId;

	public String userLoginName;

	public String purpose;
	
	//OPEN:转让中，SCHEDULED：可转让，FAILED：不可转让
	public String transferStatus;
	
	public boolean assignInvest;
	
	public String creditAssignTitle;
	

	public String creditAssignId;

	public int originalAmount;

	public boolean loanInvest;
	public int investAmount;

	@Override
	public int compareTo(Invest another) {
		return Long.valueOf(submitTime).compareTo(
				Long.valueOf(another.submitTime));
	}

}
