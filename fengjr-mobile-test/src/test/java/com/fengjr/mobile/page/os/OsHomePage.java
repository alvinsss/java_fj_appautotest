package com.fengjr.mobile.page.os;

import org.openqa.selenium.By;

import com.fengjr.mobile.base.PageContext;
import com.fengjr.mobile.page.HomePage;
import com.fengjr.mobile.page.LatestAnnouncementPage;
import com.fengjr.mobile.page.LatestNewsPage;
import com.fengjr.mobile.page.LoanPage;
import com.fengjr.mobile.page.PersonalCenterPage;
import com.fengjr.mobile.page.TabPage;
import com.fengjr.mobile.utils.UiObject;

public class OsHomePage implements HomePage, TabPage{
	
	private By TITLE = By.name("HomePageView");
	
	private By PUBLICATIONS = By.name("");
	private By MORE = By.name("moreText");
	
	public static By HOME_PAGE = By.name("ivIndex");
	public static By MONEY_PAGE = By.name("ivMoney");
	public static By FUNDING_PAGE = By.name("ivFunding");
	public static By CENTER_PAGE = By.name("ivCenter");
	
	public static By HOME_PAGE_S = By.name("ivIndexS");
	public static By MONEY_PAGE_S = By.name("ivMoneyS");
	public static By FUNDING_PAGE_S = By.name("ivFundingS");
	public static By CENTER_PAGE_S = By.name("ivCenterS");

	@Override
	public boolean clickAnnouncementTitle(PageContext context) {
		UiObject.waitFor(PUBLICATIONS).click();
		context.update(LatestAnnouncementPage.class);
		return true;
	}

	@Override
	public boolean clickAnnouncementMore(PageContext context) {
		UiObject.waitFor(MORE).click();
		context.update(LatestNewsPage.class);
		return true;
	}


	@Override
	public boolean clickQrcodeIcon(PageContext context) {
		// no this function in iOS
		return false;
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
		return true;
	}

	@Override
	public boolean goQRCodePage(PageContext context) {
		clickQrcodeIcon(context);
		return false;
	}

	@Override
	public boolean goLoanPage(PageContext context) {
		clickLoanTab(context);
		return false;
	}

	@Override
	public boolean goSearchPage(PageContext context) {
		clickLoanTab(context);
		return false;
	}

	@Override
	public boolean goCrowdfundingPage(PageContext context) {
		clickFundingTab(context);
		return false;
	}

	@Override
	public boolean goPersonalCenterPage(PageContext context) {
		clickPersonalCenterTab(context);
		return false;
	}

	@Override
	public boolean goSettingPage(PageContext context) {
		goPersonalCenterPage(context);
		return false;
	}

	@Override
	public boolean goInvestRecordPage(PageContext context) {
		goPersonalCenterPage(context);
		return false;
	}

	@Override
	public boolean goMyCrowdfundingPage(PageContext context) {
		goPersonalCenterPage(context);
		return false;
	}

	@Override
	public boolean goFundsRecordPage(PageContext context) {
		goPersonalCenterPage(context);
		return false;
	}

	@Override
	public boolean goIncomeQueryPage(PageContext context) {
		goPersonalCenterPage(context);
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
		clickAnnouncementTitle(context);
		return false;
	}

	@Override
	public boolean goAboutUsPage(PageContext context) {
		goPersonalCenterPage(context);
		return false;
	}

	@Override
	public boolean goAddressInfoPage(PageContext context) {
		goCrowdfundingPage(context);
		return false;
	}

	@Override
	public boolean goConfirmInvestPage(PageContext context) {
		goLoanPage(context);
		return false;
	}

	@Override
	public boolean goConfirmSupportPage(PageContext context) {
		goCrowdfundingPage(context);
		return false;
	}

	@Override
	public boolean goCrowdfundingDetailPage(PageContext context) {
		goCrowdfundingPage(context);
		return false;
	}

	@Override
	public boolean goCrowdfundingProjectDetails(PageContext context) {
		goCrowdfundingPage(context);
		return false;
	}

	@Override
	public boolean goFeedbackPage(PageContext context) {
		goPersonalCenterPage(context);
		return false;
	}

	@Override
	public boolean goFundsRecord(PageContext context) {
		goPersonalCenterPage(context);
		return false;
	}

	@Override
	public boolean goFundTrusteeshipAccountPage(PageContext context) {
		goPersonalCenterPage(context);
		return false;
	}

	@Override
	public boolean goLatestNewsPage(PageContext context) {
		clickAnnouncementMore(context);
		return false;
	}

	@Override
	public boolean goMediaReportPage(PageContext context) {
		clickAnnouncementMore(context);
		return false;
	}

	@Override
	public boolean goPatternLockPage(PageContext context) {
		UiObject.getAppiumDriver().resetApp();
		return false;
	}

	@Override
	public boolean goRepaymentPlan(PageContext context) {
		goPersonalCenterPage(context);
		return false;
	}

	@Override
	public boolean goWelcomePage(PageContext context) {
		UiObject.getAppiumDriver().resetApp();
		return false;
	}

	@Override
	public By[] getIdentification() {
		return new By[]{TITLE};
	}

	@Override
	public boolean clickHomeTab(PageContext context) {
		if (!UiObject.searchFor(HOME_PAGE_S)) {
			UiObject.waitFor(HOME_PAGE).click();
		}
		context.update(HomePage.class);
		return true;
	}

	@Override
	public boolean clickLoanTab(PageContext context) {
		if (!UiObject.searchFor(MONEY_PAGE_S)) {
			UiObject.waitFor(MONEY_PAGE).click();
		}
		context.update(LoanPage.class);
		return true;
	}

	@Override
	public boolean clickFundingTab(PageContext context) {
		if (!UiObject.searchFor(FUNDING_PAGE_S)) {
			UiObject.waitFor(FUNDING_PAGE).click();
		}
		context.update(null);
		return true;
	}

	@Override
	public boolean clickPersonalCenterTab(PageContext context) {
		if (!UiObject.searchFor(CENTER_PAGE_S)) {
			UiObject.waitFor(CENTER_PAGE).click();
		}
		context.update(PersonalCenterPage.class);
		return true;
	}

}
