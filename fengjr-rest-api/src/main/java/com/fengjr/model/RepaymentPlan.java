package com.fengjr.model;

import java.util.List;

/**
 * 
 * @author gaoge
 * 还款计划实体类
 *
 */
public class RepaymentPlan {
	public Loan loanExt;
	public double totalPrincipal;
	public double totalAmount;
	public double totaInterest;
	
	public List<RepaymentPlanItem> investRepayments;
}
