package com.fengjr.mobile.page.os;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import com.fengjr.mobile.base.PageContext;
import com.fengjr.mobile.bean.RepaymentPlanItem;
import com.fengjr.mobile.bean.ad.AdRepaymentPlanItem;
import com.fengjr.mobile.bean.os.OsRepaymentPlanItem;
import com.fengjr.mobile.page.InvestRecordPage;
import com.fengjr.mobile.page.RepaymentPlan;
import com.fengjr.mobile.utils.UiObject;
import com.fengjr.mobile.utils.UiScroller;
import com.fengjr.mobile.utils.UiScroller.Tourist;

public class OsRepaymentPlan implements RepaymentPlan{
	
	// 页顶标题
	private final static By TITLE = By.name("ic_nav_repayment_plan");
	// 页顶返回按钮
	private final static By BACK = By.name("Fengjr return");
	
	private By TABLE = By.className("UIATableView");
	private By TABLE_CELL = By.xpath("//UIATableView/UIATableCell");
	
	public OsRepaymentPlan() {
		
	}
	
	@Override
	public List<? extends RepaymentPlanItem> getRepaymentPlanList() {
		List<OsRepaymentPlanItem> repementItems = new ArrayList<OsRepaymentPlanItem>();
		
		if (UiObject.searchFor(TABLE)) {
			UiScroller<OsRepaymentPlanItem> scroller = new UiScroller<OsRepaymentPlanItem>(TABLE, TABLE_CELL);
			scroller.traversal(OsRepaymentPlanItem.class, new RepaymentPlanTourist(repementItems));
		}
		return repementItems;
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
		return true;
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
		context.update(InvestRecordPage.class);
		return true;
	}

	@Override
	public boolean exitApp(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public By[] getIdentification() {
		return new By[] {TITLE};
	}
	
	
	public class RepaymentPlanTourist implements Tourist<OsRepaymentPlanItem> {
		
		private List<OsRepaymentPlanItem> repaymentList;
		
		public RepaymentPlanTourist(List<OsRepaymentPlanItem> list) {
			repaymentList = list;
		}

		@Override
		public void start() {
			repaymentList.clear();
		}

		@Override
		public void notice(OsRepaymentPlanItem listItem) {
			repaymentList.add(listItem);
		}

		@Override
		public void end() {
			
		}

		@Override
		public boolean stopCondition() {
			return false;
		}
		
	}

	

}
