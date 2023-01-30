package com.fengjr.android.test;

import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fengjr.android.exception.UiObjectNotFoundException;
import com.fengjr.android.lexicon.IHomePage;
import com.fengjr.android.lexicon.ILoginPage;
import com.fengjr.android.lexicon.IPatternLock;
import com.fengjr.android.uiobj.Configurator;
import com.fengjr.android.uiobj.UiObject;

public class CPatternForget extends TestCaseBase {

	/**
	 * 进入有“忘记手势密码”按钮的屏幕锁界面
	 * @throws UiObjectNotFoundException 
	 * @throws InterruptedException 
	 */
	@BeforeMethod
	public void beforeMethod() throws UiObjectNotFoundException, InterruptedException {
		getNavigator().enterHomePage();
		getNavigator().exitApp();

		AndroidDriver androidDriver = (AndroidDriver) getAppiumDriver();
		String packageName = getParamters().get(Configurator.APP_PACKAGE);
		String activityName = getParamters().get(Configurator.APP_ACTIVITY);
		androidDriver.startActivity(packageName, activityName);
		
		UiObject.waitFor(IPatternLock.PATTERN_FORGET).click();
		UiObject.waitFor(IPatternLock.PATTERN_RELOGIN).click();
		String password = getParamters().get(Configurator.LOGIN_PASSWORD);
		UiObject.waitFor(ILoginPage.EDIT_TEXT_PASSWORD).click().sendKeys(password);
		getAppiumDriver().hideKeyboard();
		UiObject.waitFor(ILoginPage.BUTTION_LOGIN).click();
	}
	
	/**
	 * 2.2.1 点击忘记手势密码，输入密码重新登录; 提示用户重新登录进行设置，重新登录后可正常重置
	 * @throws UiObjectNotFoundException 
	 */
	@Test
	public void testForgetPattern() throws UiObjectNotFoundException {

		UiObject.waitFor(IPatternLock.PATTERN_LOCK).drawOnSquares(new int[]{1,2,3,4,5,6});
		UiObject.waitFor(IPatternLock.PATTERN_LOCK).drawOnSquares(new int[]{1,2,3,4,5,6});
		
		boolean result = UiObject.searchFor(IHomePage.FUNDING_PAGE);
		Assert.assertTrue("点击忘记手势密码，输入密码重新登录，提示用户重新登录进行设置，重新登录后无法正常重置", result);
	}
	
	/**
	 * 2.2.2 连续输入5次错误手势密码; 直接进入到密码登录界面，登录后进入密码设置界面
	 * @throws UiObjectNotFoundException 
	 */
	@Test
	public void testInputDiffPattern5Times() throws UiObjectNotFoundException {

		UiObject.waitFor(IPatternLock.PATTERN_LOCK).drawOnSquares(new int[]{1,2,3,4});
		UiObject.waitFor(IPatternLock.PATTERN_LOCK).drawOnSquares(new int[]{1,2,3,4,5});
		UiObject.waitFor(IPatternLock.PATTERN_LOCK).drawOnSquares(new int[]{1,2,3,4,5,6});
		UiObject.waitFor(IPatternLock.PATTERN_LOCK).drawOnSquares(new int[]{0,1,2,3,4});
		UiObject.waitFor(IPatternLock.PATTERN_LOCK).drawOnSquares(new int[]{0,1,2,3,4,5});
		UiObject.waitFor(IPatternLock.PATTERN_LOCK).drawOnSquares(new int[]{0,1,2,3,4,5,6});
		
		//Assert 进入登录界面
		UiObject.waitFor(ILoginPage.BUTTION_LOGIN).click();
		getNavigator().enterPatternLock();
		
		
		//Assert 登录后进入密码设置界面
		UiObject.waitFor(IPatternLock.PATTERN_LOCK);
	}
}
