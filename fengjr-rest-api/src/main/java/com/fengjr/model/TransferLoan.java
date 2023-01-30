package com.fengjr.model;

import java.io.Serializable;

public class TransferLoan implements Serializable{
	
	private static final long serialVersionUID = 6050519049174789851L;
	public String id;
	public String loanId;
	public String investId;
	public String userId;
	public double creditAmount;
	public long bidNumber;
	public long bidAmount;
	public String status;
	public float creditDealRate;
	public double creditDealAmount;
	public long timeOpen;
	public long timeOut;
	public long timeFinished;
	public String title;
	public int leftMonths;
	public double bidDealAmount;
	public String repayment;
	public String guaranteeName;
	public String guaranteeUrl;
	public String repayMethod;
	public int rate;
	public String score;
	public String creditValue;
	public String assignType;
	public String creditAssignRatio;
	public String leftTime;
	public double balance;

}
