package com.fengjr.mobile.page;

import com.fengjr.mobile.base.Page;
import com.fengjr.mobile.base.PageContext;

/**
 * 收货信息界面
 * @author crest
 *
 */
public interface AddressInfoPage extends Page{

	/**
	 * 输入姓名
	 */
	boolean inputName(PageContext context);
	
	/**
	 * 输入手机号码
	 */
	boolean inputMobile(PageContext context);
	
	/**
	 * 输入电子邮件
	 */
	boolean inputEmail(PageContext context);
	
	/**
	 * 输入详细地址
	 */
	boolean inputAddress(PageContext context);
	
	/**
	 * 输入发票抬头
	 */
	boolean inputInvoiceTitle(PageContext context);
	
	/**
	 * 开启发票选项
	 */
	boolean enableInvoice(PageContext context);
	
	/**
	 * 禁止发票选项
	 */
	boolean disableInvoice(PageContext context);
	
	/**
	 * 点击提取按钮
	 */
	boolean clickSubmit(PageContext context);
}
