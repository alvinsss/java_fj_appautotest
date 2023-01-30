package com.fengjr.android.lexicon.imp;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import com.fengjr.android.exception.UiObjectNotFoundException;
import com.fengjr.android.uiobj.UiObject;
import com.fengjr.android.uiobj.UiScroller;

public class MyFunding {

	// 返回
	private By BACK = By.id("com.fengjr.mobile:id/left");
	
	// 支持的众筹 com.fengjr.mobile:id/ivProjectA
	private By PROJECT_A = By.id("com.fengjr.mobile:id/ivProjectA");
	
	// 关注的众筹 com.fengjr.mobile:id/ivProjectB
	private By PROJECT_B = By.id("com.fengjr.mobile:id/ivProjectB");
	
	private By LIST = By.className("android.widget.ListView");
	
	private By ARROR = By.id("com.fengjr.mobile:id/arrow");
	
	private String LIST_ITEM_FRAME ="//android.widget.ListView/android.widget.FrameLayout";
	private String LIST_ITEM_LINEAR = "//android.widget.ListView/android.widget.LinearLayout";
	
	
	private List<MyFollowItem> followItems = new ArrayList<MyFollowItem>();
	private List<MyFundingItem> fundingItems = new ArrayList<MyFundingItem>();
	
	public MyFunding() throws UiObjectNotFoundException, InterruptedException {

		System.out.println("click project b");
		UiObject.waitFor(PROJECT_B).click();
		Thread.sleep(2000);
		UiScroller<MyFollowItem> followScroller = new UiScroller<MyFollowItem>(LIST, LIST_ITEM_LINEAR );
		followScroller.traversal(MyFollowItem.class, null);
		followItems = followScroller.allObservedItems();
		
		System.out.println("click project a");
		UiObject.waitFor(PROJECT_A).click();
		Thread.sleep(2000);
		UiScroller<MyFundingItem> fundingScroller = new UiScroller<MyFundingItem>(LIST, LIST_ITEM_FRAME);
		fundingScroller.traversal(MyFundingItem.class, null);
		fundingItems = fundingScroller.allObservedItems();
	}
	
	public void clickBack() throws UiObjectNotFoundException {
		UiObject.waitFor(BACK).click();
	}

	@Override
	public String toString() {
		return "MyFunding [followItems=" + followItems + ", fundingItems="
				+ fundingItems + "]";
	}
	
}
