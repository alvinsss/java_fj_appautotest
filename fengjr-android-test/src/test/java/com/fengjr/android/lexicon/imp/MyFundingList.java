package com.fengjr.android.lexicon.imp;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import com.fengjr.android.exception.UiObjectNotFoundException;
import com.fengjr.android.uiobj.UiObject;
import com.fengjr.android.uiobj.UiScroller;

public class MyFundingList {

	// 发起众筹
	private By APPLY_FUNDING =  By.id("com.fengjr.mobile:id/right");
	
	private By LIST = By.className("android.widget.ListView");
	private String LIST_ITEM ="//android.widget.ListView/android.widget.LinearLayout";
	
	private List<MyFollowItem> fundingList = new ArrayList<MyFollowItem>();
	
	public MyFundingList() {
		UiScroller<MyFollowItem> uiScroller = new UiScroller<MyFollowItem>(LIST, LIST_ITEM);
		uiScroller.traversal(MyFollowItem.class, null);
		fundingList = uiScroller.allObservedItems();
	}
	
	public void clickAppFunding() throws UiObjectNotFoundException {
		UiObject.waitFor(APPLY_FUNDING).click();
	}

	@Override
	public String toString() {
		return "FundingList [fundingList=" + fundingList + "]";
	}
	
	
}
