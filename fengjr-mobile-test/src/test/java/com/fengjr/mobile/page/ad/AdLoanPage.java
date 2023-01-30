package com.fengjr.mobile.page.ad;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import com.fengjr.mobile.base.PageContext;
import com.fengjr.mobile.bean.LoanItem;
import com.fengjr.mobile.bean.ad.AdLoanItem;
import com.fengjr.mobile.page.CrowdfundingPage;
import com.fengjr.mobile.page.HomePage;
import com.fengjr.mobile.page.LoanDetailsPage;
import com.fengjr.mobile.page.LoanPage;
import com.fengjr.mobile.page.PersonalCenterPage;
import com.fengjr.mobile.page.TabPage;
import com.fengjr.mobile.utils.UiObject;
import com.fengjr.mobile.utils.UiScroller;
import com.fengjr.mobile.utils.UiScroller.Tourist;

public class AdLoanPage implements LoanPage, TabPage{
	
	@SuppressWarnings("static-access")
	private By TITLE = By.id("com.fengjr.mobile:id/title").name("理理财");
	private By SEARCH = By.id("com.fengjr.mobile:id/right");
	
	private By MONEY_A = By.name("凤保宝");
	private By MONEY_B = By.name("凤锐通");
	private By MONEY_C = By.name("凤溢盈");
	
	private By HOME_PAGE = By.id("com.fengjr.mobile:id/ivIndex");
	private By MONEY_PAGE = By.id("com.fengjr.mobile:id/ivMoney");
	private By FUNDING_PAGE = By.id("com.fengjr.mobile:id/ivFunding");
	private By CENTER_PAGE = By.id("com.fengjr.mobile:id/ivCenter");
	
	private By HOME_PAGE_S = By.id("com.fengjr.mobile:id/ivIndexS");
	private By MONEY_PAGE_S = By.id("com.fengjr.mobile:id/ivMoneyS");
	private By FUNDING_PAGE_S = By.id("com.fengjr.mobile:id/ivFundingS");
	private By CENTER_PAGE_S = By.id("com.fengjr.mobile:id/ivCenterS");

	
	public AdLoanPage() {

	}

	@Override
	public boolean goAboutUsPage(PageContext context) {
		goPersonalCenterPage(context);
		return false;
	}

	@Override
	public boolean goAddressInfoPage(PageContext context) {
		goPersonalCenterPage(context);
		return false;
	}

	@Override
	public boolean goConfirmInvestPage(PageContext context) {
		goPersonalCenterPage(context);
		return false;
	}

	@Override
	public boolean goConfirmSupportPage(PageContext context) {
		goCrowdfundingPage(context);
		return false;
	}

	@Override
	public boolean goCrowdfundingDetailPage(PageContext context) {
		goCrowdfundingPage(context);
		return false;
	}

	@Override
	public boolean goCrowdfundingProjectDetails(PageContext context) {
		goCrowdfundingPage(context);
		return false;
	}

	@Override
	public boolean goFeedbackPage(PageContext context) {
		goPersonalCenterPage(context);
		return false;
	}

	@Override
	public boolean goFundsRecord(PageContext context) {
		goPersonalCenterPage(context);
		return false;
	}

	@Override
	public boolean goFundTrusteeshipAccountPage(PageContext context) {
		goPersonalCenterPage(context);
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
		goPersonalCenterPage(context);
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
		return true;
	}

	@Override
	public boolean goCrowdfundingPage(PageContext context) {
		clickFundingTab(context);
		return false;
	}

	@Override
	public boolean goPersonalCenterPage(PageContext context) {
		clickPersonalCenterTab(context);
		return false;
	}

	@Override
	public boolean goSettingPage(PageContext context) {
		goPersonalCenterPage(context);
		return false;
	}

	@Override
	public boolean goInvestRecordPage(PageContext context) {
		goPersonalCenterPage(context);
		return false;
	}

	@Override
	public boolean goMyCrowdfundingPage(PageContext context) {
		goPersonalCenterPage(context);
		return false;
	}

	@Override
	public boolean goFundsRecordPage(PageContext context) {
		goPersonalCenterPage(context);
		return false;
	}

	@Override
	public boolean goIncomeQueryPage(PageContext context) {
		goPersonalCenterPage(context);
		return false;
	}

	@Override
	public boolean goLatestAnnouncementPage(PageContext context) {
		goHomPage(context);
		return false;
	}

	@Override
	public boolean clickLoanItem(PageContext context, String title) {
		
		if (UiObject.searchFor(By.name(title), By.className("android.widget.ListView"))) {
			UiObject.waitFor(By.name(title)).click();
			context.update(LoanDetailsPage.class);
		}
		
		return true;
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
	public boolean goSearchPage(PageContext context) {
		throw new UnsupportedOperationException("not support search operation.");
	}

	@Override
	public List<? extends LoanItem> getLoanItemTop10(PageContext context) {
		
		List<AdLoanItem> loanItems = new ArrayList<AdLoanItem>();
		
		if (UiObject.searchFor(By.className("android.widget.ListView"))) {
			UiScroller<AdLoanItem> scroller = new UiScroller<AdLoanItem>(By.className("android.widget.ListView"), 
					By.xpath("//android.widget.ListView/android.widget.FrameLayout"));
			scroller.traversal(AdLoanItem.class, new LoanTop10Tourist(context, loanItems));
		}
		return loanItems;
	}

	@Override
	public List<? extends LoanItem> getLoanItemInvestable(PageContext context) {

		List<AdLoanItem> loanItems = new ArrayList<AdLoanItem>();
		
		if (UiObject.searchFor(By.className("android.widget.ListView"))) {
			UiScroller<AdLoanItem> scroller = new UiScroller<AdLoanItem>(By.className("android.widget.ListView"), 
					By.xpath("//android.widget.ListView/android.widget.FrameLayout"));
			scroller.traversal(AdLoanItem.class, new LoanInvestableTourist(loanItems));
		}
		return loanItems;
	}
	
	private class LoanInvestableTourist implements Tourist<AdLoanItem> {
		
		private List<AdLoanItem> loanList;
		private boolean stop = false;
		
		public LoanInvestableTourist(List<AdLoanItem> list) {
			loanList = list;
		}

		@Override
		public void start() {
			loanList.clear();
		}

		@Override
		public void notice(AdLoanItem listItem) {

			if (listItem.getStatus().equals("投标")) {
				loanList.add(listItem);
				stop = true;
			} else {
				stop = false;
			}
		}

		@Override
		public void end() {

		}

		@Override
		public boolean stopCondition() {
			return stop;
		}
		
	}

	/**
	 * 获取前理理财列表前10个列表项
	 * @author crest
	 */
	private class LoanTop10Tourist implements Tourist<AdLoanItem> {
		
		private List<AdLoanItem> loanList;
		private boolean stop;
		
		public LoanTop10Tourist(PageContext context, List<AdLoanItem> list) {
			loanList = list;
		}

		@Override
		public void start() {
			loanList.clear();
		}

		@Override
		public void end() {

		}
		
		@Override
		public boolean stopCondition() {
			return stop;
		}

		@Override
		public void notice(AdLoanItem listItem) {
			if (loanList.size() < 10) {
				loanList.add(listItem);
				stop = false;
			} else {
				stop = true;
			}
		}
		
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

	@Override
	public boolean clickFengbbTab(PageContext context) {
		UiObject.waitFor(MONEY_A).click();
		return true;
	}

	@Override
	public boolean clickFengrtTab(PageContext context) {
		UiObject.waitFor(MONEY_B).click();
		return true;
	}

}
