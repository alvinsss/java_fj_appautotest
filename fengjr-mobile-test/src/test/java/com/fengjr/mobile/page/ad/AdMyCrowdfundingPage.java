package com.fengjr.mobile.page.ad;

import org.openqa.selenium.By;

import com.fengjr.mobile.base.PageContext;
import com.fengjr.mobile.page.MyCrowdfundingPage;
import com.fengjr.mobile.page.PersonalCenterPage;
import com.fengjr.mobile.utils.UiObject;

public class AdMyCrowdfundingPage implements MyCrowdfundingPage{
	
	//页顶标题
	@SuppressWarnings("static-access")
	private By TITLE = By.id("com.fengjr.mobile:id/title").name("我的众筹");
	//支持的众筹
	private By PROJECT_A = By.id("com.fengjr.mobile:id/ivProjectA");
	//关注的众筹
	private By PROJECT_B = By.id("com.fengjr.mobile:id/ivProjectB");
	// 返回
	private By BACK = By.id("com.fengjr.mobile:id/left");

	@Override
	public By[] getIdentification() {
		return new By[]{TITLE};
	}

	@Override
	public boolean goAboutUsPage(PageContext context) {
		goBack(context);
		return false;
	}

	@Override
	public boolean goAddressInfoPage(PageContext context) {
		goBack(context);
		return false;
	}

	@Override
	public boolean goConfirmInvestPage(PageContext context) {
		goBack(context);
		return false;
	}

	@Override
	public boolean goConfirmSupportPage(PageContext context) {
		goBack(context);
		return false;
	}

	@Override
	public boolean goCrowdfundingDetailPage(PageContext context) {
		goBack(context);
		return false;
	}

	@Override
	public boolean goCrowdfundingProjectDetails(PageContext context) {
		goBack(context);
		return false;
	}

	@Override
	public boolean goFeedbackPage(PageContext context) {
		goBack(context);
		return false;
	}

	@Override
	public boolean goFundsRecord(PageContext context) {
		goBack(context);
		return false;
	}

	@Override
	public boolean goFundTrusteeshipAccountPage(PageContext context) {
		goBack(context);
		return false;
	}

	@Override
	public boolean goLatestNewsPage(PageContext context) {
		goBack(context);
		return false;
	}

	@Override
	public boolean goMediaReportPage(PageContext context) {
		goBack(context);
		return false;
	}

	@Override
	public boolean goPatternLockPage(PageContext context) {
		goBack(context);
		return false;
	}

	@Override
	public boolean goRepaymentPlan(PageContext context) {
		goBack(context);
		return false;
	}

	@Override
	public boolean goWelcomePage(PageContext context) {
		goBack(context);
		return false;
	}

	@Override
	public boolean goLoginPage(PageContext context) {
		goBack(context);
		return false;
	}

	@Override
	public boolean goRegisterPage(PageContext context) {
		goBack(context);
		return false;
	}

	@Override
	public boolean goHomPage(PageContext context) {
		goBack(context);
		return false;
	}

	@Override
	public boolean goQRCodePage(PageContext context) {
		goBack(context);
		return false;
	}

	@Override
	public boolean goLoanPage(PageContext context) {
		goBack(context);
		return false;
	}

	@Override
	public boolean goSearchPage(PageContext context) {
		goBack(context);
		return false;
	}

	@Override
	public boolean goCrowdfundingPage(PageContext context) {
		goBack(context);
		return false;
	}

	@Override
	public boolean goPersonalCenterPage(PageContext context) {
		goBack(context);
		return false;
	}

	@Override
	public boolean goSettingPage(PageContext context) {
		goBack(context);
		return false;
	}

	@Override
	public boolean goInvestRecordPage(PageContext context) {
		goBack(context);
		return false;
	}

	@Override
	public boolean goMyCrowdfundingPage(PageContext context) {
		goBack(context);
		return false;
	}

	@Override
	public boolean goFundsRecordPage(PageContext context) {
		goBack(context);
		return false;
	}

	@Override
	public boolean goIncomeQueryPage(PageContext context) {
		goBack(context);
		return false;
	}

	@Override
	public boolean goLatestAnnouncementPage(PageContext context) {
		goBack(context);
		return false;
	}

	@Override
	public boolean goBack(PageContext context) {
		UiObject.waitFor(BACK).click();
		context.update(PersonalCenterPage.class);
		return true;
	}

	@Override
	public boolean exitApp(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

}
