package com.fengjr.mobile.page.ad;

import org.openqa.selenium.By;

import com.fengjr.mobile.base.PageContext;
import com.fengjr.mobile.page.RegisterPage;

public class AdRegisterPage implements RegisterPage{
	
	public static By EDIT_USER_NAME = By.id("com.fengjr.mobile:id/loginName");
	public static By EDIT_MOBILE_NUMBER = By.id("com.fengjr.mobile:id/mobile");
	public static By EDIT_PASSWORD = By.id("com.fengjr.mobile:id/password");
	public static By EDIT_CONFIRM_PASSWORD = By.id("com.fengjr.mobile:id/confirm_password");
	public static By EDIT_VERIFY_CODE = By.id("com.fengjr.mobile:id/captcha");
	public static By BUTTON_VERIFY_CODE = By.id("com.fengjr.mobile:id/sendCaptcha");
	public static By LINK_AGREEMENT = By.id("com.fengjr.mobile:id/agreement");
	public static By BUTTON_NEXT_STEP = By.id("com.fengjr.mobile:id/nextStep");
	
	@SuppressWarnings("static-access")
	public final static By ID = By.id("com.fengjr.mobile:id/title").name("注册");
	
	public AdRegisterPage() {
		
	}

	@Override
	public boolean inputRegisterUsername(PageContext context, String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean inputRegisterMobilenumber(PageContext context,
			String mobilenumber) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean inputRegisterPassword(PageContext context, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean inputRegisterPasswordAgain(PageContext context,
			String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean inputRegisterVercode(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean clickRegisterNextStep(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean clickUserRegisterAggrement(PageContext context) {
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
	public boolean goLatestAnnouncementPage(PageContext context) {
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
	public By[] getIdentification() {
		// TODO Auto-generated method stub
		return null;
	}
}
