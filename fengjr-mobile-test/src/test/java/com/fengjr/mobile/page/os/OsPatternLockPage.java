package com.fengjr.mobile.page.os;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.fengjr.mobile.base.PageContext;
import com.fengjr.mobile.page.HomePage;
import com.fengjr.mobile.page.LoginPage;
import com.fengjr.mobile.page.PatternLockPage;
import com.fengjr.mobile.setting.Configurator;
import com.fengjr.mobile.utils.UiObject;

public class OsPatternLockPage implements PatternLockPage{
	
	private By ID = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[10]");
	//private By TITLE = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]");
	private By FOGOT_GESTURE = By.name("fogotGesture");
	private By CHANGE_ACCOUNT = By.name("changeAccount");

	@Override
	public boolean drawPatternLock(PageContext context, int[] pattern) {
		drawOnSquares(pattern);
		return true;
	}

	@Override
	public boolean goLoginPage(PageContext context) {
		UiObject.waitFor(CHANGE_ACCOUNT).click();
		context.update(LoginPage.class);
		return false;
	}

	@Override
	public boolean goRegisterPage(PageContext context) {
		UiObject.waitFor(CHANGE_ACCOUNT).click();
		context.update(LoginPage.class);
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
		return new By[]{ID};
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
		TouchAction touchAction = new TouchAction(appium);

		int index = 10;
		WebElement cell = null;
		for (int i = 0; i < grid.length; i++) {
			index = 10 + i;
			String xpath = String.format("//UIAApplication[1]/UIAWindow[1]/UIAButton[%d]", index);
			cell = appium.findElement(By.xpath(xpath));
			if (i == 0) touchAction.press(cell);
			else touchAction.moveTo(cell);
		}
		touchAction.release();
		touchAction.perform();
	}
}
