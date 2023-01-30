package com.fengjr.mobile.page.os;

import org.openqa.selenium.By;

import com.fengjr.mobile.base.PageContext;
import com.fengjr.mobile.exception.UnknowPageException;
import com.fengjr.mobile.page.UnknowPage;

public class OsUnknowPage implements UnknowPage{
	
	private void error(String message) {
		throw new UnknowPageException(message);
	}

	@Override
	public By[] getIdentification() {
		error("Unknow Page");
		return null;
	}

	@Override
	public boolean goAboutUsPage(PageContext context) {
		error("Unknow Page");
		return false;
	}

	@Override
	public boolean goAddressInfoPage(PageContext context) {
		error("Unknow Page");
		return false;
	}

	@Override
	public boolean goConfirmInvestPage(PageContext context) {
		error("Unknow Page");
		return false;
	}

	@Override
	public boolean goConfirmSupportPage(PageContext context) {
		error("Unknow Page");
		return false;
	}

	@Override
	public boolean goCrowdfundingDetailPage(PageContext context) {
		error("Unknow Page");
		return false;
	}

	@Override
	public boolean goCrowdfundingProjectDetails(PageContext context) {
		error("Unknow Page");
		return false;
	}

	@Override
	public boolean goFeedbackPage(PageContext context) {
		error("Unknow Page");
		return false;
	}

	@Override
	public boolean goFundsRecord(PageContext context) {
		error("Unknow Page");
		return false;
	}

	@Override
	public boolean goFundTrusteeshipAccountPage(PageContext context) {
		error("Unknow Page");
		return false;
	}

	@Override
	public boolean goLatestNewsPage(PageContext context) {
		error("Unknow Page");
		return false;
	}

	@Override
	public boolean goMediaReportPage(PageContext context) {
		error("Unknow Page");
		return false;
	}

	@Override
	public boolean goPatternLockPage(PageContext context) {
		error("Unknow Page");
		return false;
	}

	@Override
	public boolean goRepaymentPlan(PageContext context) {
		error("Unknow Page");
		return false;
	}

	@Override
	public boolean goWelcomePage(PageContext context) {
		error("Unknow Page");
		return false;
	}

	@Override
	public boolean goLoginPage(PageContext context) {
		error("Unknow Page");
		return false;
	}

	@Override
	public boolean goRegisterPage(PageContext context) {
		error("Unknow Page");
		return false;
	}

	@Override
	public boolean goHomPage(PageContext context) {
		error("Unknow Page");
		return false;
	}

	@Override
	public boolean goQRCodePage(PageContext context) {
		error("Unknow Page");
		return false;
	}

	@Override
	public boolean goLoanPage(PageContext context) {
		error("Unknow Page");
		return false;
	}

	@Override
	public boolean goSearchPage(PageContext context) {
		error("Unknow Page");
		return false;
	}

	@Override
	public boolean goCrowdfundingPage(PageContext context) {
		error("Unknow Page");
		return false;
	}

	@Override
	public boolean goPersonalCenterPage(PageContext context) {
		error("Unknow Page");
		return false;
	}

	@Override
	public boolean goSettingPage(PageContext context) {
		error("Unknow Page");
		return false;
	}

	@Override
	public boolean goInvestRecordPage(PageContext context) {
		error("Unknow Page");
		return false;
	}

	@Override
	public boolean goMyCrowdfundingPage(PageContext context) {
		error("Unknow Page");
		return false;
	}

	@Override
	public boolean goFundsRecordPage(PageContext context) {
		error("Unknow Page");
		return false;
	}

	@Override
	public boolean goIncomeQueryPage(PageContext context) {
		error("Unknow Page");
		return false;
	}

	@Override
	public boolean goLatestAnnouncementPage(PageContext context) {
		error("Unknow Page");
		return false;
	}

	@Override
	public boolean goBack(PageContext context) {
		error("Unknow Page");
		return false;
	}

	@Override
	public boolean exitApp(PageContext context) {
		error("Unknow Page");
		return false;
	}

}
