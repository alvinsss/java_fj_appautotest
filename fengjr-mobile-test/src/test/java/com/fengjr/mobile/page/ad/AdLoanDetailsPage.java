package com.fengjr.mobile.page.ad;

import org.openqa.selenium.By;

import com.fengjr.mobile.base.PageContext;
import com.fengjr.mobile.page.ConfirmInvestPage;
import com.fengjr.mobile.page.LoanDetailsPage;
import com.fengjr.mobile.page.LoanPage;
import com.fengjr.mobile.utils.UiObject;

public class AdLoanDetailsPage implements LoanDetailsPage{
	
	//确认投资按钮
	private final static By INVEST = By.id("com.fengjr.mobile:id/confirmInvest");
	
	//等待dialog
	private final static By WAIT_DIALOG = By.id("com.fengjr.mobile:id/cancel");
	
	//页面标题
	private final static By TITLE = By.id("com.fengjr.mobile:id/title");
	
	//投资记录
	private final static By INVEST_RECORDER = By.id("com.fengjr.mobile:id/wtItemTitleInvestMethod");
	
	// 标题中返回按钮
	private final static By BACK = By.id("com.fengjr.mobile:id/left");
	
	public AdLoanDetailsPage() {
		
	}

	@Override
	public boolean goAboutUsPage(PageContext context) {
		goBack(context);
		return false;
	}

	@Override
	public boolean goAddressInfoPage(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean goConfirmInvestPage(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean goConfirmSupportPage(PageContext context) {
		// TODO Auto-generated method stub
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
		context.update(LoanPage.class);
		return true;
	}

	@Override
	public boolean exitApp(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public By[] getIdentification() {
		return new By[] {TITLE, INVEST_RECORDER};
	}

	@Override
	public boolean clickInvest(PageContext context) {
		UiObject.waitFor(INVEST).click();
		UiObject.waitGone(WAIT_DIALOG);
		context.update(ConfirmInvestPage.class);
		return true;
	}

	@Override
	public boolean clickInvestDetail(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean clickCollateralAgreement(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

}
