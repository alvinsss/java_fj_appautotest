package com.fengjr.android.lexicon;

import org.openqa.selenium.By;

public interface ILoading {
	public static By LOADING_ID = By.id("com.fengjr.mobile:id/loading");
	
	@SuppressWarnings("static-access")
	public static By LOADING_LOGIN_TIP = By.id("com.fengjr.mobile:id/tip").name("正在登录...");
}
