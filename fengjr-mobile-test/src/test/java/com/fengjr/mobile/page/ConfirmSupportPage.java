package com.fengjr.mobile.page;

import org.openqa.selenium.By;

import com.fengjr.mobile.base.Page;
import com.fengjr.mobile.base.PageContext;

/**
 * 众筹支持确认页面
 * @author crest
 *
 */
public interface ConfirmSupportPage extends Page{
	
	// 收货地址
	public By ADDRESS = By.id("com.fengjr.mobile:id/address");
	// 回报信息
	public By REWARD = By.id("com.fengjr.mobile:id/reward");
	// 备注
	public By MARK = By.id("com.fengjr.mobile:id/mark");
	// 确认支持
	public By CONFIRM_SUPPORT = By.id("com.fengjr.mobile:id/confirmSupport");
	// 确认支持对话框OK按钮
	public By OK = By.id("com.fengjr.mobile:id/ok");
	// 确认支持对话框Cancel按钮
	public By CANCEL = By.id("com.fengjr.mobile:id/cancel");
	
	/**
	 * 点击收获信息
	 */
	boolean clickAddressInfo(PageContext context);
	
	/**
	 * 输入备注信息
	 * @param remarks
	 */
	boolean inputRemarks(PageContext context, String remarks);
	
	/**
	 * 点击支持按钮, 返回支持金额
	 */
	double clickSupport(PageContext context);
}
