package com.fengjr.mobile.page;

import com.fengjr.mobile.base.Page;
import com.fengjr.mobile.base.PageContext;

/**
 * 登录界面
 * @author crest
 *
 */
public interface LoginPage extends Page{
	
	// 生产平台
	int PRODUCT_PLATFORM = 0;
	// Beta 平台
	int BETA_PLATFORM = 1;
	// 测试平台
	int TEST_PLATFORM = 2;
	// 云信平台
	int CRED_PLATFORM = 3;
	
	/**
	 * 点击登录界面中的注册按钮
	 * @param context
	 * @return
	 */
	boolean clickRegisterButton(PageContext context);
	
	/**
	 * 登录
	 * @param context
	 * @param mobile
	 * @param password
	 * @return
	 */
	boolean login(PageContext context, String mobile, String password, int loginEnv);
	
	/**
	 * 切换平台，可切换生产平台，Beta平台，测试平台， 云信平台
	 * @param context 
	 */
	boolean changePlatform(PageContext context, int type);


}
