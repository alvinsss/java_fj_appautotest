package com.fengjr.model;

import java.io.Serializable;

public class InvestRepayment implements Serializable {

	private static final long serialVersionUID = 4584425104016005928L;

	public String id;
	public Invest invest;
	public String investId;
	public int currentPeriod;
	public TransferRepayment repayment;
	public String status;
	public double repayAmount;
	public long repayDate;
//	public String repaySource;
	public int relativePeriod;
//	public String feeDetail;

}
