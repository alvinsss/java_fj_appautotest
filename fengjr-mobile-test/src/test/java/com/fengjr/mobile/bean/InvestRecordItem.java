package com.fengjr.mobile.bean;

import com.fengjr.mobile.base.PageContext;

public interface InvestRecordItem {
	
	/**
	 * 点击资金筹集中按钮
	 */
	void clickFundRaise(PageContext context);
	/**
	 * 点击还款计划按钮
	 */
	void clickRepaymentPlan(PageContext context);
	
	/**
	 * 点击查看合同按钮
	 */
	void clickLookContract(PageContext context);
	
	/**
	 * 返回投资状态
	 * @return
	 */
	String getInvestStatus();

	/**
	 * 返回投资项目
	 * @return
	 */
	String getInvestTitle();

	/**
	 * 返回投资时间
	 * @return
	 */
	String getInvestTime();

	/**
	 * 返回投资利率
	 * @return
	 */
	String getInvestRate() ;

	/**
	 * 返回投资金额
	 * @return
	 */
	String getInvestAmount();

	
}