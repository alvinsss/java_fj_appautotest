package com.fengjr.mobile.bean.ad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.fengjr.mobile.bean.RepaymentPlanItem;

public class AdRepaymentPlanItem implements RepaymentPlanItem{
	
	// 日期
	private String date;
	private By DATE = By.id("com.fengjr.mobile:id/date");

	// 状态
	private String status;
	private By STATUS = By.id("com.fengjr.mobile:id/return_status");
	
	// 还款金额
	private String amount;
	private By AMOUNT = By.id("com.fengjr.mobile:id/return_money_value");
	
	public AdRepaymentPlanItem(WebElement uio) {
		try {
			WebElement dateElm = uio.findElement(DATE);
			date = dateElm.getText();
			
			WebElement statusElm = uio.findElement(STATUS);
			status = statusElm.getText();
			
			WebElement amountElm = uio.findElement(AMOUNT);
			amount = amountElm.getText();
		} catch (Exception e) {
			throw new RuntimeException("Failed to create RepaymentPlanItem");
		}
	}

	public String getDate() {
		return date;
	}

	public String getStatus() {
		return status;
	}

	public String getAmount() {
		return amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		AdRepaymentPlanItem other = (AdRepaymentPlanItem) obj;
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
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RepaymentPlanItem [date=" + date + ", status=" + status
				+ ", amount=" + amount + "]";
	}
}