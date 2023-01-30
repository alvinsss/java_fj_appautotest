package com.fengjr.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LoanDetail implements Serializable {

	private static final long serialVersionUID = 4448330559456392457L;

	public String id;

	public String title;

	public String method;

	public int ordinal;
	
	public double amount;
	
	public double rate;
	
	public Duration duration;
	
	public LoanRequest loanRequest;
	
	public String purpose;

	public String description;
	
	public long timeOpen;
	
	public long timeFinished;
	
	public long timeSettled;
	
	public long timeCleared;

	public boolean mortgaged;   //是否抵押
	
	public long bidNumber;
	
	public long bidAmount;
	
	public String status;
	
	public boolean rewarded;
	
	public boolean hidden;
	
	public boolean autoSplitted;

	public long available;
	
	public long timeLeft;
	
	public long timeElapsed;
	
	public long timeSubmit;

	public String source;
	
	public double balance;
	
	public String corporationName;
	
	public String corporationShortName;
	
	public long investAmount;
	
	public long leftBidTime;
	
	public double investPercent;
	
	public long countDownTime;
	
	//public String mortgageInfo;

	//public String guaranteeInfo;

	//public String riskInfo;

	//public String serial;

	//public InvestRule investRule;

	//public long dateNow;

	public double principal;

	public double interest;

	public List<Repayment> repayments;
	
	public LoanDetail(BigDecimal principal, BigDecimal interest,
			Duration duration, String method) {
		this.principal = principal.doubleValue();
		this.interest = interest.doubleValue();
		this.duration = duration;
		this.method = method;
		
		repayments = new ArrayList<Repayment>();
	}
	
	
}
