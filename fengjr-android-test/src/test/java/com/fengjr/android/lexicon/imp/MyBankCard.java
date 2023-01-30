package com.fengjr.android.lexicon.imp;

import org.openqa.selenium.By;

import com.fengjr.android.exception.UiObjectNotFoundException;
import com.fengjr.android.uiobj.UiObject;


public class MyBankCard {
	
	// 返回
	private By BACK = By.id("com.fengjr.mobile:id/left");
	
	// 暂无绑定银行卡
	private By HINT = By.id("com.fengjr.mobile:id/hint");
	
	public MyBankCard() {
		
	}
	
	public void clickBack() throws UiObjectNotFoundException {
		UiObject.waitFor(BACK).click();
	}

}
