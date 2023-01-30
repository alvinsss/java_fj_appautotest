package com.fengjr.mobile.page.ad;

import org.openqa.selenium.By;

import com.fengjr.mobile.base.PageContext;
import com.fengjr.mobile.page.PatternLockPage;
import com.fengjr.mobile.page.SettingPage;
import com.fengjr.mobile.setting.Configurator;
import com.fengjr.mobile.utils.UiObject;

public class AdSettingPage implements SettingPage{
	
	//页面顶部标题
	@SuppressWarnings("static-access")
	private static By TITLE = By.id("com.fengjr.mobile:id/title").name("设置");
	
	//修改手势密码
	private static By REVISE_GESTURE = By.id("com.fengjr.mobile:id/reviseGesture");
	private static By UPAYMENT_ACCOUNT = By.id("com.fengjr.mobile:id/manageUpaymentAccount");
	private static By ABOUT = By.id("com.fengjr.mobile:id/about");
	private static By VERSION = By.id("com.fengjr.mobile:id/version");
	private static By FEEDBACK = By.id("com.fengjr.mobile:id/feedback");
	private static By HOTLINE = By.id("com.fengjr.mobile:id/hotline");
	private static By QUIT = By.id("com.fengjr.mobile:id/quit");
	
	//登录密码输入框
	private static By PASWORD_EDITOR = By.id("com.fengjr.mobile:id/etPassword");
	private static By PASWORD_OK = By.id("com.fengjr.mobile:id/ok");
	private static By PASWORD_CANCEL = By.id("com.fengjr.mobile:id/cancel");
	
	public AdSettingPage() {
		
	}

	@Override
	public boolean clickModifyPatternPasswordItem(PageContext context) {
		UiObject.waitFor(REVISE_GESTURE).click();
		return true;
	}

	@Override
	public boolean clickFundTrusteeshipAccountItem(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean clickAboutUsItem(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean clickCheckUpdateItem(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean clickFeedbackItem(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean clickServiceHotlineItem(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean exitCurrentAccount(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean inputPasswordBeforeModified(PageContext context) {
		String password = Configurator.instance().getParamters().get(Configurator.LOGIN_PASSWORD);
		UiObject.waitFor(PASWORD_EDITOR).sendKeys(password);
		UiObject.waitFor(PASWORD_OK).click();
		context.update(PatternLockPage.class);
		return true;
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
		return true;
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
		return new By[]{TITLE};
	}
}
