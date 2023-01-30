package com.fengjr.mobile.page;

import com.fengjr.mobile.base.Page;
import com.fengjr.mobile.base.PageContext;

public interface TabPage extends Page{
	/**
	 * 点击首页TAB
	 * @param context
	 * @return
	 */
	boolean clickHomeTab(PageContext context);
	
	/**
	 * 点击理理财TAB
	 * @param context
	 * @return
	 */
	boolean clickLoanTab(PageContext context);
	
	/**
	 * 点击众筹TAB
	 * @param context
	 * @return
	 */
	boolean clickFundingTab(PageContext context);
	
	/**
	 * 点击个人中心TAB
	 * @param context
	 * @return
	 */
	boolean clickPersonalCenterTab(PageContext context);

}
