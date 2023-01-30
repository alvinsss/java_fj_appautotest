package com.fengjr.mobile.page.ad;

import org.openqa.selenium.By;

import com.fengjr.mobile.base.PageContext;
import com.fengjr.mobile.page.ConfirmInvestPage;
import com.fengjr.mobile.page.LoanDetailsPage;
import com.fengjr.mobile.utils.UiObject;

public class AdConfirmInvestPage implements ConfirmInvestPage{
	// 填入金额
	public By AMMOUNT_EDIT = By.id("com.fengjr.mobile:id/etAmount");
	// 增加金额
	public By MINUS = By.id("com.fengjr.mobile:id/minus");
	// 减少金额
	public By PLUS = By.id("com.fengjr.mobile:id/plus");
	// 确认投资按钮
	public By CONFIRM_INVEST = By.id("com.fengjr.mobile:id/confirmInvest");
	// 当期总收益
	public By INCOME = By.id("com.fengjr.mobile:id/income");
	// 可用余额
	public By AVALIABLE_AMOUNT = By.id("com.fengjr.mobile:id/amount");
	// 确认投资对话框 OK
	private final static By CONFIRM_OK = By.id("com.fengjr.mobile:id/ok");
	// 确认投资对话框 Cancel
	private final static By CONFIRM_CANCEL = By.id("com.fengjr.mobile:id/cancel");
	// 标题中返回按钮
	private final static By BACK = By.id("com.fengjr.mobile:id/left");
	
	@SuppressWarnings("static-access")
	private final static By[] ID = {By.id("com.fengjr.mobile:id/title").name("投资确认")};
	
	public AdConfirmInvestPage() {
		
	}

	@Override
	public boolean addMoney(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean minusMoney(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean clickConfirmInvest(PageContext context) {
		UiObject.waitFor(CONFIRM_INVEST).click();
		return true;
	}

	@Override
	public boolean clickConfirmOk(PageContext context) {
		UiObject.waitFor(CONFIRM_OK).click();
		return true;
	}

	@Override
	public boolean clickConfirmCancel(PageContext context) {
		UiObject.waitFor(CONFIRM_CANCEL).click();
		return true;
	}
	
	@Override
	public boolean inputInvestAmmout(PageContext context, String ammount) {
		UiObject.waitFor(AMMOUNT_EDIT).click();
		UiObject.waitFor(AMMOUNT_EDIT).clear();
		UiObject.waitFor(AMMOUNT_EDIT).sendKeys(ammount);
		UiObject.hideKeyborad();
		return true;
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
		context.update(LoanDetailsPage.class);
		return true;
	}

	@Override
	public boolean exitApp(PageContext context) {
		// TODO Auto-generated method stub
		return false;
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
	public By[] getIdentification() {
		return ID;
	}
	
	@Override
	public double getTotalIncomeExpiration(PageContext context) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTotalIncomeMonthly(PageContext context) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTotalPrincipalExpriation(PageContext context) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTotalInterestMonthly(PageContext context) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getAllottedTime(PageContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getTotalBalanceInvest(PageContext context) {
		// TODO Auto-generated method stub
		return 0;
	}

}
