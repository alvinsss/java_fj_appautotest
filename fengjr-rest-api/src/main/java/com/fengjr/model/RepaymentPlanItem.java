package com.fengjr.model;

/**
 * 
 * @author gaoge
 *还款计划具体某一项（对应每个月）
 */
public class RepaymentPlanItem implements Comparable<RepaymentPlanItem> {

	public String id;
	public Invest invest;
	public String investId;
	public int currentPeriod;
	
	public RepaymentDetail repayment;
	//还款状态，UNDUE("未到期"),  OVERDUE("逾期"),   BREACH("违约"),  REPAYED("已还清"),
	public String status;
	public double repayAmount;
	public long repayDate;
	public Object repaySource;
	public int relativePeriod;
	public Object feeDetail;
	
	@Override
	public int compareTo(RepaymentPlanItem another) {
//		return Long.valueOf(repayDate).compareTo(Long.valueOf(another.repayDate));
		return repayment.dueDate.compareTo(another.repayment.dueDate);
	}

}
