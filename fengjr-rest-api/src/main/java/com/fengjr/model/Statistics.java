package com.fengjr.model;

import java.io.Serializable;

public class Statistics implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6811298477490151807L;
	
	public String userId;
//	发布的贷款数
	public int publishedLoans;
//	成功且已结算的贷款数
	public int settledLoans;
//	还清的贷款数
	public int clearedLoans;
//	逾期的贷款数，只要某次还款逾期，那么对应的贷款就设定为逾期
	public int overdueLoans;
//	违约的贷款，即逾期贷款一定时间后仍然没有还款
	public int breachLoans;
//	总共的借入金额,只统计已经被结算的，满标但没有结算地不统计在内
	public double totalLoanAmount;
//	待还款总金额
	public Amount dueLoanAmount;
//	逾期金额包括违约
	public Amount overdueLoanAmount;
//	代收总金额
	public Amount dueInvestAmount;
//	对贷款的总借款额
	public double totalInvestAmount;
	
	public int successfulLoans;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getPublishedLoans() {
		return publishedLoans;
	}

	public void setPublishedLoans(int publishedLoans) {
		this.publishedLoans = publishedLoans;
	}

	public int getSettledLoans() {
		return settledLoans;
	}

	public void setSettledLoans(int settledLoans) {
		this.settledLoans = settledLoans;
	}

	public int getClearedLoans() {
		return clearedLoans;
	}

	public void setClearedLoans(int clearedLoans) {
		this.clearedLoans = clearedLoans;
	}

	public int getOverdueLoans() {
		return overdueLoans;
	}

	public void setOverdueLoans(int overdueLoans) {
		this.overdueLoans = overdueLoans;
	}

	public int getBreachLoans() {
		return breachLoans;
	}

	public void setBreachLoans(int breachLoans) {
		this.breachLoans = breachLoans;
	}

	public double getTotalLoanAmount() {
		return totalLoanAmount;
	}

	public void setTotalLoanAmount(double totalLoanAmount) {
		this.totalLoanAmount = totalLoanAmount;
	}

	public Amount getDueLoanAmount() {
		return dueLoanAmount;
	}

	public void setDueLoanAmount(Amount dueLoanAmount) {
		this.dueLoanAmount = dueLoanAmount;
	}

	public Amount getOverdueLoanAmount() {
		return overdueLoanAmount;
	}

	public void setOverdueLoanAmount(Amount overdueLoanAmount) {
		this.overdueLoanAmount = overdueLoanAmount;
	}

	public Amount getDueInvestAmount() {
		return dueInvestAmount;
	}

	public void setDueInvestAmount(Amount dueInvestAmount) {
		this.dueInvestAmount = dueInvestAmount;
	}

	public double getTotalInvestAmount() {
		return totalInvestAmount;
	}

	public void setTotalInvestAmount(double totalInvestAmount) {
		this.totalInvestAmount = totalInvestAmount;
	}

	public int getSuccessfulLoans() {
		return successfulLoans;
	}

	public void setSuccessfulLoans(int successfulLoans) {
		this.successfulLoans = successfulLoans;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
