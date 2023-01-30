package com.fengjr.mobile.page;

import com.fengjr.mobile.base.Page;
import com.fengjr.mobile.base.PageContext;

public interface SettingPage extends Page{

	/**
	 * 点击“修改手势密码”项
	 * @return
	 */
	boolean clickModifyPatternPasswordItem(PageContext context);
	
	/**
	 * 点击“资金托管帐号”项
	 * @return
	 */
	boolean clickFundTrusteeshipAccountItem(PageContext context);
	
	/**
	 * 点击“关于我们”项
	 * @return
	 */
	boolean clickAboutUsItem(PageContext context);
	
	/**
	 * 点击“检查更新”项
	 * @return
	 */
	boolean clickCheckUpdateItem(PageContext context);
	
	/**
	 * 点击“意见反馈”项
	 * @return
	 */
	boolean clickFeedbackItem(PageContext context);
	
	/**
	 * 点击“客服热线”项
	 */
	boolean clickServiceHotlineItem(PageContext context);
	
	/**
	 * 退出当前帐号
	 * @param context
	 * @return
	 */
	boolean exitCurrentAccount(PageContext context);
	
	/**
	 * 
	 */
	boolean inputPasswordBeforeModified(PageContext context);
}
