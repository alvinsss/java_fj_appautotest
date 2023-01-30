package com.fengjr.mobile.page.ad;

import org.openqa.selenium.By;

import com.fengjr.mobile.base.PageContext;
import com.fengjr.mobile.page.AddressInfoPage;

public class AdAddressInfoPage implements AddressInfoPage{
	//真实姓名
	public By REALNAME = By.id("com.fengjr.mobile:id/realname");
	//手机号码
	public By MOBILE = By.id("com.fengjr.mobile:id/contact");
	//邮箱
	public By EMAILE = By.id("com.fengjr.mobile:id/email");
	//详细地址
	public By ADDRES_DETAILS = By.id("com.fengjr.mobile:id/shippingAddress");
	//发票开关
	public By INVOCE_SWITCH = By.id("com.fengjr.mobile:id/rb_with_invoice");
	//发票抬头
	public By INVOCE_TITLE = By.id("com.fengjr.mobile:id/invoce_info");
	//提交按钮
	public By COMMIT_BUTTON = By.id("com.fengjr.mobile:id/commit");
	
	public AdAddressInfoPage() {
		
	}

	@Override
	public boolean inputName(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean inputMobile(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean inputEmail(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean inputAddress(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean inputInvoiceTitle(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean enableInvoice(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean disableInvoice(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean clickSubmit(PageContext context) {
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
