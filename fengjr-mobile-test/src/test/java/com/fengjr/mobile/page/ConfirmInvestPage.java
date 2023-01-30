package com.fengjr.mobile.page;

import com.fengjr.mobile.base.Page;
import com.fengjr.mobile.base.PageContext;

/**
 * 确认投资界面
 * @author crest
 *
 */
public interface ConfirmInvestPage extends Page{

	/**
	 * 增加金额
	 */
	boolean addMoney(PageContext context);
	
	/**
	 * 减少金额
	 */
	boolean minusMoney(PageContext context);
	
	/**
	 * 点击确认投资按钮
	 */
	boolean clickConfirmInvest(PageContext context);
	
	/**
	 * 点击确认投资对话框中确认按钮
	 */
	boolean clickConfirmOk(PageContext context);
	
	/**
	 * 点击确认投资对话框中取消按钮
	 */
	boolean clickConfirmCancel(PageContext context);
	
	/**
	 * 输入投资金额
	 */
	boolean inputInvestAmmout(PageContext context, String ammount);
	
	/**
	 * 确认投资界面中可用余额
	 * @param context
	 * @return
	 */
	double getTotalBalanceInvest(PageContext context);
	
	/**
	 * 到期总收益
	 * @param context
	 * @return
	 */
	double getTotalIncomeExpiration(PageContext context);
	
	/**
	 * 每月还本息
	 * @param context
	 * @return
	 */
	double getTotalIncomeMonthly(PageContext context);
	
	/**
	 * 到期还本
	 * @param context
	 * @return
	 */
	double getTotalPrincipalExpriation(PageContext context);
	
	/**
	 * 每月还息
	 * @param context
	 * @return
	 */
	double getTotalInterestMonthly(PageContext context);
	
	/**
	 * 获取期限
	 * @param context
	 * @return
	 */
	String getAllottedTime(PageContext context);
}
