package com.fengjr.mobile.page.os;

import io.appium.java_client.MobileBy;

import org.openqa.selenium.By;

import com.fengjr.mobile.base.PageContext;
import com.fengjr.mobile.page.LoginPage;
import com.fengjr.mobile.page.WelcomePage;
import com.fengjr.mobile.setting.Settings;
import com.fengjr.mobile.utils.UiObject;

public class OsWelcomePage implements WelcomePage{
	
	private By PAGE_INDICATOR = By.className("UIAPageIndicator");
	private By GO = MobileBy.AccessibilityId("go");

	@Override
	public boolean skipWelcomePage(PageContext context) {
		
		if (UiObject.searchFor(PAGE_INDICATOR, Settings.TIMEOUT_WAIT_FOR_GO, null)) {
			int height = UiObject.getAppiumDriver().manage().window().getSize().getHeight();
			int width = UiObject.getAppiumDriver().manage().window().getSize().getWidth();
			
			UiObject.getAppiumDriver().swipe(width, height/2, width/4, height/2, 500);
			UiObject.getAppiumDriver().swipe(width, height/2, width/4, height/2, 500);
			UiObject.waitFor(GO).click();
		}
		context.update(LoginPage.class);
		return true;
	}

	@Override
	public boolean goLoginPage(PageContext context) {
		skipWelcomePage(context);
		return false;
	}

	@Override
	public boolean goRegisterPage(PageContext context) {
		skipWelcomePage(context);
		return false;
	}

	@Override
	public boolean goHomPage(PageContext context) {
		skipWelcomePage(context);
		return false;
	}

	@Override
	public boolean goQRCodePage(PageContext context) {
		skipWelcomePage(context);
		return false;
	}

	@Override
	public boolean goLoanPage(PageContext context) {
		skipWelcomePage(context);
		return false;
	}

	@Override
	public boolean goSearchPage(PageContext context) {
		skipWelcomePage(context);
		return false;
	}

	@Override
	public boolean goCrowdfundingPage(PageContext context) {
		skipWelcomePage(context);
		return false;
	}

	@Override
	public boolean goPersonalCenterPage(PageContext context) {
		skipWelcomePage(context);
		return false;
	}

	@Override
	public boolean goSettingPage(PageContext context) {
		skipWelcomePage(context);
		return false;
	}

	@Override
	public boolean goInvestRecordPage(PageContext context) {
		skipWelcomePage(context);
		return false;
	}

	@Override
	public boolean goMyCrowdfundingPage(PageContext context) {
		skipWelcomePage(context);
		return false;
	}

	@Override
	public boolean goFundsRecordPage(PageContext context) {
		skipWelcomePage(context);
		return false;
	}

	@Override
	public boolean goIncomeQueryPage(PageContext context) {
		skipWelcomePage(context);
		return false;
	}

	@Override
	public boolean goBack(PageContext context) {
		// ignore
		return true;
	}

	@Override
	public boolean exitApp(PageContext context) {
		UiObject.getAppiumDriver().closeApp();
		return false;
	}

	@Override
	public boolean goLatestAnnouncementPage(PageContext context) {
		skipWelcomePage(context);
		return false;
	}

	@Override
	public boolean goAboutUsPage(PageContext context) {
		skipWelcomePage(context);
		return false;
	}

	@Override
	public boolean goAddressInfoPage(PageContext context) {
		skipWelcomePage(context);
		return false;
	}

	@Override
	public boolean goConfirmInvestPage(PageContext context) {
		skipWelcomePage(context);
		return false;
	}

	@Override
	public boolean goConfirmSupportPage(PageContext context) {
		skipWelcomePage(context);
		return false;
	}

	@Override
	public boolean goCrowdfundingDetailPage(PageContext context) {
		skipWelcomePage(context);
		return false;
	}

	@Override
	public boolean goCrowdfundingProjectDetails(PageContext context) {
		skipWelcomePage(context);
		return false;
	}

	@Override
	public boolean goFeedbackPage(PageContext context) {
		skipWelcomePage(context);
		return false;
	}

	@Override
	public boolean goFundsRecord(PageContext context) {
		skipWelcomePage(context);
		return false;
	}

	@Override
	public boolean goFundTrusteeshipAccountPage(PageContext context) {
		skipWelcomePage(context);
		return false;
	}

	@Override
	public boolean goLatestNewsPage(PageContext context) {
		skipWelcomePage(context);
		return false;
	}

	@Override
	public boolean goMediaReportPage(PageContext context) {
		skipWelcomePage(context);
		return false;
	}

	@Override
	public boolean goPatternLockPage(PageContext context) {
		skipWelcomePage(context);
		return false;
	}

	@Override
	public boolean goRepaymentPlan(PageContext context) {
		skipWelcomePage(context);
		return false;
	}

	@Override
	public boolean goWelcomePage(PageContext context) {
		return true;
	}

	@Override
	public By[] getIdentification() {
		return new By[]{PAGE_INDICATOR};
	}
}
