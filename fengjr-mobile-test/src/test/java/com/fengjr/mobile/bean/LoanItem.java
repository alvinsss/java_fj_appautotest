package com.fengjr.mobile.bean;


public interface LoanItem {
	
	/**
	 * 进入项目详情
	 */
	public boolean enterLoanDetails();
	
	/**
	 * 返回借款项目编号
	 * @return
	 */
	public String getTitle();

	/**
	 * 返回年利率
	 * @return
	 */
	public String getRate();

	/**
	 * 返回借款期限
	 * @return
	 */
	public String getDuration() ;

	/**
	 * 返回借款总额
	 * @return
	 */
	public String getAmount() ;

	/**
	 * 返回项目状态
	 * @return
	 */
	public String getStatus();

}
