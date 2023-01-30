package com.fengjr.android.uiobj;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fengjr.android.exception.UiObjectNotFoundException;

public class UiObject {

	private AppiumDriver appium;
	private Configurator config;
	private By selector;

	private UiObject() {
		config = Configurator.instance();
		appium = config.getAppiumDriver();
	}

	public UiObject(By by) {
		this();
		selector = by;
	}
	
	/**
	 * 向下滑动ListView
	 */
	public void scrollDown() {
		WebDriverWait wait = new WebDriverWait(appium, Configurator.TIMEOUT_LONG);
		WebElement listElm = wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
		Dimension dimension = listElm.getSize();
		Point point = listElm.getLocation();
		
		int x1 = point.x + dimension.width / 2;
		int y1 = point.y + dimension.height - dimension.height / 2;
		int x2 = x1;
		int y2 = point.y + dimension.height / 20;
		
		TouchAction touchAction = new TouchAction(appium);
		touchAction.press(x1, y1);
		for (int i = y1; i > y2; i-=20) {
			touchAction.moveTo(x2, i).waitAction(1);
		}
		touchAction.release();
		touchAction.perform();
	}
	
	/**
	 * 向上滑动ListView
	 */
	public void scrollUp() {
		WebDriverWait wait = new WebDriverWait(appium, Configurator.TIMEOUT_LONG);
		WebElement listElm = wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
		Dimension dimension = listElm.getSize();
		Point point = listElm.getLocation();
		
		int x1 = point.x + dimension.width / 2;
		int y1 = point.y + dimension.height - dimension.height / 20;
		int x2 = x1;
		int y2 = point.y + dimension.height / 20;
		
		TouchAction touchAction = new TouchAction(appium);
		touchAction.press(x2, y2);
		for (int i = y2; i > y1; i+=20) {
			touchAction.moveTo(x2, i).waitAction(1);
		}
		touchAction.release();
		touchAction.perform();		
	}

	/**
	 * 在屏幕锁上绘制模式 九宫格第一行从左到右编号为0，1，2，第二行从左到右编号3，4，6，最后一行从左到右编号为7，8，9
	 * 
	 * @param gridIndex
	 *            模式编号
	 * @param timeout
	 *            最大等待时长，单位秒
	 */
	public void drawOnSquares(int[] grid) {

		assert (grid.length > 0);
		
		WebElement element = appium.findElement(selector);
		TouchAction touchAction = new TouchAction(appium);

		Point position = toPosition(element, grid[0]);
		touchAction.press(position.x, position.y);
		for (int i = 0; i < grid.length; i++) {
			position = toPosition(element, grid[i]);
			touchAction.moveTo(position.x, position.y).waitAction(500);
		}
		touchAction.release();
		touchAction.perform();
	}
	
	/**
	 * 查看控件是否在当前界面显示，该函数立即返回
	 */
	public boolean exist() {
		try {
			appium.findElement(selector);
			return true;
		} catch (Throwable e) {
			return false;
		}
	}
	
	/**
	 * 等待控件消失
	 * @param timeout 超时，秒
	 * @return
	 */
	public boolean waitGone(long timeout) {
		
		try {
			WebDriverWait waitor = new WebDriverWait(Configurator.instance()
					.getAppiumDriver(), timeout);
			waitor.until(ExpectedConditions.invisibilityOfElementLocated(selector));
			return true;
		} catch (Throwable e) {
			return false;
		}
	}
	
	/**
	 * 等待控件出现
	 * @return
	 */
	public boolean waitFor() {
		return waitFor(Configurator.TIMEOUT_LONG);
	}
	
	/**
	 * 等待控件出现
	 * @param timeout
	 * @return
	 */
	public boolean waitFor(long timeout) {
		try {
			WebDriverWait waitor = new WebDriverWait(Configurator.instance()
					.getAppiumDriver(), timeout);
			waitor.until(ExpectedConditions.visibilityOfElementLocated(selector));
			return true;
		} catch (Throwable e) {
			return false;
		}
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

	// delegate methods

	public UiObject click() {
		WebElement element = appium.findElement(selector);
		element.click();
		return this;
	}

	public UiObject submit() {
		WebElement element = appium.findElement(selector);
		element.submit();
		return this;
	}

	public UiObject sendKeys(CharSequence... keysToSend) {
		WebElement element = appium.findElement(selector);
		element.sendKeys(keysToSend);
		return this;
	}

	public UiObject clear() {
		WebElement element = appium.findElement(selector);
		element.clear();
		return this;
	}

	public String getTagName() {
		WebElement element = appium.findElement(selector);
		return element.getTagName();
	}

	public String getAttribute(String name) {
		WebElement element = appium.findElement(selector);
		return element.getAttribute(name);
	}

	public boolean isSelected() {
		WebElement element = appium.findElement(selector);
		return element.isSelected();
	}

	public boolean isEnabled() {
		WebElement element = appium.findElement(selector);
		return element.isEnabled();
	}

	public String getText() {
		WebElement element = appium.findElement(selector);
		return element.getText();
	}

	public List<WebElement> findElements(By by) {
		WebElement element = appium.findElement(selector);
		return element.findElements(by);
	}

	public WebElement findElement(By by) {
		WebElement element = appium.findElement(selector);
		return element.findElement(by);
	}

	public boolean isDisplayed() {
		WebElement element = appium.findElement(selector);
		return element.isDisplayed();
	}

	public Point getLocation() {
		WebElement element = appium.findElement(selector);
		return element.getLocation();
	}

	public Dimension getSize() {
		WebElement element = appium.findElement(selector);
		return element.getSize();
	}

	public String getCssValue(String propertyName) {
		WebElement element = appium.findElement(selector);
		return element.getCssValue(propertyName);
	}

	// static methods

	/**
	 * 等待某视图出现
	 * 
	 * @param by
	 *            视图选择器
	 * @return
	 * @throws UiObjectNotFoundException
	 */
	public static UiObject waitFor(By by) throws UiObjectNotFoundException {
		return waitFor(by, Configurator.TIMEOUT_LONG);
	}

	/**
	 * 等待某视图出现
	 * 
	 * @param by
	 *            视图选择器
	 * @param msg
	 *            未找到视图时输出此消息
	 * @return
	 * @throws UiObjectNotFoundException
	 */
	public static UiObject waitFor(By by, String msg)
			throws UiObjectNotFoundException {
		return waitFor(by, Configurator.TIMEOUT_LONG, msg);
	}

	/**
	 * 等待某视图出现
	 * 
	 * @param by
	 *            视图选择器
	 * @param timeout
	 *            最大等待时长，单位秒
	 * @param msg
	 *            未找到视图时输出此消息
	 * @return
	 * @throws UiObjectNotFoundException
	 */
	public static UiObject waitFor(By by, long timeout)
			throws UiObjectNotFoundException {
		return waitFor(by, timeout, null);
	}

	/**
	 * 等待某视图出现
	 * 
	 * @param by
	 *            视图选择器
	 * @param timeout
	 *            最大等待时长，单位秒
	 * @return
	 * @throws UiObjectNotFoundException
	 */
	public static UiObject waitFor(By by, long timeout, String msg)
			throws UiObjectNotFoundException {
		try {
			WebDriverWait waitor = new WebDriverWait(Configurator.instance()
					.getAppiumDriver(), timeout);
			waitor.until(ExpectedConditions.visibilityOfElementLocated(by));
			return new UiObject(by);
		} catch (Throwable e) {
			String errorMessage = (msg == null ? "" : msg + ": ")
					+ by.toString() + " not found.";
			throw new UiObjectNotFoundException(errorMessage);
		}
	}

	/**
	 * 在当前界面查找视图
	 * 
	 * @param by
	 *            视图选择器
	 * @param timeout
	 *            查找的最大时长，单位秒
	 * @return
	 */
	public static boolean searchFor(By by) {
		return searchFor(by, Configurator.TIMEOUT_SHORT, false);
	}
	
	/**
	 * 在当前界面查找视图
	 * 
	 * @param by
	 *            视图选择器
	 * @param timeout
	 *            查找的最大时长，单位秒
	 *            
	 * 
	 * @return
	 */
	public static boolean searchFor(By by, boolean scroll) {
		return searchFor(by, Configurator.TIMEOUT_SHORT, scroll);
	}

	/**
	 * 在当前界面查找视图
	 * 
	 * @param by
	 *            视图选择器
	 * @param timeout
	 *            查找的最大时长，单位秒
	 * @return
	 */
	public static boolean searchFor(By by, long timeout, boolean scroll) {
		
		boolean result;
		int count = 0;
		while (true && count <= timeout) {
			try {
				WebDriverWait waitor = new WebDriverWait(Configurator.instance()
						.getAppiumDriver(), 1);
				count++;
				waitor.until(ExpectedConditions.visibilityOfElementLocated(by));
				result = true;
			} catch (Throwable e) {
				result = false;
			}
			if (scroll && result == false) {
				
				UiObject listView = new UiObject(By.className("android.widget.ListView"));
				UiObject scrollView = new UiObject(By.className("android.widget.ScrollView"));
				if (listView.exist()) {
					listView.scrollDown();
				} else if (scrollView.exist()){
					scrollView.scrollDown();
				} else {
					return result;
				}
			} else {
				return result;
			}
		}
		return false;
	}

}
