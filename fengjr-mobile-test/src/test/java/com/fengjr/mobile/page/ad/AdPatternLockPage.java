package com.fengjr.mobile.page.ad;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import com.fengjr.mobile.base.PageContext;
import com.fengjr.mobile.page.HomePage;
import com.fengjr.mobile.page.PatternLockPage;
import com.fengjr.mobile.setting.Configurator;
import com.fengjr.mobile.utils.UiObject;

public class AdPatternLockPage implements PatternLockPage{
	
	public static By PATTERN_LOCK = By.id("com.fengjr.mobile:id/gesture");
	public static By PATTERN_HINT = By.id("com.fengjr.mobile:id/hint");
	public static By PATTERN_FORGET = By.id("com.fengjr.mobile:id/fogotGesture");
	public static By PATTERN_SWITCH_ACCOUNT = By.id("com.fengjr.mobile:id/changeAccount");
	public static By PATTERN_RELOGIN = By.id("com.fengjr.mobile:id/ok");
	public static By PATTERN_CANCEL_LOGIN = By.id("com.fengjr.mobile:id/cancel");
	
	@SuppressWarnings("static-access")
	public final static By[] ID = {By.id("com.fengjr.mobile:id/title").name("设置手势密码")};
	
	public AdPatternLockPage() {
		
	}


	@Override
	public boolean drawPatternLock(PageContext context, int[] pattern) {
		drawOnSquares(pattern);
		return true;
	}


	@Override
	public boolean goLoginPage(PageContext context) {
		UiObject.getAppiumDriver().resetApp();
		return false;
	}


	@Override
	public boolean goRegisterPage(PageContext context) {
		UiObject.getAppiumDriver().resetApp();
		return false;
	}


	@Override
	public boolean goHomPage(PageContext context) {
		drawPatternLock(context, new int[]{0, 1, 2, 3, 4});
		drawPatternLock(context, new int[]{0, 1, 2, 3, 4});
		context.update(HomePage.class);
		return false;
	}

	@Override
	public boolean goQRCodePage(PageContext context) {
		goHomPage(context);
		return false;
	}


	@Override
	public boolean goLoanPage(PageContext context) {
		goHomPage(context);
		return false;
	}


	@Override
	public boolean goSearchPage(PageContext context) {
		goHomPage(context);
		return false;
	}


	@Override
	public boolean goCrowdfundingPage(PageContext context) {
		goHomPage(context);
		return false;
	}


	@Override
	public boolean goPersonalCenterPage(PageContext context) {
		goHomPage(context);
		return false;
	}


	@Override
	public boolean goSettingPage(PageContext context) {
		goHomPage(context);
		return false;
	}


	@Override
	public boolean goInvestRecordPage(PageContext context) {
		goHomPage(context);
		return false;
	}


	@Override
	public boolean goMyCrowdfundingPage(PageContext context) {
		goHomPage(context);
		return false;
	}


	@Override
	public boolean goFundsRecordPage(PageContext context) {
		goHomPage(context);
		return false;
	}


	@Override
	public boolean goIncomeQueryPage(PageContext context) {
		goHomPage(context);
		return false;
	}


	@Override
	public boolean goBack(PageContext context) {
		UiObject.getAppiumDriver().navigate().back();
		return true;
	}


	@Override
	public boolean exitApp(PageContext context) {
		UiObject.getAppiumDriver().closeApp();
		return true;
	}

	/**
	 * 在屏幕锁上绘制模式 九宫格第一行从左到右编号为0，1，2，第二行从左到右编号3，4，6，最后一行从左到右编号为7，8，9
	 * 
	 * @param gridIndex
	 *            模式编号
	 */
	private void drawOnSquares(int[] grid) {

		assert (grid.length > 0);
		
		AppiumDriver appium = Configurator.instance().getAppiumDriver();
		
		WebElement element = appium.findElement(PATTERN_LOCK);
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
	 * 将模式编号转换成手机的坐标位置
	 * @param lockPanel
	 * @param index
	 * @return
	 */
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


	@Override
	public boolean goLatestAnnouncementPage(PageContext context) {
		goHomPage(context);
		return false;
	}


	@Override
	public boolean goAboutUsPage(PageContext context) {
		goHomPage(context);
		return false;
	}


	@Override
	public boolean goAddressInfoPage(PageContext context) {
		goHomPage(context);
		return false;
	}


	@Override
	public boolean goConfirmInvestPage(PageContext context) {
		goHomPage(context);
		return false;
	}


	@Override
	public boolean goConfirmSupportPage(PageContext context) {
		goHomPage(context);
		return false;
	}


	@Override
	public boolean goCrowdfundingDetailPage(PageContext context) {
		goHomPage(context);
		return false;
	}


	@Override
	public boolean goCrowdfundingProjectDetails(PageContext context) {
		goHomPage(context);
		return false;
	}


	@Override
	public boolean goFeedbackPage(PageContext context) {
		goHomPage(context);
		return false;
	}


	@Override
	public boolean goFundsRecord(PageContext context) {
		goHomPage(context);
		return false;
	}


	@Override
	public boolean goFundTrusteeshipAccountPage(PageContext context) {
		goHomPage(context);
		return false;
	}


	@Override
	public boolean goLatestNewsPage(PageContext context) {
		goHomPage(context);
		return false;
	}


	@Override
	public boolean goMediaReportPage(PageContext context) {
		goHomPage(context);
		return false;
	}


	@Override
	public boolean goPatternLockPage(PageContext context) {
		goHomPage(context);
		return false;
	}


	@Override
	public boolean goRepaymentPlan(PageContext context) {
		goHomPage(context);
		return false;
	}


	@Override
	public boolean goWelcomePage(PageContext context) {
		UiObject.getAppiumDriver().resetApp();
		return false;
	}


	@Override
	public By[] getIdentification() {
		Logger.getRootLogger().info("will be return " + getClass().getName() + " id:" + ID.toString());
		return ID;
	}
}
