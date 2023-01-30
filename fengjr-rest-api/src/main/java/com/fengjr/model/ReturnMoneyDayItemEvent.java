package com.fengjr.model;

/**
 * 
 * @author gaoge
 *比如2015-1-2就是一个ReturnMoneyDayItem，该天可以包含多个还款操作，
 *每一个还款操作就是一个ReturnMoneyDayItemEvent
 */
public class ReturnMoneyDayItemEvent implements Comparable<ReturnMoneyDayItemEvent>{
	//"INVEST_REPAY” 回款   “INVEST”投资  ，”DEPOSIT“充值，”WITHDRAW“提现，””众筹（稍后补充）
	public String eventType;
	public long eventTime;
	//每一个还款操作要返回的总额（包括本金 ＋ 利息）
	public double amount;
	public String loanTitle;
	public String loanId;
	public double rate;
	public int currentPeriod;
	public double amountPrincipal;
	public double amountInterest;
	public String paymentStatus;
	
	public ReturnMoneyDayItemEvent(long eventTime,double amount,String loanTitle){
		this.eventTime = eventTime;
		this.amount = amount;
		this.loanTitle = loanTitle;
	}

	@Override
	public int compareTo(ReturnMoneyDayItemEvent another) {
		return Long.valueOf(eventTime).compareTo(Long.valueOf(another.eventTime));

	}
}
