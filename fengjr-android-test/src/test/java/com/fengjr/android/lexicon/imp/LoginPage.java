package com.fengjr.android.lexicon.imp;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fengjr.android.lexicon.ILoginPage;

public class LoginPage implements ILoginPage {

	private AppiumDriver mAppium;

	public LoginPage(AppiumDriver appium) {
		mAppium = appium;
	}
	
	/**
	 * @see com.fengjr.android.lexicon.ILoginPage#putLoginName(String, WebDriverWait)
	 */
	@Override
	public void inputLoginName(String loginName, WebDriverWait waiter) {
		By locator = By.id("com.fengjr.mobile:id/loginName");
		WebElement uio = waiter.until(ExpectedConditions
				.visibilityOfElementLocated(locator));
		uio.click();
		uio.sendKeys(loginName);
		mAppium.hideKeyboard();
	}

	/**
	 * @see com.fengjr.android.lexicon.ILoginPage#putMobileNumber(String,
	 *      WebDriverWait)
	 */
	@Override
	public void inputMobileNumber(String mobileNum, WebDriverWait waiter) {
		By locator = By.id("com.fengjr.mobile:id/mobile");
		WebElement uio = waiter.until(ExpectedConditions
				.visibilityOfElementLocated(locator));
		uio.click();
		uio.sendKeys(mobileNum);
		mAppium.hideKeyboard();
	}

	/**
	 * @see com.fengjr.android.lexicon.ILoginPage#putPassword(String,
	 *      WebDriverWait)
	 */
	@Override
	public void inputPassword(String password, WebDriverWait waiter) {
		By locator = By.id("com.fengjr.mobile:id/password");
		WebElement uio = waiter.until(ExpectedConditions
				.visibilityOfElementLocated(locator));
		uio.click();
		uio.clear();
		uio.sendKeys(password);
		mAppium.hideKeyboard();
	}
	
	/**
	 * @see com.fengjr.android.lexicon.ILoginPage#putVerifyCode(String, WebDriverWait)
	 */
	@Override
	public void inputVerifyCode(String verifyCode, WebDriverWait waiter) {
		By locator = By.id("com.fengjr.mobile:id/captcha");
		WebElement uio = waiter.until(ExpectedConditions
				.visibilityOfElementLocated(locator));
		uio.click();
		uio.sendKeys(verifyCode);
		mAppium.hideKeyboard();
	}

	/**
	 * @see com.fengjr.android.lexicon.ILoginPage#touchLoginButton(WebDriverWait)
	 */
	@Override
	public void touchLoginButton(WebDriverWait waiter) {
		By locator = By.id("com.fengjr.mobile:id/login");
		WebElement uio = waiter.until(ExpectedConditions
				.visibilityOfElementLocated(locator));
		uio.click();
	}

	/**
	 * @see com.fengjr.android.lexicon.ILoginPage#touchRegisterButton(WebDriverWait)
	 */
	@Override
	public void touchRegisterButton(WebDriverWait waiter) {
		By locator = By.id("com.fengjr.mobile:id/register");
		WebElement uio = waiter.until(ExpectedConditions
				.visibilityOfElementLocated(locator));
		uio.click();
	}

	/**
	 * @see com.fengjr.android.lexicon.ILoginPage#touchNextSetp(WebDriverWait)
	 */
	@Override
	public void touchNextSetp(WebDriverWait waiter) {
		By locator = By.id("com.fengjr.mobile:id/nextStep");
		WebElement uio = waiter.until(ExpectedConditions
				.visibilityOfElementLocated(locator));
		uio.click();
	}

	/**
	 * @see com.fengjr.android.lexicon.ILoginPage#touchRegisterAgreement(WebDriverWait)
	 */
	@Override
	public void touchRegisterAgreement(WebDriverWait waiter) {
		By locator = By.id("com.fengjr.mobile:id/agreement");
		WebElement uio = waiter.until(ExpectedConditions
				.visibilityOfElementLocated(locator));
		uio.click();
	}

	/**
	 * @see com.fengjr.android.lexicon.ILoginPage#touchVerifyButton(WebDriverWait)
	 */
	@Override
	public void touchVerifyButton(WebDriverWait waiter) {
		By locator = By.id("com.fengjr.mobile:id/sendCaptcha");
		WebElement uio = waiter.until(ExpectedConditions
				.visibilityOfElementLocated(locator));
		uio.click();
	}

}
