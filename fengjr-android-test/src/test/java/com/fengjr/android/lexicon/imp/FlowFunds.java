package com.fengjr.android.lexicon.imp;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import com.fengjr.android.exception.UiObjectNotFoundException;
import com.fengjr.android.uiobj.UiObject;
import com.fengjr.android.uiobj.UiScroller;

public class FlowFunds {

	private By BACK = By.id("com.fengjr.mobile:id/left");
	private By LIST = By.className("android.widget.ListView");
	private By LIST_ITEM = By.className("android.widget.RelativeLayout");
	private List<FundItem> fundItems = new ArrayList<FundItem>();
	
	
	public FlowFunds() {
		UiScroller<FundItem> uiScroller = new UiScroller<FundItem>(LIST, LIST_ITEM);
		uiScroller.traversal(FundItem.class, null);
		fundItems = uiScroller.allObservedItems();
	}
	
	public void clickBack() throws UiObjectNotFoundException {
		UiObject.waitFor(BACK).click();
	}
		
	@Override
	public String toString() {
		return "FlowFunds [fundItems=" + fundItems + "]";
	}

}
