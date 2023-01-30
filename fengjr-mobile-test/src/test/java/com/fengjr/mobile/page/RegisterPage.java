package com.fengjr.mobile.page;

import com.fengjr.mobile.base.Page;
import com.fengjr.mobile.base.PageContext;


public interface RegisterPage extends Page{

	/**
	 * 输入注册用户名
	 * @param context
	 * @param username 
	 * @return
	 */
	boolean inputRegisterUsername(PageContext context, String username);
	
	/**
	 * 输入注册手机号码
	 * @param context
	 * @param mobilenumber 
	 * @return
	 */
	boolean inputRegisterMobilenumber(PageContext context, String mobilenumber);

	
	/**
	 * 输入注册密码
	 * @param password 
	 */
	boolean inputRegisterPassword(PageContext context, String password);
	
	/**
	 * 再次输入注册密码
	 * @param password 
	 */
	boolean inputRegisterPasswordAgain(PageContext context, String password);
	
	/**
	 * 获取验证码
	 */
	boolean inputRegisterVercode(PageContext context);
	
	/**
	 * 点击注册界面下一步按钮
	 */
	boolean clickRegisterNextStep(PageContext context);
	
	/**
	 * 点击用户注册协议
	 */
	boolean clickUserRegisterAggrement(PageContext context);
}
