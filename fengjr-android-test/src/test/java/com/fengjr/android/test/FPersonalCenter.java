package com.fengjr.android.test;

import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fengjr.android.exception.UiObjectNotFoundException;
import com.fengjr.android.lexicon.imp.FlowFunds;
import com.fengjr.android.lexicon.imp.InvestRecord;
import com.fengjr.android.lexicon.imp.MyBankCard;
import com.fengjr.android.lexicon.imp.MyFunding;
import com.fengjr.android.lexicon.imp.SummaryInfo;


public class FPersonalCenter extends TestCaseBase {

	/**
	 * 进入我的账户界面
	 * @throws UiObjectNotFoundException 
	 * @throws InterruptedException 
	 */
	@BeforeMethod
	public void beforeMethod() throws UiObjectNotFoundException, InterruptedException {
		getNavigator().setReset(false);
		getNavigator().enterPersonalCenter();
	}
	
	/**
	 * 6.1 帐号概要信息
	 */
	@Test
	public void testAccountSummaryInfo() {
		SummaryInfo summaryInfo = new SummaryInfo();
		Reporter.log(summaryInfo.toString(), true );
	}
	
	/**
	 * 6.2 我的银行卡
	 * @throws UiObjectNotFoundException 
	 */
	@Test
	public void testMyBankCard() throws UiObjectNotFoundException {
		SummaryInfo summaryInfo = new SummaryInfo();
		summaryInfo.clickMyBankCard();
		MyBankCard myBankCard = new MyBankCard();
		Reporter.log(myBankCard.toString(), true);
		myBankCard.clickBack();
	}
	
	/**
	 * 6.3 投资记录 
	 * @throws UiObjectNotFoundException 
	 */
	@Test
	public void testInvestRecord() throws UiObjectNotFoundException {
		SummaryInfo summaryInfo = new SummaryInfo();
		summaryInfo.clickInvestRecord();
		InvestRecord investRecord = new InvestRecord();
		Reporter.log(investRecord.toString(), true );
		investRecord.clickBack();
	}
	
	/**
	 * 6.4 我的众筹
	 * @throws UiObjectNotFoundException 
	 * @throws InterruptedException 
	 */
	@Test
	public void testMyFunding() throws UiObjectNotFoundException, InterruptedException {
		SummaryInfo summaryInfo = new SummaryInfo();
		summaryInfo.clickMyFounding();
		MyFunding myFunding = new MyFunding();
		Reporter.log(myFunding.toString(), true );
		myFunding.clickBack();
	}
	
	/**
	 * 6.5 资金流水
	 * @throws UiObjectNotFoundException 
	 */
	@Test
	public void testCanlender() throws UiObjectNotFoundException {
		SummaryInfo summaryInfo = new SummaryInfo();
		summaryInfo.clickCalender();
		FlowFunds flowFunds = new FlowFunds();
		Reporter.log(flowFunds.toString(), true );
		flowFunds.clickBack();
	}
}
