package com.fengjr.android.lexicon.imp;

import org.openqa.selenium.By;

import com.fengjr.android.exception.UiObjectNotFoundException;
import com.fengjr.android.uiobj.UiObject;

public class SummaryInfo {
	
	// 用户名
	private By NAME = By.id("com.fengjr.mobile:id/tvName");
	
	// 累计收益
	private By INCOME = By.id("com.fengjr.mobile:id/incomeToday");
	
	// 帐号总金额 com.fengjr.mobile:id/amountTotal
	private By AMOUNT_TOTAL = By.id("com.fengjr.mobile:id/amountTotal");
	
	// 可用余额 com.fengjr.mobile:id/available
	private By AVAILABLE = By.id("com.fengjr.mobile:id/available");
	
	// 待收本息 com.fengjr.mobile:id/receive
	private By RECEIVE = By.id("com.fengjr.mobile:id/receive");
	
	// 冻结金额 com.fengjr.mobile:id/frozen
	private By FROZEN = By.id("com.fengjr.mobile:id/frozen");
	
	// 投资记录 com.fengjr.mobile:id/ivInvestRecord
	private By INVEST_RECORD = By.id("com.fengjr.mobile:id/ivInvestRecord");
	
	// 我的众筹 com.fengjr.mobile:id/ivMyCrowFunding
	private By MY_CROW_FUNDING = By.id("com.fengjr.mobile:id/ivMyCrowFunding");
	
	// 资金流水 com.fengjr.mobile:id/ivCalendar
	private By CALENDAR = By.id("com.fengjr.mobile:id/ivCalendar");
	
	// 我的银行卡 com.fengjr.mobile:id/ivCard
	private By CARD = By.id("com.fengjr.mobile:id/ivCard");
	
	// 设置 com.fengjr.mobile:id/right
	private By SETTING = By.id("com.fengjr.mobile:id/right");
	
	private String name;
	private String income;
	private String amountTotal;
	private String available;
	private String receive;
	private String frozen;
	
	public SummaryInfo() {
		
		if (UiObject.searchFor(NAME)) {
			UiObject uio = new UiObject(NAME);
			name = uio.getText();
		}
		
		if (UiObject.searchFor(INCOME)) {
			UiObject uio = new UiObject(INCOME);
			income = uio.getText();
		}
		
		if (UiObject.searchFor(AMOUNT_TOTAL)) {
			UiObject uio = new UiObject(AMOUNT_TOTAL);
			amountTotal = uio.getText();
		}
		
		if (UiObject.searchFor(AVAILABLE)) {
			UiObject uio = new UiObject(AVAILABLE);
			available = uio.getText();
		}
		
		if (UiObject.searchFor(RECEIVE)) {
			UiObject uio = new UiObject(RECEIVE);
			receive = uio.getText();
		}
		
		if (UiObject.searchFor(FROZEN)) {
			UiObject uio = new UiObject(FROZEN);
			frozen = uio.getText();
		}
	}
	
	public void clickMyBankCard() throws UiObjectNotFoundException {
		UiObject.waitFor(CARD).click();
	}
	
	public void clickInvestRecord() throws UiObjectNotFoundException {
		UiObject.waitFor(INVEST_RECORD).click();
	}
	
	public void clickMyFounding() throws UiObjectNotFoundException {
		UiObject.waitFor(MY_CROW_FUNDING).click();
	}
	
	public void clickCalender() throws UiObjectNotFoundException {
		UiObject.waitFor(CALENDAR).click();
	}

	@Override
	public String toString() {
		return "SummaryInfo [name=" + name + ", income=" + income
				+ ", amountTotal=" + amountTotal + ", available=" + available
				+ ", receive=" + receive + ", frozen=" + frozen + "]";
	}
}
