package com.fengjr.mobile.page.ad;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.fengjr.mobile.base.PageContext;
import com.fengjr.mobile.bean.RepaymentQueryItem;
import com.fengjr.mobile.bean.ad.AdRepaymentQueryItem;
import com.fengjr.mobile.page.PersonalCenterPage;
import com.fengjr.mobile.page.RepementQueryPage;
import com.fengjr.mobile.utils.UiObject;
import com.fengjr.mobile.utils.UiScroller;
import com.fengjr.mobile.utils.UiScroller.Tourist;

public class AdRepementQueryPage implements RepementQueryPage{
	
	//页面顶部标题
	@SuppressWarnings("static-access")
	private static By TITLE = By.id("com.fengjr.mobile:id/title").name("回款查询");
	
	//未来一个月收款总额
	private static By RETUN_MONEY = By.id("com.fengjr.mobile:id/amount_return_money");
	
	//返回按钮
	private static By BACK = By.id("com.fengjr.mobile:id/left");
	
	public AdRepementQueryPage() {
		
	}
	
	@Override
	public String getRepementMonth() {
	 	return UiObject.waitFor(RETUN_MONEY).getText();
	}
	
	@Override
	public List<? extends RepaymentQueryItem> getRepementList() {
		List<AdRepaymentQueryItem> repementItems = new ArrayList<AdRepaymentQueryItem>();
		
		if (UiObject.searchFor(By.className("android.widget.ListView"))) {
			UiScroller<AdRepaymentQueryItem> scroller = new UiScroller<AdRepaymentQueryItem>(By.className("android.widget.ListView"), 
					By.xpath("//android.widget.ListView/android.widget.RelativeLayout"));
			scroller.traversal(AdRepaymentQueryItem.class, new RepementListTourist(repementItems));
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
		goBack(context);
		return false;
	}

	@Override
	public boolean goIncomeQueryPage(PageContext context) {
		return true;
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
	
	/**
	 * 遍历回款查询列表
	 * @author crest
	 *
	 */
	private class RepementListTourist implements Tourist<AdRepaymentQueryItem>{
		
		private List<AdRepaymentQueryItem> repementList;
		
		public RepementListTourist(List<AdRepaymentQueryItem> list) {
			repementList = list;
		}

		@Override
		public void start() {
			repementList.clear();
		}

		@Override
		public void notice(AdRepaymentQueryItem listItem) {
			repementList.add(listItem);
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
