package com.fengjr.android.lexicon;

import org.openqa.selenium.By;

public interface IPatternLock {
	
	public static By PATTERN_LOCK = By.id("com.fengjr.mobile:id/gesture");
	public static By PATTERN_HINT = By.id("com.fengjr.mobile:id/hint");
	public static By PATTERN_FORGET = By.id("com.fengjr.mobile:id/fogotGesture");
	public static By PATTERN_SWITCH_ACCOUNT = By.id("com.fengjr.mobile:id/changeAccount");
	public static By PATTERN_RELOGIN = By.id("com.fengjr.mobile:id/ok");
	public static By PATTERN_CANCEL_LOGIN = By.id("com.fengjr.mobile:id/cancel");
	
	/**
	 * 在屏幕锁上绘制模式
	 * 九宫格第一行从左到右编号为0，1，2，第二行从左到右编号3，4，6，最后一行从左到右编号为7，8，9
	 * @param gridIndex 模式编号
	 * @param waiter
	 */
	void drawPattern(int[] grid, long timeout);
}
