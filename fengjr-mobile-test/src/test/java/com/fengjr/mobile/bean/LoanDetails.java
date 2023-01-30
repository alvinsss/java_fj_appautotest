package com.fengjr.mobile.bean;
//package com.fengjr.mobile.bean.ad.loan;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//
//import com.fengjr.android.uiobj.UiObject;
//import com.fengjr.model.enums.LoanPurpose;
//
//public class LoanDetails {
//	
//	public final static By TITLE = By.id("com.fengjr.mobile:id/title");
//	public final static By TIME_STATUS = By.id("com.fengjr.mobile:id/timeStatus");
//	
//	public final static By RATE = By.id("com.fengjr.mobile:id/rate");
//	public final static By PAY_TYPE = By.id("com.fengjr.mobile:id/pay_detail");
//	
//	public final static By DURATION = By.id("com.fengjr.mobile:id/duration");
//	public final static By AMOUNT = By.id("com.fengjr.mobile:id/amount");
//	public final static By BORROW_MONEY_FOR = By.id("com.fengjr.mobile:id/tv_money_for_title");
//	
//	public final static By SECURITY_INSTITUTION = By.id("com.fengjr.mobile:id/layout_baozhang_content");
//	public final static By PERSONAL_INFO = By.id("com.fengjr.mobile:id/layout_person_info_content");
//	public final static By PERSONAL_WORK_INFO = By.id("com.fengjr.mobile:id/layout_person_work_info_content");
//	public final static By PERSONAL_CHECK_STATE = By.id("com.fengjr.mobile:id/layout_audit_info");
//	
//	public final static By COMPANY_INFO = By.id("com.fengjr.mobile:id/layout_company_info_content");
//	public final static By COMPANY_CHECK_STATE = By.id("com.fengjr.mobile:id/layout_audit_info_company");
//	
//	public final static By BACK = By.id("com.fengjr.mobile:id/left");
//	public final static By CONFIRM_INVEST = By.id("com.fengjr.mobile:id/confirmInvest");
//	
//	// 借款项目编号
//	private String title;
//	// 时间状态
//	private String timestatus;
//	
//	// 年利率
//	private String rate;
//	// 回款类型
//	private String payType;
//
//	// 借款期限
//	private String duration;
//	// 借款总额
//	private String amount;
//	// 借款用途
//	private String borrowMoneyFor;
//
//	// 保障机构
//	private Map<String,String> securityInstitution;
//	
//	// 借款人身份信息
//	private Map<String,String> personalInfo;
//	// 借款人工作信息
//	private Map<String,String> personalWorkInfo;
//	// 借款人审核状态
//	private Map<String,String> personalCheckState;
//	// 公司信息
//	private Map<String,String> companyInfo;
//	// 公司审核状态
//	private Map<String,String> companyCheckState; 
//	
//	// 确认投资按钮
//	private UiObject confirmInvest;
//	
//	private LoanPurpose loanPurpose;
//	
//	public LoanDetails() {
//		
//		UiObject uio = new UiObject(By.className("android.widget.ScrollView"));
//	 
//		if (UiObject.searchFor(TITLE)) {
//			WebElement titleElm = uio.findElement(TITLE);
//			title = titleElm.getText();
//		}
//		 
//		if (UiObject.searchFor(TIME_STATUS)) {
//			WebElement timestatusElm = uio.findElement(TIME_STATUS);
//			timestatus = timestatusElm.getText();
//		}
//		
//		if (UiObject.searchFor(RATE)) {
//			WebElement rateElm = uio.findElement(RATE);
//			rate = rateElm.getText();
//		}
//		
//		if (UiObject.searchFor(PAY_TYPE)) {
//			WebElement payTypeElm = uio.findElement(PAY_TYPE);
//			payType = payTypeElm.getText();
//		}
//
//		if (UiObject.searchFor(DURATION)) {
//			WebElement durationElm = uio.findElement(DURATION);
//			duration = durationElm.getText();
//		}
//		
//		if (UiObject.searchFor(AMOUNT)) {
//			WebElement amountElm = uio.findElement(AMOUNT);
//			amount = amountElm.getText();
//		}
//		
//		if (UiObject.searchFor(SECURITY_INSTITUTION, true)) {
//			WebElement securityInstitutionElm = uio.findElement(SECURITY_INSTITUTION);
//			securityInstitution = readKeyValue(securityInstitutionElm);
//		}
//		
//		if (UiObject.searchFor(BORROW_MONEY_FOR, true)) {
//			WebElement borrowMoneyForElm = uio.findElement(BORROW_MONEY_FOR);
//			borrowMoneyFor = borrowMoneyForElm.getText();
//		}
//		
//		if (UiObject.searchFor(CONFIRM_INVEST)) {
//			confirmInvest = new UiObject(CONFIRM_INVEST);
//		} else {
//			confirmInvest = null;
//		}
//		
//		UiObject uios = new UiObject(PERSONAL_INFO);
//		if (uios.exist()) {
//			
//			loanPurpose = LoanPurpose.FENG_RT;
//			
//			if (UiObject.searchFor(PERSONAL_INFO, true) && UiObject.searchFor(PERSONAL_WORK_INFO, true)) {
//				WebElement personalInfoElm = uio.findElement(PERSONAL_INFO);
//				personalInfo = readKeyValue(personalInfoElm);
//			}
//			
//			if ( UiObject.searchFor(PERSONAL_WORK_INFO, true) && UiObject.searchFor(PERSONAL_CHECK_STATE, true)) {
//				WebElement personalWorkInfoElm = uio.findElement(PERSONAL_WORK_INFO);
//				personalWorkInfo = readKeyValue(personalWorkInfoElm);
//			}
//			
//			if (UiObject.searchFor(PERSONAL_CHECK_STATE, true)) {
//				uio.scrollDown();
//				WebElement personalCheckStateElm = uio.findElement(PERSONAL_CHECK_STATE);
//				personalCheckState = readKeyValue(personalCheckStateElm);
//			}
//		} else {
//			
//			loanPurpose = LoanPurpose.FENG_CX;
//			
//			if (UiObject.searchFor(COMPANY_INFO, true) && UiObject.searchFor(COMPANY_CHECK_STATE, true)) {
//				WebElement companyInfoElm = uio.findElement(COMPANY_INFO);
//				companyInfo = readKeyValue(companyInfoElm);
//			}
//			
//			if (UiObject.searchFor(COMPANY_CHECK_STATE, true)) {
//				uio.scrollDown();
//				WebElement companyCheckStateElm = uio.findElement(COMPANY_CHECK_STATE);
//				companyCheckState = readKeyValue(companyCheckStateElm);
//			}
//		}
//	}
//	
//	/**
//	 * 页面中是否有确认投资按钮
//	 * @return
//	 */
//	public boolean hasConfirmInvestButton() {
//		if (confirmInvest == null) return false;
//		else return true;
//	}
//	
//	/**
//	 * 点击确认投资按钮
//	 * @return
//	 */
//	public boolean clickConfirmInvest() {
//		UiObject uio = new UiObject(COMPANY_CHECK_STATE);
//		if (uio.exist()) {
//			uio.click();
//			return true;
//		}
//		return false;
//	}
//	
//	/**
//	 * 
//	 * @return
//	 */
//	public boolean clickBack() {
//		UiObject uio = new UiObject(BACK);
//		if (uio.exist()) {
//			uio.click();
//			return true;
//		}
//		return false;
//	}
//	
//	/**
//	 * 获得借贷类型
//	 * @return
//	 */
//	public LoanPurpose getPurpose() {
//		return loanPurpose;
//	}
//	
//	/**
//	 * 从界面中读取键值对
//	 * @param elm
//	 * @return
//	 */
//	private Map<String,String> readKeyValue(WebElement elm) {
//		Map<String, String> map = new HashMap<String,String>();
//		List<WebElement> thList = elm.findElements(By.id("com.fengjr.mobile:id/th"));
//		List<WebElement> tdList = elm.findElements(By.id("com.fengjr.mobile:id/td"));
//		if (thList.size() == tdList.size()) {
//			for (int i = 0; i < thList.size(); i++) {
//				String key = thList.get(i).getText();
//				String value = tdList.get(i).getText();
//				map.put(key, value);
//			}
//		}
//		return map;
//	}
//
//	@Override
//	public String toString() {
//		return "LoadDetails [title=" + title + ", timestatus=" + timestatus
//				+ ", rate=" + rate + ", payType=" + payType + ", duration="
//				+ duration + ", amount=" + amount + ", borrowMoneyFor="
//				+ borrowMoneyFor + ", securityInstitution="
//				+ securityInstitution + ", personalInfo=" + personalInfo
//				+ ", personalWorkInfo=" + personalWorkInfo
//				+ ", personalCheckState=" + personalCheckState
//				+ ", companyInfo=" + companyInfo + ", companyCheckState="
//				+ companyCheckState + "]";
//	}
//}
