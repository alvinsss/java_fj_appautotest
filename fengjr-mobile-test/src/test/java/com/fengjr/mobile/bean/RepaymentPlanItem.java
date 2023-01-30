package com.fengjr.mobile.bean;


public interface RepaymentPlanItem {

	/**
	 * 返回日期
	 * @return
	 */
	public String getDate();

	/**
	 * 返回状态
	 * @return
	 */
	public String getStatus();

	/**
	 * 返回金额
	 * @return
	 */
	public String getAmount();
}