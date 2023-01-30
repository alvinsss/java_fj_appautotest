package com.fengjr.android.lexicon.imp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.fengjr.android.uiobj.UiObject;

public class FundItem {
	
	// 流水金额
	private By AMOUNT = By.id("com.fengjr.mobile:id/tvAmount");
	
	// 订单号
	private By ORDER_NUM = By.id("com.fengjr.mobile:id/tvType");
	
	// 流水状态
	private By INVEST_STATUS = By.id("com.fengjr.mobile:id/tvStatus");
	
	// 流水时间
	private By RECORD_TIME = By.id("com.fengjr.mobile:id/tvRecordTime");
	
	private String amount;
	private String orderNum;
	private String investStatus;
	private String recordTime;
	
	public FundItem(WebElement elm) {
		if (UiObject.searchFor(AMOUNT)) {
			WebElement uio = elm.findElement(AMOUNT);
			amount = uio.getText();
		}
		
		if (UiObject.searchFor(ORDER_NUM)) {
			WebElement uio = elm.findElement(ORDER_NUM);
			orderNum = uio.getText();
		}
		
		if (UiObject.searchFor(INVEST_STATUS)) {
			WebElement uio = elm.findElement(INVEST_STATUS);
			investStatus = uio.getText();
		}
		
		if (UiObject.searchFor(RECORD_TIME)) {
			WebElement uio = elm.findElement(RECORD_TIME);
			recordTime = uio.getText();
		}	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result
				+ ((investStatus == null) ? 0 : investStatus.hashCode());
		result = prime * result
				+ ((orderNum == null) ? 0 : orderNum.hashCode());
		result = prime * result
				+ ((recordTime == null) ? 0 : recordTime.hashCode());
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
		FundItem other = (FundItem) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (investStatus == null) {
			if (other.investStatus != null)
				return false;
		} else if (!investStatus.equals(other.investStatus))
			return false;
		if (orderNum == null) {
			if (other.orderNum != null)
				return false;
		} else if (!orderNum.equals(other.orderNum))
			return false;
		if (recordTime == null) {
			if (other.recordTime != null)
				return false;
		} else if (!recordTime.equals(other.recordTime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FundItem [amount=" + amount + ", orderNum=" + orderNum
				+ ", investStatus=" + investStatus + ", recordTime="
				+ recordTime + "]";
	}
}
