package com.fengjr.mobile.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fengjr.mobile.base.PageContext;

public class TestFundingLike extends TestCaseBase{

	@Test
	public void testFundingLike() {
		try {
			PageContext context = new PageContext();
			context.goCrowdfundingPage(context);
			context.clickCrowdfundingItem(context, "0003发版前测试海洋");
			context.clickLike(context);
			context.clickZan(context);
			context.exitApp(context);
			context.goCrowdfundingPage(context);
			context.clickCrowdfundingItem(context, "0003发版前测试海洋");
			
//			context.testLikeNumberAfterClickLick(context);
//			context.testZanNumberAfterClickZan(context);
			
		} catch (RuntimeException e) {
			Assert.assertTrue(false, e.getMessage());
		}
	}
}
