package com.fengjr.mobile.test;

import static com.fengjr.mobile.factory.PageFactory.isLoaded;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fengjr.mobile.base.PageContext;
import com.fengjr.mobile.exception.UiObjectNotFoundException;
import com.fengjr.mobile.page.LoginPage;
import com.fengjr.mobile.page.PatternLockPage;

public class TestLogin extends TestCaseBase {

	/**
	 * 已注册帐号登录，可正常登录
	 * 
	 * @pre. 登录使用的帐号已经成功注册
	 * 
	 * @param mobile
	 * @param password
	 * @throws UiObjectNotFoundException
	 */
	@Test
	@Parameters({"mobile-number", "password"})
	public void testLogin(String mobile, String password) {
		
		try {
			PageContext context = new PageContext();
			context.login(context, mobile, password, LoginPage.PRODUCT_PLATFORM);
			
			// 判断是否登录成功
			Assert.assertTrue(isLoaded(PatternLockPage.class) || isLoaded(LoginPage.class), "登录失败");

		} catch (RuntimeException e) {
			Assert.assertTrue(false, e.getMessage());
		}
	}
}
