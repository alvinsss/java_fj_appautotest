package com.fengjr.mobile.page.os;

import org.openqa.selenium.By;

import com.fengjr.mobile.base.PageContext;
import com.fengjr.mobile.page.PatternLockPage;
import com.fengjr.mobile.page.PersonalCenterPage;
import com.fengjr.mobile.page.SettingPage;
import com.fengjr.mobile.setting.Configurator;
import com.fengjr.mobile.utils.UiObject;

public class OsSettingPage implements SettingPage{
	
	//页面顶部标题
	private static By TITLE = By.id("SettingView");
	
	//修改手势密码
	private static By REVISE_GESTURE = By.name("修改手势");
	//资金托管账户
	private static By UPAYMENT_ACCOUNT = By.name("资金托管账户");
	//关于我们
	private static By ABOUT = By.name("关于我们");
	//版本号
	private static By VERSION = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIAStaticText[2]");
	//意见反馈
	private static By FEEDBACK = By.name("意见反馈");
	//客服热线
	private static By HOTLINE = By.name("客服热线");
	//退出登录
	private static By QUIT = By.name("退出登录");
	
	//登录密码输入框
	private static By PASWORD_EDITOR = By.className("UIASecureTextField");
	//确定
	private static By PASWORD_OK = By.name("确定");
	//取消
	private static By PASWORD_CANCEL = By.name("取消");
	//返回
	private static By BACK = By.name("Fengjr return");
	
	public OsSettingPage() {
		
	}

	@Override
	public boolean clickModifyPatternPasswordItem(PageContext context) {
		UiObject.waitFor(REVISE_GESTURE).click();
		return true;
	}

	@Override
	public boolean clickFundTrusteeshipAccountItem(PageContext context) {
		UiObject.waitFor(UPAYMENT_ACCOUNT).click();
		return true;
	}

	@Override
	public boolean clickAboutUsItem(PageContext context) {
		UiObject.waitFor(ABOUT).click();
		return true;
	}

	@Override
	public boolean clickCheckUpdateItem(PageContext context) {
		UiObject.waitFor(VERSION).click();
		return true;
	}

	@Override
	public boolean clickFeedbackItem(PageContext context) {
		UiObject.waitFor(FEEDBACK).click();
		return true;
	}

	@Override
	public boolean clickServiceHotlineItem(PageContext context) {
		UiObject.waitFor(HOTLINE).click();
		return true;
	}

	@Override
	public boolean exitCurrentAccount(PageContext context) {
		UiObject.waitFor(QUIT).click();
		return true;
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
		clickAboutUsItem(context);
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
		clickFeedbackItem(context);
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
		clickModifyPatternPasswordItem(context);
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
		return true;
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
		UiObject.waitFor(QUIT).click();
		return true;
	}

	@Override
	public By[] getIdentification() {
		return new By[]{TITLE};
	}
}
