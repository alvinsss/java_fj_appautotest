package com.fengjr.mobile.page;

import com.fengjr.mobile.base.Page;
import com.fengjr.mobile.base.PageContext;

public interface PersonalCenterPage extends Page{

	/**
	 * 点击个人中心设置Icon
	 * @return
	 */
	boolean clickSettingIcon(PageContext context);
	
	/**
	 * 点击个人中心中“投资记录”项
	 * @return
	 */
	boolean clickInvestRecord(PageContext context);
	
	/**
	 * 点击个人中心中“我的众筹”项
	 * @return
	 */
	boolean clickMyCrowdfunding(PageContext context);
	
	/**
	 * 点击个人中心中“资金流水”项
	 * @return
	 */
	boolean clickFundsRecord(PageContext context);
	
	/**
	 * 点击个人中心中“回款查询”项
	 * @return
	 */
	boolean clickRepementQuery(PageContext context);

	/**
	 * 获取帐号总金额
	 * @return
	 */
	String getMoneyTotal(PageContext context);
	
	/**
	 * 冻结金额
	 * @return
	 */
	String getMoneyFrozen(PageContext context);
	
	/**
	 * 待收本息
	 * @return
	 */
	String getPrincipalAndIntrestDuein(PageContext context);
	
	/**
	 * 累计收益
	 * @param context
	 * @return
	 */
	String getIncomeTotal(PageContext context);
	
	/**
	 * 个人中心中可用余额
	 * @param context
	 * @return
	 */
	String getBlanceAvaliable(PageContext context);
	
}
