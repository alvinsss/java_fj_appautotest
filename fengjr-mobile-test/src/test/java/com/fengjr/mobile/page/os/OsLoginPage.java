package com.fengjr.mobile.page.os;

import org.openqa.selenium.By;

import com.fengjr.mobile.base.PageContext;
import com.fengjr.mobile.page.LoginPage;
import com.fengjr.mobile.page.PatternLockPage;
import com.fengjr.mobile.page.RegisterPage;
import com.fengjr.mobile.setting.Configurator;
import com.fengjr.mobile.utils.UiObject;

public class OsLoginPage implements LoginPage{

	public static By MOBILE = By.name("mobile");
	public static By PASSWORD = By.name("password");
	public static By LOGIN = By.name("login");
	public static By RIGISTER = By.name("register");
	public static By TIP = By.name("MBProgressHUD.bundle/error.png");

	@Override
	public boolean clickRegisterButton(PageContext context) {
		
		UiObject.waitFor(RIGISTER).click();
		context.update(RegisterPage.class);
		
		return true;
	}

	@Override
	public boolean login(PageContext context, String mobile, String password, int loginEvn) {
		
		inputMobileNumber(mobile);
		inputPassword(password);
		clickLoginButton();
		UiObject.waitGone(TIP);
		context.update(PatternLockPage.class);

		return true;
	}

	@Override
	public boolean changePlatform(PageContext context, int type) {
		// iOS ignore
		return false;
	}

	@Override
	public boolean goLoginPage(PageContext context) {
		return true;
	}

	@Override
	public boolean goRegisterPage(PageContext context) {
		clickRegisterButton(context);
		return false;
	}

	@Override
	public boolean goHomPage(PageContext context) {
		String mobile = Configurator.instance().getParamters()
				.get(Configurator.LOGIN_MOBILE_NUMBER);
		String password = Configurator.instance().getParamters()
				.get(Configurator.LOGIN_PASSWORD);
		login(context, mobile, password, -1);
		context.update(PatternLockPage.class);
		return false;
	}

	@Override
	public boolean goQRCodePage(PageContext context) {
		goHomPage(context);
		return false;
	}

	@Override
	public boolean goLoanPage(PageContext context) {
		goHomPage(context);
		return false;
	}

	@Override
	public boolean goSearchPage(PageContext context) {
		goHomPage(context);
		return false;
	}

	@Override
	public boolean goCrowdfundingPage(PageContext context) {
		goHomPage(context);
		return false;
	}

	@Override
	public boolean goPersonalCenterPage(PageContext context) {
		goHomPage(context);
		return false;
	}

	@Override
	public boolean goSettingPage(PageContext context) {
		goHomPage(context);
		return false;
	}

	@Override
	public boolean goInvestRecordPage(PageContext context) {
		goHomPage(context);
		return false;
	}

	@Override
	public boolean goMyCrowdfundingPage(PageContext context) {
		goHomPage(context);
		return false;
	}

	@Override
	public boolean goFundsRecordPage(PageContext context) {
		goHomPage(context);
		return false;
	}

	@Override
	public boolean goIncomeQueryPage(PageContext context) {
		goHomPage(context);
		return false;
	}

	@Override
	public boolean goBack(PageContext context) {
		// iOS ignore
		return false;
	}

	@Override
	public boolean exitApp(PageContext context) {
		UiObject.getAppiumDriver().closeApp();
		return true;
	}
	
	@Override
	public boolean goLatestAnnouncementPage(PageContext context) {
		goHomPage(context);
		return false;
	}

	@Override
	public boolean goAboutUsPage(PageContext context) {
		goHomPage(context);
		return false;
	}

	@Override
	public boolean goAddressInfoPage(PageContext context) {
		goHomPage(context);
		return false;
	}

	@Override
	public boolean goConfirmInvestPage(PageContext context) {
		goHomPage(context);
		return false;
	}

	@Override
	public boolean goConfirmSupportPage(PageContext context) {
		goHomPage(context);
		return false;
	}

	@Override
	public boolean goCrowdfundingDetailPage(PageContext context) {
		goHomPage(context);
		return false;
	}

	@Override
	public boolean goCrowdfundingProjectDetails(PageContext context) {
		goHomPage(context);
		return false;
	}

	@Override
	public boolean goFeedbackPage(PageContext context) {
		goHomPage(context);
		return false;
	}

	@Override
	public boolean goFundsRecord(PageContext context) {
		goHomPage(context);
		return false;
	}

	@Override
	public boolean goFundTrusteeshipAccountPage(PageContext context) {
		goHomPage(context);
		return false;
	}

	@Override
	public boolean goLatestNewsPage(PageContext context) {
		goHomPage(context);
		return false;
	}

	@Override
	public boolean goMediaReportPage(PageContext context) {
		goHomPage(context);
		return false;
	}

	@Override
	public boolean goPatternLockPage(PageContext context) {
		goHomPage(context);
		return false;
	}

	@Override
	public boolean goRepaymentPlan(PageContext context) {
		goHomPage(context);
		return false;
	}

	@Override
	public boolean goWelcomePage(PageContext context) {
		UiObject.getAppiumDriver().resetApp();
		return true;
	}

	@Override
	public By[] getIdentification() {
		return new By[] {MOBILE, PASSWORD};
	}
	

	// 输入手机号码
	private void inputMobileNumber(String mn) {
		UiObject.waitFor(MOBILE).click();
		UiObject.waitFor(MOBILE).sendKeys(mn);
		UiObject.waitFor(By.name("下一个")).click();
	}

	// 输入帐号密码
	private void inputPassword(String pd) {
		UiObject.waitFor(PASSWORD).click();
		UiObject.waitFor(PASSWORD).sendKeys(pd);
		UiObject.waitFor(By.name("完成")).click();
	}

	// 点击登录按钮
	private void clickLoginButton() {
		UiObject.waitFor(LOGIN).click();
	}


}
