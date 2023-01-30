package com.fengjr.android.lexicon;

import org.openqa.selenium.By;

public interface IRegisterPage {
	
	public static By EDIT_USER_NAME = By.id("com.fengjr.mobile:id/loginName");
	public static By EDIT_MOBILE_NUMBER = By.id("com.fengjr.mobile:id/mobile");
	public static By EDIT_PASSWORD = By.id("com.fengjr.mobile:id/password");
	public static By EDIT_VERIFY_CODE = By.id("com.fengjr.mobile:id/captcha");
	public static By BUTTON_VERIFY_CODE = By.id("com.fengjr.mobile:id/sendCaptcha");
	public static By LINK_AGREEMENT = By.id("com.fengjr.mobile:id/agreement");
	public static By BUTTON_NEXT_STEP = By.id("com.fengjr.mobile:id/nextStep");
}
