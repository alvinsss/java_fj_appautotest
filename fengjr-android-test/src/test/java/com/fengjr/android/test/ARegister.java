package com.fengjr.android.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fengjr.android.exception.UiObjectNotFoundException;
import com.fengjr.android.lexicon.IPayAgreementPage;
import com.fengjr.android.lexicon.IRegisterPage;
import com.fengjr.android.lexicon.ISignAgreementPage;
import com.fengjr.android.lexicon.imp.LoginPage;
import com.fengjr.android.uiobj.UiObject;

/**
 * 
 * Fengjr android client register function test
 * 
 * @author crest
 *
 */
public class ARegister extends TestCaseBase {
	
	/**
	 * 进入登录界面
	 * @throws UiObjectNotFoundException
	 */
	@BeforeMethod
	public void beforeMethod() throws UiObjectNotFoundException {
		getNavigator().skipStartup();
	}

	/**
	 * 未注册过的手机号，可以正常注册
	 * 
	 * @pre. 提供的手机号码未注册
	 * 		 手机卡正确安装在运行脚本的手机上且信号良好
	 * @throws UiObjectNotFoundException 
	 */
	@Test
	@Parameters({"unregist-login-name", "unregist-mobile-number", "unregist-password"})
	public void testRegister(String loginName, String mobileNumber, String password) throws UiObjectNotFoundException {

		UiObject.waitFor(LoginPage.BUTTION_REGISTER).click();
		UiObject.waitFor(IRegisterPage.EDIT_USER_NAME).click().sendKeys(loginName);
		
		Assert.assertTrue(true, mobileNumber + "注册失败");
	}
	
	/**
	 * 点击凤凰金融用户协议，可以正常打开协议链接
	 * @throws UiObjectNotFoundException 
	 */
	@Test
	public void testAgreementLink() throws UiObjectNotFoundException {

		UiObject.waitFor(LoginPage.BUTTION_REGISTER).click();
		UiObject.waitFor(IRegisterPage.LINK_AGREEMENT).click();
		
		boolean result = UiObject.searchFor(ISignAgreementPage.WEB_AGREEMENT, 3, true);
		Assert.assertTrue(result, "点击凤凰金融用户协议，无法打开协议链接");
	}
	
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
	public void testLogin(String mobile, String password) throws UiObjectNotFoundException {
		
		getNavigator().login();
		boolean result = UiObject.searchFor(IPayAgreementPage.BUTTON_AGREEMENT);
		Assert.assertTrue(result, "帐号" + mobile + "登录失败");
	}
	
	/**
	 * 被锁定帐号登录，无法正常登录
	 * 
	 * @pre. 登录使用的帐号已被锁定
	 * @throws UiObjectNotFoundException 
	 */
	@Test
	@Parameters({"locked-mobile-number", "locked-password"})
	public void testLockedAccoutLogin(String mobile, String password) throws UiObjectNotFoundException {

		getNavigator().login();
		boolean result = UiObject.searchFor(IPayAgreementPage.BUTTON_AGREEMENT);
		Assert.assertFalse(result, "已锁定帐号" + mobile + "登录成功");
	}

}
