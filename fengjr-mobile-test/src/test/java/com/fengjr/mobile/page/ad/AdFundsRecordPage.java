package com.fengjr.mobile.page.ad;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.fengjr.mobile.base.PageContext;
import com.fengjr.mobile.bean.FundsRecordItem;
import com.fengjr.mobile.bean.ad.AdFundsRecordItem;
import com.fengjr.mobile.page.FundsRecordPage;
import com.fengjr.mobile.page.PersonalCenterPage;
import com.fengjr.mobile.utils.UiObject;
import com.fengjr.mobile.utils.UiScroller;
import com.fengjr.mobile.utils.UiScroller.Tourist;
/**
 * 资金流水界面
 * @author crest
 *
 */
public class AdFundsRecordPage implements FundsRecordPage{
	
	//页顶标题
	@SuppressWarnings("static-access")
	private By TITLE = By.id("com.fengjr.mobile:id/title").name("资金流水");
	//返回按钮
	private By BACK = By.id("com.fengjr.mobile:id/left");
	public By LIST = By.className("android.widget.ListView");
	public By LIST_ITEM = By.className("android.widget.RelativeLayout");
	
	public AdFundsRecordPage() {
		
	}
	
	@Override
	public List<? extends FundsRecordItem> getFundRecordList() {
		List<AdFundsRecordItem> fundsRecordList = new ArrayList<AdFundsRecordItem>();
		
		if (UiObject.searchFor(By.className("android.widget.ListView"))) {
			UiScroller<AdFundsRecordItem> scroller = new UiScroller<AdFundsRecordItem>(By.className("android.widget.ListView"), 
					By.xpath("//android.widget.ListView/android.widget.RelativeLayout"));
			scroller.traversal(AdFundsRecordItem.class, new FundsRecordListTourist(fundsRecordList));
		}
		return fundsRecordList;
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
		return true;
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
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public By[] getIdentification() {
		return new By[]{TITLE};
	}
	
	private class FundsRecordListTourist implements Tourist<AdFundsRecordItem> {
		
		private List<AdFundsRecordItem> fundsRecordList;

		public FundsRecordListTourist(List<AdFundsRecordItem> list) {
			fundsRecordList = list;
		}

		@Override
		public void start() {
			fundsRecordList.clear();
		}

		@Override
		public void notice(AdFundsRecordItem listItem) {
			fundsRecordList.add(listItem);
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
