package com.fengjr.mobile.page.os;

import org.openqa.selenium.By;

import com.fengjr.mobile.base.PageContext;
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
import com.fengjr.mobile.setting.Configurator;
import com.fengjr.mobile.utils.UiObject;

public class OsPersonalCenterPage implements PersonalCenterPage, TabPage {
	
	// 用户名
	private By NAME = By.name("tvName");
	
	// 累计收益
	private By INCOME = By.name("incomeToday");
	
	// 帐号总金额 com.fengjr.mobile:id/amountTotal
	private By AMOUNT_TOTAL = By.name("amountTotal");
	
	// 可用余额 com.fengjr.mobile:id/available
	private By AVAILABLE = By.name("available");
	
	// 待收本息 com.fengjr.mobile:id/receive
	private By RECEIVE = By.name("receive");
	
	// 冻结金额 com.fengjr.mobile:id/frozen
	private By FROZEN = By.name("frozen");
	
	// 投资记录 com.fengjr.mobile:id/ivInvestRecord
	private By INVEST_RECORD = By.name("ivInvestRecord");
	
	// 我的众筹 com.fengjr.mobile:id/ivMyCrowFunding
	private By MY_CROW_FUNDING = By.name("ivMyCrowFunding");
	
	// 资金流水 com.fengjr.mobile:id/ivCalendar
	private By CALENDAR = By.name("ivCalendar");
	
	// 我的银行卡 com.fengjr.mobile:id/ivCard
	private By CARD = By.name("ivCard");
	
	// 设置 com.fengjr.mobile:id/right
	private By SETTING = By.name("setting");
	
	// 回款查询
	private By REPAYMENT_QUERY = By.name("ivReceivableQueries");

	private By TITLE = By.name("Fengjr_GRZX_title");
	
	public static By HOME_PAGE = By.name("ivIndex");
	public static By MONEY_PAGE = By.name("ivMoney");
	public static By FUNDING_PAGE = By.name("ivFunding");
	public static By CENTER_PAGE = By.name("ivCenter");
	
	public static By HOME_PAGE_S = By.name("ivIndexS");
	public static By MONEY_PAGE_S = By.name("ivMoneyS");
	public static By FUNDING_PAGE_S = By.name("ivFundingS");
	public static By CENTER_PAGE_S = By.name("ivCenterS");
	
	public OsPersonalCenterPage() {
		
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
		if (UiObject.searchFor(CALENDAR, Configurator.TIMEOUT_LONG, By.className("UIATableView"))) { 
			UiObject.waitFor(CALENDAR).click();
		}
		context.update(FundsRecordPage.class);
		return true;
	}

	@Override
	public boolean clickRepementQuery(PageContext context) {
		
		if (UiObject.searchFor(REPAYMENT_QUERY, Configurator.TIMEOUT_LONG, By.className("UIATableView"))) {
			UiObject.waitFor(REPAYMENT_QUERY).click();
		}
		context.update(RepementQueryPage.class);
		return true;
	}

	@Override
	public boolean goAboutUsPage(PageContext context) {
		clickSettingIcon(context);
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
		clickSettingIcon(context);
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
		UiObject.getAppiumDriver().resetApp();
		return false;
	}

	@Override
	public boolean goRepaymentPlan(PageContext context) {
		clickFundsRecord(context);
		return false;
	}

	@Override
	public boolean goWelcomePage(PageContext context) {
		UiObject.getAppiumDriver().resetApp();
		return false;
	}
	
	@Override
	public boolean goLoginPage(PageContext context) {
		UiObject.getAppiumDriver().resetApp();
		return false;
	}

	@Override
	public boolean goRegisterPage(PageContext context) {
		UiObject.getAppiumDriver().resetApp();
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
		return new By[]{TITLE};
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
