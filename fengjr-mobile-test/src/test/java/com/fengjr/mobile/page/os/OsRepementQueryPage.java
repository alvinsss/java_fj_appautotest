package com.fengjr.mobile.page.os;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.fengjr.mobile.base.PageContext;
import com.fengjr.mobile.bean.os.OsRepaymentQueryItem;
import com.fengjr.mobile.page.PersonalCenterPage;
import com.fengjr.mobile.page.RepementQueryPage;
import com.fengjr.mobile.utils.UiObject;
import com.fengjr.mobile.utils.UiScroller;
import com.fengjr.mobile.utils.UiScroller.Tourist;

public class OsRepementQueryPage implements RepementQueryPage{
	
	//页面顶部标题
	private static By TITLE = By.name("ReceivedPaymentsView");
	
	//未来一个月收款总额
	private static By RETUN_MONEY = By.name("totalAmount");
	
	//返回按钮
	private static By BACK = By.name("Fengjr return");
	
	private By TABLE = By.className("UIATableView");
	private By TABLE_CELL = By.xpath("//UIATableView/UIATableCell");
	
	public OsRepementQueryPage() {
		
	}
	
	@Override
	public String getRepementMonth() {
	 	return UiObject.waitFor(RETUN_MONEY).getText();
	}
	
	@Override
	public List<? extends com.fengjr.mobile.bean.RepaymentQueryItem> getRepementList() {
		List<OsRepaymentQueryItem> repementItems = new ArrayList<OsRepaymentQueryItem>();
		
		if (UiObject.searchFor(TABLE)) {
			UiScroller<OsRepaymentQueryItem> scroller = new UiScroller<OsRepaymentQueryItem>(TABLE, TABLE_CELL);
			scroller.traversal(OsRepaymentQueryItem.class, new RepementListTourist(repementItems));
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
	private class RepementListTourist implements Tourist<OsRepaymentQueryItem>{
		
		private List<OsRepaymentQueryItem> repementList;
		
		public RepementListTourist(List<OsRepaymentQueryItem> list) {
			repementList = list;
		}

		@Override
		public void start() {
			repementList.clear();
		}

		@Override
		public void notice(OsRepaymentQueryItem listItem) {
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
	
	/**
	 * 回款查询列表项
	 * @author crest
	 *
	 */
	public class RepaymentQueryItem {
		
		// 回款标题
		private String repementTitle;
		private By REPEMENT_TITLE = By.id("com.fengjr.mobile:id/title");
		
		// 回款日期
		private String repementDate;
		private By REPEMENT_DATE = By.id("com.fengjr.mobile:id/date");
		
		// 回款金额
		private String repementAmmount;
		private By REPEMENT_AMMOUNT = By.id("com.fengjr.mobile:id/return_money_value");
		
		public RepaymentQueryItem(WebElement uio) {
			
			try {
				WebElement titlElm = uio.findElement(REPEMENT_TITLE);
				repementTitle = titlElm.getText();
				
				WebElement dateElm = uio.findElement(REPEMENT_DATE);
				repementDate = dateElm.getText();
				
				WebElement ammountElm = uio.findElement(REPEMENT_AMMOUNT);
				repementAmmount = ammountElm.getText();
				
			} catch (Exception e) {
				throw new RuntimeException("Failed to create RepementListItem");
			}
		}

		public String getRepementTitle() {
			return repementTitle;
		}

		public String getRepementDate() {
			return repementDate;
		}

		public String getRepementAmmount() {
			return repementAmmount;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((repementAmmount == null) ? 0 : repementAmmount.hashCode());
			result = prime * result
					+ ((repementDate == null) ? 0 : repementDate.hashCode());
			result = prime * result
					+ ((repementTitle == null) ? 0 : repementTitle.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			RepaymentQueryItem other = (RepaymentQueryItem) obj;
			if (repementAmmount == null) {
				if (other.repementAmmount != null)
					return false;
			} else if (!repementAmmount.equals(other.repementAmmount))
				return false;
			if (repementDate == null) {
				if (other.repementDate != null)
					return false;
			} else if (!repementDate.equals(other.repementDate))
				return false;
			if (repementTitle == null) {
				if (other.repementTitle != null)
					return false;
			} else if (!repementTitle.equals(other.repementTitle))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "RepaymentQueryItem [repementTitle=" + repementTitle
					+ ", repementDate=" + repementDate + ", repementAmmount="
					+ repementAmmount + "]";
		}
		
		
	}

}
