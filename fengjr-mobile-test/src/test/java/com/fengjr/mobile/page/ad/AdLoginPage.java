package com.fengjr.mobile.page.ad;

import org.openqa.selenium.By;
import org.testng.log4testng.Logger;

import com.fengjr.mobile.base.PageContext;
import com.fengjr.mobile.page.LoginPage;
import com.fengjr.mobile.page.PatternLockPage;
import com.fengjr.mobile.page.RegisterPage;
import com.fengjr.mobile.setting.Configurator;
import com.fengjr.mobile.utils.UiObject;

public class AdLoginPage implements LoginPage {

	public static By MOBILE = By.id("com.fengjr.mobile:id/mobile");
	public static By PASSWORD = By.id("com.fengjr.mobile:id/password");
	public static By LOGIN = By.id("com.fengjr.mobile:id/login");
	public static By REGISTER = By.id("com.fengjr.mobile:id/register");
	public static By TIP = By.id("com.fengjr.mobile:id/tip");
	
	private final static By SWITCHER = By.id("com.fengjr.mobile:id/switchserver");
	
	// 登录界面ID
	public static final By[] ID_LOGIN_PAGE = {AdLoginPage.LOGIN, AdLoginPage.REGISTER};

	// 登录手机号码
	private static String mobileNum;
	// 登录密码
	private static String password;

	public AdLoginPage() {
		Logger.getLogger(getClass()).info(
				"Android Login Page object init...");
	}

	@Override
	public boolean login(PageContext context, String mobile, String password, int loginEnv) {
		
		if (UiObject.searchFor(SWITCHER)) {
			UiObject.waitFor(SWITCHER).click();
			if (loginEnv == LoginPage.BETA_PLATFORM) {
				UiObject.waitFor(By.name("beta平台")).click();
			} else if (loginEnv == LoginPage.TEST_PLATFORM) {
				UiObject.waitFor(By.name("测试平台")).click();
			} else if (loginEnv == LoginPage.CRED_PLATFORM) {
				UiObject.waitFor(By.name("云信平台")).click();
			} else {
				UiObject.waitFor(By.name("生产平台")).click();
			}
		}
		
		inputMobileNumber(mobile);
		inputPassword(password);
		clickLoginButton();
		UiObject.waitGone(TIP);
		context.update(PatternLockPage.class);

		return true;
	}

	@Override
	public boolean clickRegisterButton(PageContext context) {
		UiObject.waitFor(REGISTER).click();
		context.update(RegisterPage.class);
		return true;
	}

	// 输入手机号码
	private void inputMobileNumber(String mn) {
		mobileNum = mn;
		UiObject.waitFor(MOBILE).click();
		UiObject.waitFor(MOBILE).sendKeys(mobileNum);
		Configurator.instance().getAppiumDriver().hideKeyboard();
	}

	// 输入帐号密码
	private void inputPassword(String pd) {
		password = pd;
		UiObject.waitFor(PASSWORD).click();
		UiObject.waitFor(PASSWORD).sendKeys(password);
		Configurator.instance().getAppiumDriver().hideKeyboard();
	}

	// 点击登录按钮
	private void clickLoginButton() {
		UiObject.waitFor(LOGIN).click();
	}

	@Override
	public boolean changePlatform(PageContext context, int loginEnv) {
		if (UiObject.searchFor(SWITCHER)) {
			UiObject.waitFor(SWITCHER).click();
			if (loginEnv == LoginPage.BETA_PLATFORM) {
				UiObject.waitFor(By.name("beta平台")).click();
			} else if (loginEnv == LoginPage.TEST_PLATFORM) {
				UiObject.waitFor(By.name("测试平台")).click();
			} else if (loginEnv == LoginPage.CRED_PLATFORM) {
				UiObject.waitFor(By.name("云信平台")).click();
			} else {
				UiObject.waitFor(By.name("生产平台")).click();
			}
		}
		return true;
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
		login(context, mobile, password, LoginPage.PRODUCT_PLATFORM);
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
		return ID_LOGIN_PAGE;
	}
}
