package com.fengjr.mobile.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fengjr.mobile.base.PageContext;

public class BTestLatestNews extends TestCaseBase{
	
	/**
	 * 查看首页最新动态
	 */
	@Test
	public void testLatestNews() {
		
		try {
			PageContext context = new PageContext();
			
			context.goHomPage(context);
//			context.testAnnouncementCarousel(context);
			
			context.clickAnnouncementTitle(context);
//			context.testAnnouncementPageDataConsistency(context);
			
			context.clickAnnouncementMore(context);
//			context.testLatestAnnouncementOrder(context);
//			context.testLatestMediaReportOrder(context);
			
		} catch (RuntimeException e) {
			Assert.assertTrue(false, e.getMessage());
		}
	}

}
