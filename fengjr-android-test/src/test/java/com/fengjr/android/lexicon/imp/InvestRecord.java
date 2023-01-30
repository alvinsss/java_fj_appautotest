package com.fengjr.android.lexicon.imp;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import com.fengjr.android.exception.UiObjectNotFoundException;
import com.fengjr.android.uiobj.UiObject;
import com.fengjr.android.uiobj.UiScroller;

public class InvestRecord {
	
	// 返回
	private By BACK = By.id("com.fengjr.mobile:id/left");
	// 凤宝宝
	private By MONEY_A = By.id("com.fengjr.mobile:id/ivMoneyA");
	// 凤锐通
	private By MONEY_B = By.id("com.fengjr.mobile:id/ivMoneyB");
	
	private By LIST = By.className("android.widget.ListView");
	
	private By LIST_ITEM = By.className("android.widget.FrameLayout");
	
	private List<InvestRecordItem> moneyA = new ArrayList<InvestRecordItem>();
	
	private List<InvestRecordItem> moneyB = new ArrayList<InvestRecordItem>();
	
	public InvestRecord() throws UiObjectNotFoundException {
		
		UiScroller<InvestRecordItem> uiScroller = new UiScroller<InvestRecordItem>(LIST, LIST_ITEM);
		UiObject.waitFor(MONEY_A).click();
		
		uiScroller.traversal(InvestRecordItem.class, null);
		moneyA = uiScroller.allObservedItems();
		
		UiObject.waitFor(MONEY_B).click();
		
		uiScroller.traversal(InvestRecordItem.class, null);
		moneyB = uiScroller.allObservedItems();
	}
	
	public void clickBack() throws UiObjectNotFoundException	{
		UiObject.waitFor(BACK).click();
	}

	@Override
	public String toString() {
		return "InvestRecord [moneyA=" + moneyA + ", moneyB=" + moneyB + "]";
	}
}
