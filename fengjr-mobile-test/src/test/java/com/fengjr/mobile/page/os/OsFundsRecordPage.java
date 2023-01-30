package com.fengjr.mobile.page.os;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import com.fengjr.mobile.base.PageContext;
import com.fengjr.mobile.bean.FundsRecordItem;
import com.fengjr.mobile.bean.os.OsFundsRecordItem;
import com.fengjr.mobile.page.FundsRecordPage;
import com.fengjr.mobile.page.PersonalCenterPage;
import com.fengjr.mobile.utils.UiObject;
import com.fengjr.mobile.utils.UiScroller;
/**
 * 资金流水界面
 * @author crest
 *
 */
public class OsFundsRecordPage implements FundsRecordPage{
	
	//页顶标题
	private By TITLE = By.name("FlowOfFundsView");
	//返回按钮
	private By BACK = By.name("Fengjr return");
	
	private By TABLE = By.className("UIATableView");
	private By TABLE_CELL = By.xpath("//UIATableView/UIATableCell");
	
	public OsFundsRecordPage() {
		
	}
	
	@Override
	public List<? extends FundsRecordItem> getFundRecordList() {
		List<? extends FundsRecordItem> fundsRecordList = new ArrayList<OsFundsRecordItem>();
		
		if (UiObject.searchFor(TABLE)) {
			UiScroller<OsFundsRecordItem> scroller = new UiScroller<OsFundsRecordItem>(TABLE, TABLE_CELL);
			fundsRecordList = scroller.traversal(OsFundsRecordItem.class);
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
	
//	private class FundsRecordListTourist implements Tourist<OsFundsRecordItem> {
//		
//		private List<OsFundsRecordItem> fundsRecordList;
//
//		public FundsRecordListTourist(List<OsFundsRecordItem> list) {
//			fundsRecordList = list;
//		}
//
//		@Override
//		public void start() {
//			fundsRecordList.clear();
//		}
//
//		@Override
//		public void notice(OsFundsRecordItem listItem) {
//			fundsRecordList.add(listItem);
//		}
//
//		@Override
//		public void end() {
//			
//		}
//
//		@Override
//		public boolean stopCondition() {
//			return false;
//		}
//		
//	}
	

}
