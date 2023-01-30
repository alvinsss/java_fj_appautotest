package com.fengjr.mobile.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fengjr.mobile.base.PageContext;

public class TestPatternModified extends TestCaseBase {
	
	/**
	 * 测试修改手势密码
	 */
	@Test
	public void testModifyPatternPassword() {
		try {
			PageContext context = new PageContext();
			context.goPersonalCenterPage(context);
			context.clickSettingIcon(context);
			context.clickModifyPatternPasswordItem(context);
			context.inputPasswordBeforeModified(context);
			
			context.drawPatternLock(context, new int[]{0, 1, 2, 3, 4, 6});
			context.drawPatternLock(context, new int[]{0, 1, 2, 3, 4, 6});
			
		} catch (RuntimeException e) {
			Assert.assertTrue(false, e.getMessage());
		}
	}
}
