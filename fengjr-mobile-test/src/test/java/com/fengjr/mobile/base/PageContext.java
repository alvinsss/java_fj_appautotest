package com.fengjr.mobile.base;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.fengjr.mobile.bean.FundsRecordItem;
import com.fengjr.mobile.bean.InvestRecordItem;
import com.fengjr.mobile.bean.LoanItem;
import com.fengjr.mobile.bean.RepaymentPlanItem;
import com.fengjr.mobile.bean.RepaymentQueryItem;
import com.fengjr.mobile.factory.PageFactory;
import com.fengjr.mobile.page.AboutUsPage;
import com.fengjr.mobile.page.AddressInfoPage;
import com.fengjr.mobile.page.ConfirmInvestPage;
import com.fengjr.mobile.page.ConfirmSupportPage;
import com.fengjr.mobile.page.CrowdfundingDetailPage;
import com.fengjr.mobile.page.CrowdfundingPage;
import com.fengjr.mobile.page.CrowdfundingProjectDetails;
import com.fengjr.mobile.page.FeedbackPage;
import com.fengjr.mobile.page.FundTrusteeshipAccountPage;
import com.fengjr.mobile.page.FundsRecordPage;
import com.fengjr.mobile.page.HomePage;
import com.fengjr.mobile.page.InvestRecordPage;
import com.fengjr.mobile.page.LatestAnnouncementPage;
import com.fengjr.mobile.page.LatestMediaReportPage;
import com.fengjr.mobile.page.LatestNewsPage;
import com.fengjr.mobile.page.LoanDetailsPage;
import com.fengjr.mobile.page.LoanPage;
import com.fengjr.mobile.page.LoanPartakeDetails;
import com.fengjr.mobile.page.LoginPage;
import com.fengjr.mobile.page.MyCrowdfundingPage;
import com.fengjr.mobile.page.PatternLockPage;
import com.fengjr.mobile.page.PersonalCenterPage;
import com.fengjr.mobile.page.RegisterPage;
import com.fengjr.mobile.page.RepaymentPlan;
import com.fengjr.mobile.page.RepementQueryPage;
import com.fengjr.mobile.page.SearchPage;
import com.fengjr.mobile.page.SettingPage;
import com.fengjr.mobile.page.TabPage;
import com.fengjr.mobile.page.UnknowPage;
import com.fengjr.mobile.page.WelcomePage;

public class PageContext implements Navigator, AboutUsPage, AddressInfoPage, ConfirmInvestPage, ConfirmSupportPage,
CrowdfundingDetailPage, CrowdfundingPage, CrowdfundingProjectDetails, FeedbackPage, FundTrusteeshipAccountPage, FundsRecordPage,
HomePage, RepementQueryPage, InvestRecordPage, LatestAnnouncementPage, LatestNewsPage, LoanDetailsPage, 
LoanPage, LoanPartakeDetails, LoginPage, LatestMediaReportPage, MyCrowdfundingPage, PatternLockPage, PersonalCenterPage, RegisterPage, 
RepaymentPlan, SearchPage, SettingPage, TabPage, WelcomePage, UnknowPage {
	
	public static Page currentPage = PageFactory.getCurrentPage(WelcomePage.class);
	
	public PageContext() {
		try {
			Thread.sleep(2 * 1000);
//			PageFactory.updateContext(this, WelcomePage.class);
			Logger.getLogger(getClass()).info("Update current page :" + currentPage.getClass());
		} catch (InterruptedException e) {
			// ignore
		}
	}
	
	public PageContext(Class<?> intent) {
		try {
			Thread.sleep(2 * 1000);
			PageFactory.updateContext(this, intent);
			Logger.getLogger(getClass()).info("Update current page :" + currentPage.getClass());
		} catch (InterruptedException e) {
			// ignore
		}
	}

	@Override
	public boolean goLoginPage(PageContext context) {
		Logger.getLogger(getClass()).info("go login page...");
		while (!((Navigator)currentPage).goLoginPage(context));
		return true;
	}


	@Override
	public boolean goRegisterPage(PageContext context) {
		Logger.getLogger(getClass()).info("go register page...");
		while (!((Navigator)currentPage).goRegisterPage(context));
		return true;
	}


	@Override
	public boolean goHomPage(PageContext context) {
		Logger.getLogger(getClass()).info("go home page...");
		while (!((Navigator)currentPage).goHomPage(context));
		return true;
	}


	@Override
	public boolean goQRCodePage(PageContext context) {
		Logger.getLogger(getClass()).info("go qrcode page...");
		while(! ((Navigator)currentPage).goQRCodePage(context));
		return true;
	}


	@Override
	public boolean goLoanPage(PageContext context) {
		Logger.getLogger(getClass()).info("go loan page...");
		while (!((Navigator)currentPage).goLoanPage(context));
		return true;
	}


	@Override
	public boolean goSearchPage(PageContext context) {
		Logger.getLogger(getClass()).info("go search page...");
		while(! ((Navigator)currentPage).goSearchPage(context));
		return true;
	}


	@Override
	public boolean goCrowdfundingPage(PageContext context) {
		Logger.getLogger(getClass()).info("go crowdfunding page...");
		while(! ((Navigator)currentPage).goCrowdfundingPage(context));
		return true;
	}


	@Override
	public boolean goPersonalCenterPage(PageContext context) {
		Logger.getLogger(getClass()).info("go personal center page...");
		while(!((Navigator)currentPage).goPersonalCenterPage(context));
		return true;
	}


	@Override
	public boolean goSettingPage(PageContext context) {
		Logger.getLogger(getClass()).info("go setting page...");
		while(! ((Navigator)currentPage).goSettingPage(context));
		return true;
	}


	@Override
	public boolean goInvestRecordPage(PageContext context) {
		Logger.getLogger(getClass()).info("go invest record page...");
		while(! ((Navigator)currentPage).goInvestRecordPage(context));
		return true;
	}


	@Override
	public boolean goMyCrowdfundingPage(PageContext context) {
		Logger.getLogger(getClass()).info("go my crowdfunding page...");
		while(! ((Navigator)currentPage).goMyCrowdfundingPage(context));
		return true;
	}


	@Override
	public boolean goFundsRecordPage(PageContext context) {
		Logger.getLogger(getClass()).info("go funds record page...");
		while(! ((Navigator)currentPage).goFundsRecordPage(context));
		return true;
	}


	@Override
	public boolean goIncomeQueryPage(PageContext context) {
		Logger.getLogger(getClass()).info("go income query page...");
		while(! ((Navigator)currentPage).goIncomeQueryPage(context));
		return true;
	}


	@Override
	public boolean goBack(PageContext context) {
		return ((Navigator)currentPage).goBack(context);
	}


	@Override
	public boolean exitApp(PageContext context) {
		return ((Navigator)currentPage).exitApp(context);
	}


	@Override
	public boolean clickGuide(PageContext context) {
		goAboutUsPage(context);
		return ((AboutUsPage)currentPage).clickGuide(context);
	}


	@Override
	public boolean clickSecurity(PageContext context) {
		goAboutUsPage(context);
		return ((AboutUsPage)currentPage).clickSecurity(context);
	}


	@Override
	public boolean inputName(PageContext context) {
		goAddressInfoPage(context);
		return ((AddressInfoPage)currentPage).inputName(context);
	}


	@Override
	public boolean inputMobile(PageContext context) {
		goAddressInfoPage(context);
		return ((AddressInfoPage)currentPage).inputMobile(context);
	}


	@Override
	public boolean inputEmail(PageContext context) {
		goAddressInfoPage(context);
		return ((AddressInfoPage)currentPage).inputEmail(context);
	}


	@Override
	public boolean inputAddress(PageContext context) {
		goAddressInfoPage(context);
		return ((AddressInfoPage)currentPage).inputAddress(context);
	}


	@Override
	public boolean inputInvoiceTitle(PageContext context) {
		goAddressInfoPage(context);
		return ((AddressInfoPage)currentPage).inputInvoiceTitle(context);
	}


	@Override
	public boolean enableInvoice(PageContext context) {
		goAddressInfoPage(context);
		return ((AddressInfoPage)currentPage).enableInvoice(context);
	}


	@Override
	public boolean disableInvoice(PageContext context) {
		goAddressInfoPage(context);
		return ((AddressInfoPage)currentPage).disableInvoice(context);
	}


	@Override
	public boolean clickSubmit(PageContext context) {
		goAddressInfoPage(context);
		return ((AddressInfoPage)currentPage).clickSubmit(context);
	}


	@Override
	public boolean addMoney(PageContext context) {
		goConfirmInvestPage(context);
		return ((ConfirmInvestPage)currentPage).addMoney(context);
	}


	@Override
	public boolean minusMoney(PageContext context) {
		goConfirmInvestPage(context);
		return ((ConfirmInvestPage)currentPage).minusMoney(context);
	}


	@Override
	public boolean clickConfirmInvest(PageContext context) {
		goConfirmInvestPage(context);
		return ((ConfirmInvestPage)currentPage).clickConfirmInvest(context);
	}


	@Override
	public boolean clickConfirmOk(PageContext context) {
		goConfirmInvestPage(context);
		return ((ConfirmInvestPage)currentPage).clickConfirmOk(context);
	}


	@Override
	public boolean clickConfirmCancel(PageContext context) {
		goConfirmInvestPage(context);
		return ((ConfirmInvestPage)currentPage).clickConfirmCancel(context);
	}


	@Override
	public boolean inputInvestAmmout(PageContext context, String ammount) {
		goConfirmInvestPage(context);
		return ((ConfirmInvestPage)currentPage).inputInvestAmmout(context, ammount);
	}

	@Override
	public boolean clickAddressInfo(PageContext context) {
		goConfirmSupportPage(context);
		return ((ConfirmSupportPage)currentPage).clickAddressInfo(context);
	}


	@Override
	public boolean inputRemarks(PageContext context, String remarks) {
		goConfirmSupportPage(context);
		return ((ConfirmSupportPage)currentPage).inputRemarks(context, remarks);
	}


	@Override
	public double clickSupport(PageContext context) {
		goConfirmSupportPage(context);
		return ((ConfirmSupportPage)currentPage).clickSupport(context);
	}


	@Override
	public boolean clickLike(PageContext context) {
		goCrowdfundingDetailPage(context);
		return ((CrowdfundingDetailPage)currentPage).clickLike(context);
	}


	@Override
	public boolean clickZan(PageContext context) {
		goCrowdfundingDetailPage(context);
		return ((CrowdfundingDetailPage)currentPage).clickZan(context);
	}


	@Override
	public boolean clickProjectDetail(PageContext context) {
		goCrowdfundingDetailPage(context);
		return ((CrowdfundingDetailPage)currentPage).clickProjectDetail(context);
	}


	@Override
	public boolean clickIwannaSupport(PageContext context, int index) {
		goCrowdfundingDetailPage(context);
		return ((CrowdfundingDetailPage)currentPage).clickIwannaSupport(context, index);
	}

	@Override
	public boolean clickCrowdfundingItem(PageContext context, String title) {
		goCrowdfundingPage(context);
		return ((CrowdfundingPage)currentPage).clickCrowdfundingItem(context, title);
	}


	@Override
	public boolean inputSuggestion(PageContext context, String suggestion) {
		goFeedbackPage(context);
		return ((FeedbackPage)currentPage).inputSuggestion(context, suggestion);
	}


	@Override
	public boolean inputFeedbackName(PageContext context, String name) {
		goFeedbackPage(context);
		return ((FeedbackPage)currentPage).inputFeedbackName(context, name);

	}


	@Override
	public boolean inputContactInfo(PageContext context, String contractInfo) {
		goFeedbackPage(context);
		return ((FeedbackPage)currentPage).inputContactInfo(context, contractInfo);

	}


	@Override
	public boolean clickSumitFeedback(PageContext context) {
		goFeedbackPage(context);
		return ((FeedbackPage)currentPage).clickSumitFeedback(context);

	}


	@Override
	public boolean clickOpenTrusteeshipAccount(PageContext context) {
		goFundTrusteeshipAccountPage(context);
		return ((FundTrusteeshipAccountPage)currentPage).clickOpenTrusteeshipAccount(context);
	}


	@Override
	public boolean clickAnnouncementTitle(PageContext context) {
		goHomPage(context);
		return ((HomePage)currentPage).clickAnnouncementTitle(context);
	}


	@Override
	public boolean clickAnnouncementMore(PageContext context) {
		goHomPage(context);
		return ((HomePage)currentPage).clickAnnouncementMore(context);
	}


	@Override
	public boolean clickQrcodeIcon(PageContext context) {
		goHomPage(context);
		return ((HomePage)currentPage).clickQrcodeIcon(context);
	}

	@Override
	public boolean clickLatestAnnouncementTab(PageContext context) {
		goLatestNewsPage(context);
		return ((LatestNewsPage)currentPage).clickLatestAnnouncementTab(context);
	}


	@Override
	public boolean clickLatestMediaReportTab(PageContext context) {
		goLatestNewsPage(context);
		return ((LatestNewsPage)currentPage).clickLatestMediaReportTab(context);

	}


	@Override
	public boolean clickRegisterButton(PageContext context) {
		goLoginPage(context);
		return ((LoginPage)currentPage).clickRegisterButton(context);
	}


	@Override
	public boolean login(PageContext context, String mobile, String password, int loginEnv) {
		goLoginPage(context);
		Logger.getLogger(getClass()).info(currentPage.getClass());
		return ((LoginPage)currentPage).login(context, mobile, password, loginEnv);
	}


	@Override
	public boolean changePlatform(PageContext context, int type) {
		goLoginPage(context);
		return ((LoginPage)currentPage).changePlatform(context, type);
	}


	@Override
	public boolean drawPatternLock(PageContext context, int[] pattern) {
		goPatternLockPage(context);
		return ((PatternLockPage)currentPage).drawPatternLock(context, pattern);
	}


	@Override
	public boolean clickSettingIcon(PageContext context) {
		goPersonalCenterPage(context);
		return ((PersonalCenterPage)currentPage).clickSettingIcon(context);
	}


	@Override
	public boolean clickInvestRecord(PageContext context) {
		goPersonalCenterPage(context);
		return ((PersonalCenterPage)currentPage).clickInvestRecord(context);

	}


	@Override
	public boolean clickMyCrowdfunding(PageContext context) {
		goPersonalCenterPage(context);
		return ((PersonalCenterPage)currentPage).clickMyCrowdfunding(context);

	}


	@Override
	public boolean clickFundsRecord(PageContext context) {
		goPersonalCenterPage(context);
		return ((PersonalCenterPage)currentPage).clickFundsRecord(context);

	}


	@Override
	public boolean clickRepementQuery(PageContext context) {
		goPersonalCenterPage(context);
		return ((PersonalCenterPage)currentPage).clickRepementQuery(context);

	}


	@Override
	public boolean inputRegisterUsername(PageContext context, String username) {
		goRegisterPage(context);
		return ((RegisterPage)currentPage).inputRegisterUsername(context, username);
	}


	@Override
	public boolean inputRegisterMobilenumber(PageContext context,
			String mobilenumber) {
		goRegisterPage(context);
		return ((RegisterPage)currentPage).inputRegisterMobilenumber(context, mobilenumber);
	}


	@Override
	public boolean inputRegisterPassword(PageContext context, String password) {
		goRegisterPage(context);
		return ((RegisterPage)currentPage).inputRegisterPassword(context, password);
	}


	@Override
	public boolean inputRegisterPasswordAgain(PageContext context,
			String password) {
		goRegisterPage(context);
		return ((RegisterPage)currentPage).inputRegisterPasswordAgain(context, password);
	}


	@Override
	public boolean inputRegisterVercode(PageContext context) {
		goRegisterPage(context);
		return ((RegisterPage)currentPage).inputRegisterVercode(context);
	}


	@Override
	public boolean clickRegisterNextStep(PageContext context) {
		goRegisterPage(context);
		return ((RegisterPage)currentPage).clickRegisterNextStep(context);
	}


	@Override
	public boolean clickUserRegisterAggrement(PageContext context) {
		goRegisterPage(context);
		return ((RegisterPage)currentPage).clickUserRegisterAggrement(context);
	}


	@Override
	public boolean selectTypeFengbb(PageContext context) {
		goSearchPage(context);
		return ((SearchPage)currentPage).selectTypeFengbb(context);
	}


	@Override
	public boolean selectTypeFengrt(PageContext context) {
		goSearchPage(context);
		return ((SearchPage)currentPage).selectTypeFengrt(context);
	}


	@Override
	public boolean selectDurationAllMonth(PageContext context) {
		goSearchPage(context);
		return ((SearchPage)currentPage).selectDurationAllMonth(context);
	}


	@Override
	public boolean selectDuration_1_3Month(PageContext context) {
		goSearchPage(context);
		return ((SearchPage)currentPage).selectDuration_1_3Month(context);
	}


	@Override
	public boolean selectDuration_4_6Month(PageContext context) {
		goSearchPage(context);
		return ((SearchPage)currentPage).selectDuration_4_6Month(context);
	}


	@Override
	public boolean selectDuration_7_12Month(PageContext context) {
		goSearchPage(context);
		return ((SearchPage)currentPage).selectDuration_7_12Month(context);
	}


	@Override
	public boolean selectDuration_13_24Month(PageContext context) {
		goSearchPage(context);
		return ((SearchPage)currentPage).selectDuration_13_24Month(context);
	}


	@Override
	public boolean selectDurationBigger25Month(PageContext context) {
		goSearchPage(context);
		return ((SearchPage)currentPage).selectDurationBigger25Month(context);
	}


	@Override
	public boolean selectRateAll(PageContext context) {
		goSearchPage(context);
		return ((SearchPage)currentPage).selectRateAll(context);
	}


	@Override
	public boolean selectRateBlow8(PageContext context) {
		goSearchPage(context);
		return ((SearchPage)currentPage).selectRateBlow8(context);
	}


	@Override
	public boolean selectRate_8_10(PageContext context) {
		goSearchPage(context);
		return ((SearchPage)currentPage).selectRate_8_10(context);
	}


	@Override
	public boolean selectRate_10_11(PageContext context) {
		goSearchPage(context);
		return ((SearchPage)currentPage).selectRate_10_11(context);
	}


	@Override
	public boolean selectRateBigger11(PageContext context) {
		goSearchPage(context);
		return ((SearchPage)currentPage).selectRateBigger11(context);
	}


	@Override
	public boolean selcetRateBlow9(PageContext context) {
		goSearchPage(context);
		return ((SearchPage)currentPage).selcetRateBlow9(context);
	}


	@Override
	public boolean selectRate_9_11(PageContext context) {
		goSearchPage(context);
		return ((SearchPage)currentPage).selectRate_9_11(context);
	}


	@Override
	public boolean selectRate_11_13(PageContext context) {
		goSearchPage(context);
		return ((SearchPage)currentPage).selectRate_11_13(context);
	}


	@Override
	public boolean selectRateBigger13(PageContext context) {
		goSearchPage(context);
		return ((SearchPage)currentPage).selectRateBigger13(context);
	}


	@Override
	public boolean clickSearch(PageContext context) {
		goSearchPage(context);
		return ((SearchPage)currentPage).clickSearch(context);
	}

	@Override
	public boolean clickModifyPatternPasswordItem(PageContext context) {
		goSettingPage(context);
		return ((SettingPage)currentPage).clickModifyPatternPasswordItem(context);
	}


	@Override
	public boolean clickFundTrusteeshipAccountItem(PageContext context) {
		goSettingPage(context);
		return ((SettingPage)currentPage).clickFundTrusteeshipAccountItem(context);
	}


	@Override
	public boolean clickAboutUsItem(PageContext context) {
		goSettingPage(context);
		return ((SettingPage)currentPage).clickAboutUsItem(context);
	}


	@Override
	public boolean clickCheckUpdateItem(PageContext context) {
		goSettingPage(context);
		return ((SettingPage)currentPage).clickCheckUpdateItem(context);
	}


	@Override
	public boolean clickFeedbackItem(PageContext context) {
		goSettingPage(context);
		return ((SettingPage)currentPage).clickFeedbackItem(context);
	}


	@Override
	public boolean clickServiceHotlineItem(PageContext context) {
		goSettingPage(context);
		return ((SettingPage)currentPage).clickServiceHotlineItem(context);
	}


	@Override
	public boolean exitCurrentAccount(PageContext context) {
		goSettingPage(context);
		return ((SettingPage)currentPage).exitCurrentAccount(context);
	}


	@Override
	public boolean inputPasswordBeforeModified(PageContext context) {
		goSettingPage(context);
		return ((SettingPage)currentPage).inputPasswordBeforeModified(context);
	}

	@Override
	public boolean skipWelcomePage(PageContext context) {
		return ((WelcomePage)currentPage).skipWelcomePage(context);
	}


	public void setCurrentPage(Page page) {
		currentPage = page;
	}


	@Override
	public boolean goLatestAnnouncementPage(PageContext context) {
		Logger.getLogger(getClass()).info("go goLatestAnnouncementPage query page...");
		while (!((Navigator)currentPage).goLatestAnnouncementPage(context));
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
	public By[] getIdentification() {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Class<?> clazz) {
		try {
			Thread.sleep(1000);
			PageFactory.updateContext(this, clazz);
		} catch (InterruptedException e) {
			// ignore
		}
	}

	@Override
	public boolean clickInvest(PageContext context) {
		return ((LoanDetailsPage)currentPage).clickInvest(context);
	}

	@Override
	public boolean clickInvestDetail(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean clickCollateralAgreement(PageContext context) {
		// TODO Auto-generated method stub
		return false;
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

	@Override
	public String getMoneyTotal(PageContext context) {
		goPersonalCenterPage(context);
		return ((PersonalCenterPage)currentPage).getMoneyTotal(context);
	}

	@Override
	public String getMoneyFrozen(PageContext context) {
		goPersonalCenterPage(context);
		return ((PersonalCenterPage)currentPage).getMoneyFrozen(context);
	}

	@Override
	public String getPrincipalAndIntrestDuein(PageContext context) {
		goPersonalCenterPage(context);
		return ((PersonalCenterPage)currentPage).getPrincipalAndIntrestDuein(context);
	}

	@Override
	public String getIncomeTotal(PageContext context) {
		goPersonalCenterPage(context);
		return ((PersonalCenterPage)currentPage).getIncomeTotal(context);
	}

	@Override
	public String getBlanceAvaliable(PageContext context) {
		goPersonalCenterPage(context);
		return ((PersonalCenterPage)currentPage).getBlanceAvaliable(context);
	}

	@Override
	public boolean clickLoanItem(PageContext context, String title) {
		goLoanPage(context);
		return ((LoanPage)currentPage).clickLoanItem(context, title);
	}

	@Override
	public List<? extends LoanItem> getLoanItemTop10(PageContext context) {
		goLoanPage(context);
		return ((LoanPage)currentPage).getLoanItemTop10(context);
	}

	@Override
	public List<? extends LoanItem> getLoanItemInvestable(PageContext context) {
		goLoanPage(context);
		return ((LoanPage)currentPage).getLoanItemInvestable(context);
	}

	@Override
	public String getRepementMonth() {
		return ((RepementQueryPage)currentPage).getRepementMonth();
	}

	@Override
	public List<? extends RepaymentQueryItem> getRepementList() {
		return ((RepementQueryPage)currentPage).getRepementList();
	}

	@Override
	public List<? extends FundsRecordItem> getFundRecordList() {
		return ((FundsRecordPage)currentPage).getFundRecordList();
	}

	@Override
	public List<? extends RepaymentPlanItem> getRepaymentPlanList() {
		return ((RepaymentPlan)currentPage).getRepaymentPlanList();
	}

	@Override
	public List<? extends InvestRecordItem> getInvestRecordList(int num) {
		return ((InvestRecordPage)currentPage).getInvestRecordList(num);
	}

	@Override
	public boolean clickHomeTab(PageContext context) {
		return ((TabPage)currentPage).clickHomeTab(context);
	}

	@Override
	public boolean clickLoanTab(PageContext context) {
		return ((TabPage)currentPage).clickLoanTab(context);
	}

	@Override
	public boolean clickFundingTab(PageContext context) {
		return ((TabPage)currentPage).clickFundingTab(context);
	}

	@Override
	public boolean clickPersonalCenterTab(PageContext context) {
		return ((TabPage)currentPage).clickPersonalCenterTab(context);
	}

	@Override
	public boolean clickFengbbTab(PageContext context) {
		return ((LoanPage)currentPage).clickFengbbTab(context);
	}

	@Override
	public boolean clickFengrtTab(PageContext context) {
		return ((LoanPage)currentPage).clickFengrtTab(context);
	}

	@Override
	public boolean clickHold(PageContext context) {
		return ((InvestRecordPage)currentPage).clickHold(context);
	}

	@Override
	public boolean clickTransferred(PageContext context) {
		return ((InvestRecordPage)currentPage).clickTransferred(context);
	}

}