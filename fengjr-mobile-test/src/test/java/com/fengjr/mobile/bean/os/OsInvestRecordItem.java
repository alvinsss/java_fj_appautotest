package com.fengjr.mobile.bean.os;

import io.appium.java_client.MobileBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.fengjr.mobile.base.PageContext;
import com.fengjr.mobile.bean.InvestRecordItem;
import com.fengjr.mobile.page.RepaymentPlan;
import com.fengjr.mobile.utils.UiObject;

public class OsInvestRecordItem implements InvestRecordItem{

	// 投资状态
	private By INVEST_STATUS = By.id("HoldsRecordStatus");
	
	// 投资项目 com.fengjr.mobile:id/title
	private By INVEST_TITLE =  By.id("investTitle");
	
	// 投资时间 com.fengjr.mobile:id/time
	private By INVEST_TIME =  By.id("investTime");
	
	// 投资利率 com.fengjr.mobile:id/rate
	private By INVEST_RATE = By.id("investRate");
	
	// 投资金额 com.fengjr.mobile:id/amount
	private By INVEST_AMOUNT = By.id("investAmount");
	
	// 转让 按钮
	private By RAISE = By.id("InvestmentManagementList_Transfer");
	// 还款计划 按钮
	private By REPAYMENT = By.id("InvestmentManagementList_RepaymentPlan");
	// 查看合同 按钮
	private By CONTRACT = By.id("InvestmentManagementList_LookContract");
	
	private String investStatus;
	private String investTitle;
	private String investTime;
	private String investRate;
	private String investAmount;
	
	public OsInvestRecordItem(WebElement elm) {
		try {
//			WebElement uio = elm.findElement(INVEST_STATUS);
//			investStatus = uio.getText();
//			System.out.println("investStatus:" + investStatus);
			
//			uio = elm.findElement(INVEST_TITLE);
//			investTitle = uio.getText();
//			System.out.println("investTitle:" + investTitle);
			
//			uio = elm.findElement(INVEST_TIME);
//			investTime = uio.getText();
//			System.out.println("investTime:" + investTime);

//			uio = elm.findElement(INVEST_RATE);
//			investRate = uio.getText();
//			System.out.println("investRate:" + investRate);
			
//			uio = elm.findElement(INVEST_AMOUNT);
//			investAmount = uio.getText();
//			System.out.println("investAmount:" + investAmount);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Create InvestRecordItem failed!");
		}
	}
	
	/**
	 * 点击资金筹集中按钮
	 */
	public void clickFundRaise(PageContext context) {
		UiObject.waitFor(RAISE).click();
	}
	
	/**
	 * 点击还款计划按钮
	 */
	public void clickRepaymentPlan(PageContext context) {
		UiObject.waitFor(REPAYMENT).click();
		context.update(RepaymentPlan.class);
	}
	
	/**
	 * 点击查看合同按钮
	 */
	@Override
	public void clickLookContract(PageContext context) {
		UiObject.waitFor(CONTRACT).click();
	}
	
	
	public String getInvestStatus() {
		return investStatus;
	}

	public void setInvestStatus(String investStatus) {
		this.investStatus = investStatus;
	}

	public String getInvestTitle() {
		return investTitle;
	}

	public void setInvestTitle(String investTitle) {
		this.investTitle = investTitle;
	}

	public String getInvestTime() {
		return investTime;
	}

	public void setInvestTime(String investTime) {
		this.investTime = investTime;
	}

	public String getInvestRate() {
		return investRate;
	}

	public void setInvestRate(String investRate) {
		this.investRate = investRate;
	}

	public String getInvestAmount() {
		return investAmount;
	}

	public void setInvestAmount(String investAmount) {
		this.investAmount = investAmount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((investAmount == null) ? 0 : investAmount.hashCode());
		result = prime * result
				+ ((investRate == null) ? 0 : investRate.hashCode());
		result = prime * result
				+ ((investStatus == null) ? 0 : investStatus.hashCode());
		result = prime * result
				+ ((investTime == null) ? 0 : investTime.hashCode());
		result = prime * result
				+ ((investTitle == null) ? 0 : investTitle.hashCode());
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
		OsInvestRecordItem other = (OsInvestRecordItem) obj;
		if (investAmount == null) {
			if (other.investAmount != null)
				return false;
		} else if (!investAmount.equals(other.investAmount))
			return false;
		if (investRate == null) {
			if (other.investRate != null)
				return false;
		} else if (!investRate.equals(other.investRate))
			return false;
		if (investStatus == null) {
			if (other.investStatus != null)
				return false;
		} else if (!investStatus.equals(other.investStatus))
			return false;
		if (investTime == null) {
			if (other.investTime != null)
				return false;
		} else if (!investTime.equals(other.investTime))
			return false;
		if (investTitle == null) {
			if (other.investTitle != null)
				return false;
		} else if (!investTitle.equals(other.investTitle))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "InvestRecordItem [investStatus=" + investStatus
				+ ", investTitle=" + investTitle + ", investTime=" + investTime
				+ ", investRate=" + investRate + ", investAmount="
				+ investAmount + "]";
	}
	
}