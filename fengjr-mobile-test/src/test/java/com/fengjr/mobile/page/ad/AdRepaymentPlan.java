package com.fengjr.mobile.page.ad;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.fengjr.mobile.base.PageContext;
import com.fengjr.mobile.bean.RepaymentPlanItem;
import com.fengjr.mobile.bean.ad.AdRepaymentPlanItem;
import com.fengjr.mobile.page.InvestRecordPage;
import com.fengjr.mobile.page.RepaymentPlan;
import com.fengjr.mobile.utils.UiObject;
import com.fengjr.mobile.utils.UiScroller;
import com.fengjr.mobile.utils.UiScroller.Tourist;

public class AdRepaymentPlan implements RepaymentPlan{
	
	// 页顶标题
	@SuppressWarnings("static-access")
	private final static By TITLE = By.id("com.fengjr.mobile:id/title").name("还款计划");
	// 页顶返回按钮
	private final static By BACK = By.id("com.fengjr.mobile:id/left");
	
	public AdRepaymentPlan() {
		
	}
	
	@Override
	public List<? extends RepaymentPlanItem> getRepaymentPlanList() {
		List<AdRepaymentPlanItem> repementItems = new ArrayList<AdRepaymentPlanItem>();
		
		if (UiObject.searchFor(By.className("android.widget.ListView"))) {
			UiScroller<AdRepaymentPlanItem> scroller = new UiScroller<AdRepaymentPlanItem>(By.className("android.widget.ListView"), 
					By.xpath("//android.widget.ListView/android.widget.RelativeLayout"));
			scroller.traversal(AdRepaymentPlanItem.class, new RepaymentPlanTourist(repementItems));
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
	
	
	public class RepaymentPlanTourist implements Tourist<AdRepaymentPlanItem> {
		
		private List<AdRepaymentPlanItem> repaymentList;
		
		public RepaymentPlanTourist(List<AdRepaymentPlanItem> list) {
			repaymentList = list;
		}

		@Override
		public void start() {
			repaymentList.clear();
		}

		@Override
		public void notice(AdRepaymentPlanItem listItem) {
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
