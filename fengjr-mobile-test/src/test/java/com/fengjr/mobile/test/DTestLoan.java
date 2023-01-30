package com.fengjr.mobile.test;

import junit.framework.TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fengjr.mobile.base.PageContext;
import com.fengjr.model.enums.LoanPurpose;

public class DTestLoan extends TestCase {
	
	// 到期总收益
	private double totalIncomeExpiration;
	// 每月还息
	private double totalInterestMonthly;
	// 到期还本
	private double totalPrincipalExpriation;
	
	@Test
	public void testLoanPayIntrestMaturity() {
		
		try {
			PageContext context = new PageContext();
			
			context.goLoanPage(context);
			context.clickFengrtTab(context);
			context.clickLoanItem(context, "0001一次性还本付息");
			
			context.clickInvest(context);
			context.inputInvestAmmout(context, "1");
			
			totalIncomeExpiration = context.getTotalIncomeExpiration(context);
			totalInterestMonthly = context.getTotalInterestMonthly(context);
			totalPrincipalExpriation = context.getTotalPrincipalExpriation(context);
			
//			context.testIncomeMaturity(context);
//			context.testBfxiSumMaturity(context);
//			context.testDuration(context);
			
			context.clickConfirmInvest(context);
			//context.clickConfirmCancel(context);
			context.clickConfirmOk(context);
//			context.testAvalableAmmountAfterInvest(context);
			
		} catch (RuntimeException e) {
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	@Test
	public void testLoanPayIntrestMonthly() {
		try {
			PageContext context = new PageContext();
			
			context.goLoanPage(context);
			context.clickFengrtTab(context);
			context.clickLoanItem(context, "0001按月付息到期还本");
			
			context.clickInvest(context);
			context.inputInvestAmmout(context, "1");
//			context.testIncomeMaturity(context);
//			context.testBfxiSumMaturity(context);
//			context.testDuration(context);
			
			context.clickConfirmInvest(context);
			//context.clickConfirmCancel(context);
			context.clickConfirmOk(context);
//			context.testAvalableAmmountAfterInvest(context);
			
		} catch (RuntimeException e) {
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	@Test
	public void testLoanPayIntrestAverage() {
		try {
			PageContext context = new PageContext();
			
			context.goLoanPage(context);
			context.clickFengrtTab(context);
			context.clickLoanItem(context, "0001按月等额本息");
			
			context.clickInvest(context);
			context.inputInvestAmmout(context, "1");
//			context.testIncomeMaturity(context);
//			context.testBfxiSumMaturity(context);
//			context.testDuration(context);
			
			context.clickConfirmInvest(context);
			//context.clickConfirmCancel(context);
			context.clickConfirmOk(context);
//			context.testAvalableAmmountAfterInvest(context);
			
		} catch (RuntimeException e) {
			Assert.assertTrue(false, e.getMessage());
		}
	}
}
