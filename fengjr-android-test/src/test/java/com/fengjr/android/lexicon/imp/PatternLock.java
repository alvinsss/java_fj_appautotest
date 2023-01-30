package com.fengjr.android.lexicon.imp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fengjr.android.lexicon.IPatternLock;

public class PatternLock implements IPatternLock{
	
	private AppiumDriver appium;
	
	public PatternLock (AppiumDriver appium) {
		this.appium = appium;
	}
	
	/**
	 * 在屏幕锁上绘制模式
	 * 九宫格第一行从左到右编号为0，1，2，第二行从左到右编号3，4，6，最后一行从左到右编号为7，8，9
	 * @param gridIndex 模式编号
	 * @param timeout 最大等待时长，单位秒
	 */
	@Override
	public void drawPattern(int[] grid, long timeout) {
		
		assert(grid.length > 0);
		
		By locator = By.id("com.fengjr.mobile:id/gesture");
		WebDriverWait wait = new WebDriverWait(appium, timeout);
		WebElement touchPanel = wait.until(ExpectedConditions
				.visibilityOfElementLocated(locator));
		
		TouchAction touchAction = new TouchAction(appium);
		
		Point position = toPosition(touchPanel, grid[0]);
		touchAction.press(position.x, position.y);
		for (int i = 0; i < grid.length; i++) {
			position = toPosition(touchPanel, grid[i]);
			System.out.println(position);
			touchAction.moveTo(position.x, position.y).waitAction(500);
		}
		touchAction.release();
		touchAction.perform();
	}
	
	// private methods
	
	private Point toPosition(WebElement lockPanel, int index) {

		Point point = lockPanel.getLocation();
		Dimension dimension = lockPanel.getSize();

		int cellWidth = dimension.getWidth() / 3;
		int cellHeight = dimension.getHeight() / 3;

		int xi = index % 3;
		int yi = index / 3;

		int x = point.x + xi * cellWidth + cellWidth / 2;
		int y = point.y + yi * cellHeight + cellHeight / 2;

		Point position = new Point(x, y);

		return position;
	}

}
