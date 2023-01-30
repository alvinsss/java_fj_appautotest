package com.fengjr.mobile.page.ad;

import org.openqa.selenium.By;

import com.fengjr.mobile.base.PageContext;
import com.fengjr.mobile.page.FeedbackPage;

public class AdFeedbackPage implements FeedbackPage{
	
	// 反馈建议
	public By FEEDBACK = By.id("com.fengjr.mobile:id/feedback");
	// 姓名
	public By NAME = By.id("com.fengjr.mobile:id/contactName");
	// 联系方式
	public By CONTACT = By.id("com.fengjr.mobile:id/contact");
	// 提交按钮
	public By COMMIT = By.id("com.fengjr.mobile:id/commit");
	
	public AdFeedbackPage() {
		
	}

	@Override
	public boolean inputSuggestion(PageContext context, String suggestion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean inputContactInfo(PageContext context, String contractInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean clickSumitFeedback(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean inputFeedbackName(PageContext context, String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean goAboutUsPage(PageContext context) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean goCrowdfundingProjectDetails(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean goFeedbackPage(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean goFundsRecord(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean goFundTrusteeshipAccountPage(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean goLatestNewsPage(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean goMediaReportPage(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean goPatternLockPage(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean goRepaymentPlan(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean goWelcomePage(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean goLoginPage(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean goRegisterPage(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean goHomPage(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean goQRCodePage(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean goLoanPage(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean goSearchPage(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean goCrowdfundingPage(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean goPersonalCenterPage(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean goSettingPage(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean goInvestRecordPage(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean goMyCrowdfundingPage(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean goFundsRecordPage(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean goIncomeQueryPage(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean goLatestAnnouncementPage(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean goBack(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean exitApp(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public By[] getIdentification() {
		// TODO Auto-generated method stub
		return null;
	}

}
