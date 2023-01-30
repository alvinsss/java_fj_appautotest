package com.fengjr.mobile.page.ad;

import org.openqa.selenium.By;

import com.fengjr.mobile.base.PageContext;
import com.fengjr.mobile.page.AboutUsPage;
import com.fengjr.mobile.page.CrowdfundingPage;
import com.fengjr.mobile.page.FundsRecordPage;
import com.fengjr.mobile.page.HomePage;
import com.fengjr.mobile.page.LoanPage;
import com.fengjr.mobile.page.RepementQueryPage;
import com.fengjr.mobile.page.InvestRecordPage;
import com.fengjr.mobile.page.MyCrowdfundingPage;
import com.fengjr.mobile.page.PersonalCenterPage;
import com.fengjr.mobile.page.SettingPage;
import com.fengjr.mobile.page.TabPage;
import com.fengjr.mobile.setting.Settings;
import com.fengjr.mobile.utils.UiObject;

public class AdPersonalCenterPage implements PersonalCenterPage, TabPage {
	
	// 用户名
	private By NAME = By.id("com.fengjr.mobile:id/tvName");
	
	// 累计收益
	private By INCOME = By.id("com.fengjr.mobile:id/incomeToday");
	
	// 帐号总金额 com.fengjr.mobile:id/amountTotal
	private By AMOUNT_TOTAL = By.id("com.fengjr.mobile:id/amountTotal");
	
	// 可用余额 com.fengjr.mobile:id/available
	private By AVAILABLE = By.id("com.fengjr.mobile:id/available");
	
	// 待收本息 com.fengjr.mobile:id/receive
	private By RECEIVE = By.id("com.fengjr.mobile:id/receive");
	
	// 冻结金额 com.fengjr.mobile:id/frozen
	private By FROZEN = By.id("com.fengjr.mobile:id/frozen");
	
	// 投资记录 com.fengjr.mobile:id/ivInvestRecord
	private By INVEST_RECORD = By.id("com.fengjr.mobile:id/ivInvestRecord");
	
	// 我的众筹 com.fengjr.mobile:id/ivMyCrowFunding
	private By MY_CROW_FUNDING = By.id("com.fengjr.mobile:id/ivMyCrowFunding");
	
	// 资金流水 com.fengjr.mobile:id/ivCalendar
	private By CALENDAR = By.id("com.fengjr.mobile:id/ivCalendar");
	
	// 我的银行卡 com.fengjr.mobile:id/ivCard
	private By CARD = By.id("com.fengjr.mobile:id/ivCard");
	
	// 设置 com.fengjr.mobile:id/right
	private By SETTING = By.id("com.fengjr.mobile:id/right");
	
	// 回款查询
	private By REPAYMENT_QUERY = By.id("com.fengjr.mobile:id/return_money_query");
	
	@SuppressWarnings("static-access")
	private By TITLE = By.id("com.fengjr.mobile:id/title").name("我的帐号");
	
	private By HOME_PAGE = By.id("com.fengjr.mobile:id/ivIndex");
	private By MONEY_PAGE = By.id("com.fengjr.mobile:id/ivMoney");
	private By FUNDING_PAGE = By.id("com.fengjr.mobile:id/ivFunding");
	private By CENTER_PAGE = By.id("com.fengjr.mobile:id/ivCenter");
	
	private By HOME_PAGE_S = By.id("com.fengjr.mobile:id/ivIndexS");
	private By MONEY_PAGE_S = By.id("com.fengjr.mobile:id/ivMoneyS");
	private By FUNDING_PAGE_S = By.id("com.fengjr.mobile:id/ivFundingS");
	private By CENTER_PAGE_S = By.id("com.fengjr.mobile:id/ivCenterS");
	
	public AdPersonalCenterPage() {
		
	}

	@Override
	public boolean clickSettingIcon(PageContext context) {
		UiObject.waitFor(SETTING).click();
		context.update(SettingPage.class);
		return true;
	}

	@Override
	public boolean clickMyCrowdfunding(PageContext context) {
		UiObject.waitFor(MY_CROW_FUNDING).click();
		context.update(MyCrowdfundingPage.class);
		return true;
	}

	@Override
	public boolean clickInvestRecord(PageContext context) {
		UiObject.waitFor(INVEST_RECORD).click();
		context.update(InvestRecordPage.class);
		return true;
	}

	@Override
	public boolean clickFundsRecord(PageContext context) {
		if (UiObject.searchFor(CALENDAR, Settings.TIMEOUT_LONG, By.className("android.widget.ScrollView")) ) {
			UiObject.waitFor(CALENDAR).click();
			context.update(FundsRecordPage.class);
		}
		return true;
	}

	@Override
	public boolean clickRepementQuery(PageContext context) {
		if (UiObject.searchFor(REPAYMENT_QUERY, Settings.TIMEOUT_LONG, By.className("android.widget.ScrollView")) ) {
			UiObject.waitFor(REPAYMENT_QUERY).click();
			context.update(RepementQueryPage.class);
		}
		return true;
	}

	@Override
	public boolean goAboutUsPage(PageContext context) {
		UiObject.waitFor(SETTING).click();
		context.update(AboutUsPage.class);
		return false;
	}

	@Override
	public boolean goAddressInfoPage(PageContext context) {
		clickFundingTab(context);
		return false;
	}

	@Override
	public boolean goConfirmInvestPage(PageContext context) {
		clickLoanTab(context);
		return false;
	}

	@Override
	public boolean goConfirmSupportPage(PageContext context) {
		clickFundingTab(context);
		return false;
	}

	@Override
	public boolean goCrowdfundingDetailPage(PageContext context) {
		clickFundingTab(context);
		return false;
	}

	@Override
	public boolean goCrowdfundingProjectDetails(PageContext context) {
		clickFundingTab(context);
		return false;
	}

	@Override
	public boolean goFeedbackPage(PageContext context) {
		goSettingPage(context);
		return false;
	}

	@Override
	public boolean goFundsRecord(PageContext context) {
		clickFundsRecord(context);
		return false;
	}

	@Override
	public boolean goFundTrusteeshipAccountPage(PageContext context) {
		goSettingPage(context);
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
		goSettingPage(context);
		return false;
	}

	@Override
	public boolean goRepaymentPlan(PageContext context) {
		clickFundsRecord(context);
		return false;
	}

	@Override
	public boolean goWelcomePage(PageContext context) {
		goSettingPage(context);
		return false;
	}
	
	@Override
	public boolean goLoginPage(PageContext context) {
		UiObject.getAppiumDriver().resetApp();
		return false;
	}

	@Override
	public boolean goRegisterPage(PageContext context) {
		goSettingPage(context);
		return false;
	}

	@Override
	public boolean goHomPage(PageContext context) {
		clickHomeTab(context);
		return false;
	}

	@Override
	public boolean goQRCodePage(PageContext context) {
		goHomPage(context);
		return false;
	}

	@Override
	public boolean goLoanPage(PageContext context) {
		clickLoanTab(context);
		return false;
	}

	@Override
	public boolean goSearchPage(PageContext context) {
		goLoanPage(context);
		return false;
	}

	@Override
	public boolean goCrowdfundingPage(PageContext context) {
		clickFundingTab(context);
		return false;
	}

	@Override
	public boolean goPersonalCenterPage(PageContext context) {
		return true;
	}

	@Override
	public boolean goSettingPage(PageContext context) {
		clickSettingIcon(context);
		return false;
	}

	@Override
	public boolean goInvestRecordPage(PageContext context) {
		clickInvestRecord(context);
		return false;
	}

	@Override
	public boolean goMyCrowdfundingPage(PageContext context) {
		clickMyCrowdfunding(context);
		return false;
	}

	@Override
	public boolean goFundsRecordPage(PageContext context) {
		clickFundsRecord(context);
		return false;
	}

	@Override
	public boolean goIncomeQueryPage(PageContext context) {
		clickRepementQuery(context);
		return false;
	}

	@Override
	public boolean goLatestAnnouncementPage(PageContext context) {
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
	public By[] getIdentification() {
		return new By[]{MY_CROW_FUNDING, INVEST_RECORD};
	}

	@Override
	public String getMoneyTotal(PageContext context) {
		String moneyTotal = UiObject.waitFor(AMOUNT_TOTAL).getText();
		return moneyTotal;
	}

	@Override
	public String getMoneyFrozen(PageContext context) {
		String frozen = UiObject.waitFor(FROZEN).getText();
		return frozen;
	}

	@Override
	public String getPrincipalAndIntrestDuein(PageContext context) {
		String received = UiObject.waitFor(RECEIVE).getText();
		return received;
	}

	@Override
	public String getIncomeTotal(PageContext context) {
		String incomeTotal = UiObject.waitFor(INCOME).getText();
		return incomeTotal;
	}

	@Override
	public String getBlanceAvaliable(PageContext context) {
		String availiableAmmount = UiObject.waitFor(AVAILABLE).getText();
		return availiableAmmount;
	}


	@Override
	public boolean clickHomeTab(PageContext context) {
		if (!UiObject.searchFor(HOME_PAGE_S)) {
			UiObject.waitFor(HOME_PAGE).click();
		}
		context.update(HomePage.class);
		return true;
	}

	@Override
	public boolean clickLoanTab(PageContext context) {
		if (!UiObject.searchFor(MONEY_PAGE_S)) {
			UiObject.waitFor(MONEY_PAGE).click();
		}
		context.update(LoanPage.class);
		return true;
	}

	@Override
	public boolean clickFundingTab(PageContext context) {
		if (!UiObject.searchFor(FUNDING_PAGE_S)) {
			UiObject.waitFor(FUNDING_PAGE).click();
		}
		context.update(CrowdfundingPage.class);
		return true;
	}

	@Override
	public boolean clickPersonalCenterTab(PageContext context) {
		if (!UiObject.searchFor(CENTER_PAGE_S)) {
			UiObject.waitFor(CENTER_PAGE).click();
		}
		context.update(PersonalCenterPage.class);
		return true;
	}

}
