package com.fengjr.android.lexicon.imp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.fengjr.android.uiobj.UiObject;

public class MyFundingItem {

	// 众筹项目 com.fengjr.mobile:id/title
	private By TITLE = By.id("com.fengjr.mobile:id/title");
	
	// 众筹金额 com.fengjr.mobile:id/amount
	private By AMOUNT = By.id("com.fengjr.mobile:id/amount");
	
	// 订单号 com.fengjr.mobile:id/order_num
	private By ORDER_NUM = By.id("com.fengjr.mobile:id/order_num");
	
	// 购买日期 com.fengjr.mobile:id/date
	private By DATE = By.id("com.fengjr.mobile:id/date");
	
	// 配送费用 com.fengjr.mobile:id/delivery
	private By DELIVERY = By.id("com.fengjr.mobile:id/delivery");
	
	private String title;
	
	private String amount;
	
	private String orderNum;
	
	private String date;
	
	private String delivery;
	
	public MyFundingItem(WebElement elm) {
		if (UiObject.searchFor(TITLE)) {
			WebElement uio = elm.findElement(TITLE);
			title = uio.getText();
		}
		
		if (UiObject.searchFor(AMOUNT)) {
			WebElement uio = elm.findElement(AMOUNT);
			amount = uio.getText();
		}
		
		if (UiObject.searchFor(ORDER_NUM)) {
			WebElement uio = elm.findElement(ORDER_NUM);
			orderNum = uio.getText();
		}
		
		if (UiObject.searchFor(DATE)) {
			WebElement uio = elm.findElement(DATE);
			date = uio.getText();
		}
		
		if (UiObject.searchFor(DELIVERY)) {
			WebElement uio = elm.findElement(DELIVERY);
			delivery = uio.getText();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((delivery == null) ? 0 : delivery.hashCode());
		result = prime * result
				+ ((orderNum == null) ? 0 : orderNum.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyFundingItem other = (MyFundingItem) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (delivery == null) {
			if (other.delivery != null)
				return false;
		} else if (!delivery.equals(other.delivery))
			return false;
		if (orderNum == null) {
			if (other.orderNum != null)
				return false;
		} else if (!orderNum.equals(other.orderNum))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MyFundingItem [title=" + title + ", amount=" + amount
				+ ", orderNum=" + orderNum + ", date=" + date + ", delivery="
				+ delivery + "]";
	}
	
	
}
