package com.fengjr.model;

import java.io.Serializable;

import com.fengjr.model.enums.LoanPurpose;

public class FilterParam implements Serializable {
	private static final long serialVersionUID = -3606598106493987055L;
	
	public LoanPurpose purpose;
	public String lastLoanId;
	public String pageSize;
	public String status;
	public String minDuration;
	public String maxDuration;
	public String minRate;
	public String maxRate;
	public String pageNum;
}
