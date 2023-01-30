package com.fengjr.mobile.page.os;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.fengjr.mobile.base.PageContext;
import com.fengjr.mobile.bean.InvestRecordItem;
import com.fengjr.mobile.bean.ad.AdInvestRecordItem;
import com.fengjr.mobile.bean.os.OsInvestRecordItem;
import com.fengjr.mobile.page.CrowdfundingPage;
import com.fengjr.mobile.page.HomePage;
import com.fengjr.mobile.page.InvestRecordPage;
import com.fengjr.mobile.page.LoanPage;
import com.fengjr.mobile.page.PersonalCenterPage;
import com.fengjr.mobile.page.TabPage;
import com.fengjr.mobile.utils.UiObject;
import com.fengjr.mobile.utils.UiScroller;
import com.fengjr.mobile.utils.UiScroller.Tourist;

public class OsInvestRecordPage implements InvestRecordPage, TabPage{

	//页顶标题
	private final static By TITLE = By.name("ic_nav_receivableMGR");
	//持有Tab页面
	private final static By HOLD = By.name("持有"); 
	//已转让Tab页面
	private final static By CHANGE = By.name("已转让");
	//返回按钮
	private final static By BACK = By.name("Fengjr return");
	
	private By TABLE = By.className("UIATableView");
	private By TABLE_CELL = By.xpath("//UIATableView/UIATableCell");
	
	public static By HOME_PAGE = By.name("ivIndex");
	public static By MONEY_PAGE = By.name("ivMoney");
	public static By FUNDING_PAGE = By.name("ivFunding");
	public static By CENTER_PAGE = By.name("ivCenter");
	
	public static By HOME_PAGE_S = By.name("ivIndexS");
	public static By MONEY_PAGE_S = By.name("ivMoneyS");
	public static By FUNDING_PAGE_S = By.name("ivFundingS");
	public static By CENTER_PAGE_S = By.name("ivCenterS");

	
	public OsInvestRecordPage() {
		
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
		return true;
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
		goBack(context);
		return false;
	}

	@Override
	public By[] getIdentification() {
		return new By[] {TITLE, HOLD, CHANGE};
	}

	@Override
	public List<? extends InvestRecordItem> getInvestRecordList(int num) {
		List<OsInvestRecordItem> recordList = new ArrayList<OsInvestRecordItem>();
		
		if (UiObject.searchFor(TABLE)) {
			UiScroller<OsInvestRecordItem> scroller = new UiScroller<OsInvestRecordItem>(TABLE, TABLE_CELL);
			scroller.traversal(OsInvestRecordItem.class, new InvestRecordTourist(recordList, num));
		}
		
		return recordList;
	}
	
	/**
	 * 监听器用来发现title 为loanTitle的投资记录
	 * @author crest
	 *
	 */
	private class InvestRecordTourist implements Tourist<OsInvestRecordItem> {
		
		private List<OsInvestRecordItem> recordList;
		private int numReturned;
		private boolean stop;
		
		public InvestRecordTourist(List<OsInvestRecordItem> list, int num) {
			recordList = list;
			numReturned = num;
		}

		@Override
		public void start() {
			recordList.clear();
		}
		
		@Override
		public void end() {
			
		}

		@Override
		public void notice(OsInvestRecordItem listItem) {
			Logger.getRootLogger().info(listItem.toString());
			if (recordList.size() < numReturned) {
				recordList.add(listItem);
				stop = false;
			} else {
				stop = true;
			}
		}

		@Override
		public boolean stopCondition() {
			return stop;
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
	public boolean clickHold(PageContext context) {
		UiObject.waitFor(HOLD).click();
		return true;
	}

	@Override
	public boolean clickTransferred(PageContext context) {
		UiObject.waitFor(CHANGE).click();
		return true;
	}
	
}
