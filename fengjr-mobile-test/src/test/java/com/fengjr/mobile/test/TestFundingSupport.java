package com.fengjr.mobile.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fengjr.mobile.base.PageContext;

public class TestFundingSupport extends TestCaseBase {

	@Test
	public void testFundingSupport() {
		try {
			PageContext context = new PageContext();
			
			context.goPersonalCenterPage(context);
			
			String currentAmmount = context.getBlanceAvaliable(context);
			
			context.goCrowdfundingPage(context);
			context.clickCrowdfundingItem(context, "0003发版前测试海洋");
			context.clickIwannaSupport(context, 0);
			double supportAmmount = context.clickSupport(context);
			
			context.goPersonalCenterPage(context);
			
			double expectedAmmount = Double.parseDouble(currentAmmount) - supportAmmount;
//			context.testAvaliableAmmount(context, expectedAmmount);
			
			context.clickMyCrowdfunding(context);
//			context.testFundingItemExist(context, Type.FUNDING_SUPPORT, "0003发版前测试海洋");
			
		} catch (RuntimeException e) {
			Assert.assertTrue(false, e.getMessage());
		}
	}
}
