package com.fengjr.android.utils;

import io.appium.java_client.AppiumDriver;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.fengjr.android.exception.UiObjectNotFoundException;
import com.fengjr.android.lexicon.IHomePage;
import com.fengjr.android.lexicon.IInvestPage;
import com.fengjr.android.lexicon.ILoading;
import com.fengjr.android.lexicon.IPatternLock;
import com.fengjr.android.lexicon.ISearchPage;
import com.fengjr.android.lexicon.IStartupPage;
import com.fengjr.android.lexicon.imp.LoanItem;
import com.fengjr.android.lexicon.imp.LoginPage;
import com.fengjr.android.uiobj.UiObject;
import com.fengjr.android.uiobj.UiScroller;

public class Navigator {

	private AppiumDriver appium;
	private String mobile;
	private String password;
	private boolean isReset;
	
	public Navigator(AppiumDriver appium, String mobile, String password, boolean isReset) {
		this.appium = appium;
		this.mobile = mobile;
		this.password = password;
		this.isReset = isReset;
	}
	
	public void setReset(boolean isReset) {
		this.isReset = isReset;
	}
	
	public boolean isReset() {
		return isReset;
	}
	
	/**
	 * 重置应用
	 */
	public void restApp() {
		if (isReset) appium.resetApp();
	}
	
	/**
	 * 跳过启动页
	 * @throws UiObjectNotFoundException 
	 */
	public void skipStartup() throws UiObjectNotFoundException {
		restApp();
		UiObject.waitFor(IStartupPage.BUTTON_GO, 120).click();
	}
	
	/**
	 * 登录
	 * @throws UiObjectNotFoundException 
	 */
	public void login() throws UiObjectNotFoundException {
		if (!UiObject.searchFor(LoginPage.BUTTION_LOGIN)) {
			skipStartup();
		}
		inputMobileNumber();
		inputPassword();
		appium.hideKeyboard();
		UiObject.waitFor(LoginPage.BUTTION_LOGIN).click();
	}
	
	/**
	 * 定位到屏幕锁界面
	 * @throws UiObjectNotFoundException 
	 */
	public void enterPatternLock() throws UiObjectNotFoundException {
		login();

		// 点击登录按钮后，等待Loading界面消失，等待时长3分钟
		UiObject uio = new UiObject(ILoading.LOADING_ID);
		uio.waitGone(180);
		
		//UiObject.waitFor(IPayAgreementPage.BUTTON_LEFT, 180).click();
	}
	
	/**
	 * 进入到首页
	 * @throws UiObjectNotFoundException 
	 */
	public void enterHomePage() throws UiObjectNotFoundException {
		if (UiObject.searchFor(IHomePage.identifier_1)) return;
		Logger.getLogger(getClass()).info("Intent to Home Page...");
		enterPatternLock();
		
		UiObject.waitFor(IPatternLock.PATTERN_LOCK).drawOnSquares(new int[]{3, 4, 5, 2, 1, 4, 7});
		UiObject.waitFor(IPatternLock.PATTERN_LOCK).drawOnSquares(new int[]{3, 4, 5, 2, 1, 4, 7});
		UiObject.waitFor(IHomePage.FUNDING_PAGE);
		
		Logger.getLogger(getClass()).info("Now in Home Page...");
	}
	
	/**
	 * 进入理理财界面
	 * @category enterHomePage
	 * @throws UiObjectNotFoundException
	 */
	public void enterLoanPage() throws UiObjectNotFoundException {
		if (UiObject.searchFor(IInvestPage.identifier_1)) return;
		Logger.getLogger(getClass()).info("Intent to Loan Page...");
		enterHomePage();
		
		UiObject uio = new UiObject(IHomePage.MONEY_PAGE);
		if (uio.waitFor()) {
			uio.click();
		}
		
		Logger.getLogger(getClass()).info("Now in Loan Page...");
	}
	
	/**
	 * 进入投资搜索界面
	 * @category enterInvestPage
	 * @throws UiObjectNotFoundException
	 */
	public void enterInvestSearchPage() throws UiObjectNotFoundException {
		if (UiObject.searchFor(ISearchPage.indetifier_1)) return;
		Logger.getLogger(getClass()).info("Intent to Search Page...");
		enterLoanPage();
		
		UiObject.waitFor(IInvestPage.SEARCH).click();
		Logger.getLogger(getClass()).info("Now in Search Page...");
	}
	
	/**
	 * 进入凤保宝项目详情页
	 * @throws UiObjectNotFoundException 
	 */
	public void enterInvestADetailPage() throws UiObjectNotFoundException {
		enterLoanPage();
		UiObject.waitFor(IInvestPage.MONEY_A).click();
		UiScroller<LoanItem> uiSelector = new UiScroller<LoanItem>(
				By.className("android.widget.ListView"), By.className("android.widget.FrameLayout"));
		List<LoanItem> items = uiSelector.currentItems(LoanItem.class);
		if (items.size() > 0) {
			LoanItem item = items.get(0);
			item.enterLoanDetails();
		}
	}
	
	/**
	 * 进入凤锐通项目详情页
	 * @throws UiObjectNotFoundException 
	 */
	public void enterInvestBDetailPage() throws UiObjectNotFoundException {
		enterLoanPage();
		UiObject.waitFor(IInvestPage.MONEY_B).click();
		UiScroller<LoanItem> uiSelector = new UiScroller<LoanItem>(
				By.className("android.widget.ListView"), By.className("android.widget.FrameLayout"));
		List<LoanItem> items = uiSelector.currentItems(LoanItem.class);
		if (items.size() > 0) {
			LoanItem item = items.get(0);
			item.enterLoanDetails();
		}
	}
	
	/**
	 * 进入众筹界面
	 * @throws UiObjectNotFoundException 
	 */
	public void enterFundingPage() throws UiObjectNotFoundException {
		if (UiObject.searchFor(IHomePage.FUNDING_PAGE_S)) return;
		enterHomePage();
		UiObject.waitFor(IHomePage.FUNDING_PAGE).click();
	}
	
	/**
	 * 进入个人中心
	 * @throws UiObjectNotFoundException 
	 */
	public void enterPersonalCenter() throws UiObjectNotFoundException {
		if (UiObject.searchFor(IHomePage.CENTER_PAGE_S)) return;
		enterHomePage();
		UiObject.waitFor(IHomePage.CENTER_PAGE).click();
		
	}
	
	/**
	 * 退出应用
	 * @throws InterruptedException 
	 * @throws UiObjectNotFoundException 
	 */
	public void exitApp() throws InterruptedException, UiObjectNotFoundException {
		UiObject.waitFor(IHomePage.FUNDING_PAGE);
		appium.navigate().back();
		Thread.sleep(500);
		appium.navigate().back();
	}
	
	/**
	 * 输入密码
	 * @throws UiObjectNotFoundException 
	 */
	private void inputPassword() throws UiObjectNotFoundException {
		UiObject.waitFor(LoginPage.EDIT_TEXT_PASSWORD).click();
		UiObject.waitFor(LoginPage.EDIT_TEXT_PASSWORD).sendKeys(password);
	}
	
	/**
	 * 输入电话号码
	 * @param  
	 * @throws UiObjectNotFoundException 
	 */
	private void inputMobileNumber() throws UiObjectNotFoundException {
		UiObject.waitFor(LoginPage.EDIT_TEXT_MOBILE).click();
		UiObject.waitFor(LoginPage.EDIT_TEXT_MOBILE).sendKeys(mobile);
	}
	
}
