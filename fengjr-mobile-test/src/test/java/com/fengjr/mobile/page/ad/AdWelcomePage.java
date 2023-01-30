package com.fengjr.mobile.page.ad;

import org.openqa.selenium.By;
import org.testng.log4testng.Logger;

import com.fengjr.mobile.base.PageContext;
import com.fengjr.mobile.factory.PageFactory;
import com.fengjr.mobile.page.LoginPage;
import com.fengjr.mobile.page.WelcomePage;
import com.fengjr.mobile.setting.Settings;
import com.fengjr.mobile.utils.UiObject;

public class AdWelcomePage implements WelcomePage{
	
	public final static By IMAGE_BYCLE = By.id("com.fengjr.mobile:id/bycleView");
	public final static By IMAGE_HOUSE = By.id("com.fengjr.mobile:id/house");
	public final static By IMAGE_EARTH = By.id("com.fengjr.mobile:id/earthView");
	public final static By BUTTON_GO = By.id("com.fengjr.mobile:id/go");
	public final static By NEXT = By.id("com.fengjr.mobile:id/next_btn");
	
	public final static By[] ID = {BUTTON_GO};
	
	public AdWelcomePage() {
		Logger.getLogger(AdWelcomePage.class).info("Android welcome page object created.");
	}
	
	@Override
	public boolean skipWelcomePage(PageContext context) {
		UiObject.waitFor(BUTTON_GO, Settings.TIMEOUT_WAIT_FOR_GO).click();
		if (UiObject.searchFor(NEXT)) {
			UiObject.waitFor(NEXT).click();
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
		return ID;
	}
}
