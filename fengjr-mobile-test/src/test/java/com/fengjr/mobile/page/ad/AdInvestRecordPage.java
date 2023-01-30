package com.fengjr.mobile.page.ad;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.fengjr.mobile.base.PageContext;
import com.fengjr.mobile.bean.InvestRecordItem;
import com.fengjr.mobile.bean.ad.AdInvestRecordItem;
import com.fengjr.mobile.page.InvestRecordPage;
import com.fengjr.mobile.page.PersonalCenterPage;
import com.fengjr.mobile.utils.UiObject;
import com.fengjr.mobile.utils.UiScroller;
import com.fengjr.mobile.utils.UiScroller.Tourist;

public class AdInvestRecordPage implements InvestRecordPage{
	
	@SuppressWarnings("static-access")
	//页顶标题
	private final static By TITLE = By.id("com.fengjr.mobile:id/title").name("投资管理");
	//返回按钮
	private final static By BACK = By.id("com.fengjr.mobile:id/left");
	// 已持有
	private final static By HOLD = By.id("com.fengjr.mobile:id/hold");
	// 已转让
	private final static By ASSIGN = By.id("com.fengjr.mobile:id/assigned_already");
	
	public AdInvestRecordPage() {
		
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
		return new By[] {TITLE};
	}

	@Override
	public List<? extends InvestRecordItem> getInvestRecordList(int num) {
		List<AdInvestRecordItem> recordList = new ArrayList<AdInvestRecordItem>();
		
		if (UiObject.searchFor(By.className("android.widget.ListView"))) {
			UiScroller<AdInvestRecordItem> scroller = new UiScroller<AdInvestRecordItem>(By.className("android.widget.ListView"), 
					By.xpath("//android.widget.ListView/android.widget.FrameLayout"));
			scroller.traversal(AdInvestRecordItem.class, new InvestRecordTourist(recordList, num));
		}
		
		return recordList;
	}
	
	/**
	 * 监听器用来发现title 为loanTitle的投资记录
	 * @author crest
	 *
	 */
	private class InvestRecordTourist implements Tourist<AdInvestRecordItem> {
		
		private List<AdInvestRecordItem> recordList;
		private int numReturned;
		private boolean stop;
		
		public InvestRecordTourist(List<AdInvestRecordItem> list, int num) {
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
		public void notice(AdInvestRecordItem listItem) {
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
	public boolean clickHold(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean clickTransferred(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
