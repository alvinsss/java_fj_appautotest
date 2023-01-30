package com.fengjr.mobile.test;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fengjr.mobile.base.PageContext;

public class HFeedback extends TestCaseBase {
	
	@Test
	public void testFeedback() {
		try {
			PageContext context = new PageContext();
			context.goPersonalCenterPage(context);
			context.clickSettingIcon(context);
			context.clickFeedbackItem(context);
			context.inputSuggestion(context, "Automation-add suggestion");
			context.inputFeedbackName(context, "automation");
			context.inputContactInfo(context, "automation");
			context.clickSumitFeedback(context);
		} catch (RuntimeException e) {
			Assert.assertTrue(false, e.getMessage());
		}
	}

}
