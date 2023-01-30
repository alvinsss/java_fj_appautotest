package com.fengjr.android.lexicon;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface ILoginPage {

	public static By EDIT_TEXT_MOBILE = By.id("com.fengjr.mobile:id/mobile");
	public static By EDIT_TEXT_PASSWORD = By.id("com.fengjr.mobile:id/password");
	public static By BUTTION_LOGIN = By.id("com.fengjr.mobile:id/login");
	public static By BUTTION_REGISTER = By.id("com.fengjr.mobile:id/register");

	void inputLoginName(String loginName, WebDriverWait waiter);

	void inputMobileNumber(String mobileNum, WebDriverWait waiter);

	void inputPassword(String password, WebDriverWait waiter);

	void inputVerifyCode(String verifyCode, WebDriverWait waiter);

	void touchLoginButton(WebDriverWait waiter);

	void touchRegisterButton(WebDriverWait waiter);

	void touchNextSetp(WebDriverWait waiter);

	void touchRegisterAgreement(WebDriverWait waiter);

	void touchVerifyButton(WebDriverWait waiter);
}
