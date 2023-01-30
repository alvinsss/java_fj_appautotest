package com.fengjr.android.test;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fengjr.android.exception.UiObjectNotFoundException;
import com.fengjr.android.lexicon.IHomePage;
import com.fengjr.android.lexicon.IPatternLock;
import com.fengjr.android.uiobj.UiObject;

public class BPatternLock extends TestCaseBase{
	
	/**
	 * 进入屏幕锁界面
	 * @throws UiObjectNotFoundException 
	 */
	@BeforeMethod
	public void beforeMethod() throws UiObjectNotFoundException {
		System.out.println("beformethod");
		getNavigator().enterPatternLock();
	}

	/**
	 * 2.1.1 绘制两次相同手势，可成功设置
	 * @throws UiObjectNotFoundException 
	 */
	@Test
	public void testDrawSamePattern() throws UiObjectNotFoundException {
		System.out.println("testDrawSampePattern");		
		UiObject.waitFor(IPatternLock.PATTERN_LOCK).drawOnSquares(new int[]{0, 1, 2, 5});
		String actual = UiObject.waitFor(IPatternLock.PATTERN_HINT).getText();
		String expected = "再次绘制解锁图案";
		Assert.assertEquals(expected, actual);
		
		UiObject.waitFor(IPatternLock.PATTERN_LOCK).drawOnSquares(new int[]{0, 1, 2, 5});
		boolean result = UiObject.searchFor(IHomePage.HOME_PAGE_S);
		Assert.assertTrue("绘制两次相同的解锁密码失败", result);
	}
	
	/**
	 * 2.1.2 绘制第二次手势密码与第一次不同，
	 * 		 提示用户与上次绘制不一致，请重新绘制
	 * @throws UiObjectNotFoundException 
	 */
	@Test
	public void testDrawDiffPattern() throws UiObjectNotFoundException {
		UiObject.waitFor(IPatternLock.PATTERN_LOCK).drawOnSquares(new int[]{0, 3, 6, 7});
		UiObject.waitFor(IPatternLock.PATTERN_LOCK).drawOnSquares(new int[]{0, 1, 2, 5});
		String actual = UiObject.waitFor(IPatternLock.PATTERN_HINT).getText();
		String expected = "二次输入不一致,请重新输入";
		Assert.assertEquals(expected, actual);
	}
	
	/**
	 * 2.1.3 绘制重复连接同一点的手势
	 * 		 可成功设置手势
	 * @throws UiObjectNotFoundException 
	 */
	@Test
	public void testDrawOnePoint() throws UiObjectNotFoundException {
		UiObject.waitFor(IPatternLock.PATTERN_LOCK).drawOnSquares(new int[]{1,1});
		String actual = UiObject.waitFor(IPatternLock.PATTERN_HINT).getText();
		String expected = "绘制的密码长度小于4";
		Assert.assertEquals(expected, actual);
	}
	
	/**
	 * 2.1.4 绘制一个连接起所有点的手势，可成功设置手势密码
	 * @throws UiObjectNotFoundException 
	 */
	@Test
	public void testDrawAllPoints() throws UiObjectNotFoundException {
		UiObject.waitFor(IPatternLock.PATTERN_LOCK).drawOnSquares(new int[]{2,4,6,3,0,1,5,8,7});		
		String actual = UiObject.waitFor(IPatternLock.PATTERN_HINT).getText();
		String expected = "再次绘制解锁图案";
		Assert.assertEquals(expected, actual);
		
		UiObject.waitFor(IPatternLock.PATTERN_LOCK).drawOnSquares(new int[]{2,4,6,3,0,1,5,8,7});		
		boolean result = UiObject.searchFor(IHomePage.HOME_PAGE_S);
		Assert.assertTrue("绘制连接所有点的手势密码失败", result);
	}
	
}
  