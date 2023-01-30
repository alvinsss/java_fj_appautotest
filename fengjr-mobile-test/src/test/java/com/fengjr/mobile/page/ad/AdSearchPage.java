package com.fengjr.mobile.page.ad;

import org.openqa.selenium.By;

import com.fengjr.mobile.base.PageContext;
import com.fengjr.mobile.page.LoanPage;
import com.fengjr.mobile.page.SearchPage;
import com.fengjr.mobile.page.SearchResultPage;
import com.fengjr.mobile.utils.UiObject;

public class AdSearchPage implements SearchPage{
	
	public final static By SEARCH = By.id("com.fengjr.mobile:id/search");
	public final static By BACK = By.id("com.fengjr.mobile:id/left");
	
	private By searchBtn = By.id("com.fengjr.mobile:id/search");
	
	private By type = By.id("com.fengjr.mobile:id/type");
	private By duration = By.id("com.fengjr.mobile:id/duration");
	private By rate = By.id("com.fengjr.mobile:id/rate");
	
	private By typeBB = By.id("com.fengjr.mobile:id/typeFengBao");
	private By typeRT = By.id("com.fengjr.mobile:id/typeFengTong");
	
	//凤锐通 期限 所有； 凤保宝 期限 所有
	private By duraItem0 = By.id("com.fengjr.mobile:id/itemDuration0");
	//凤锐通 期限 1-3个月； 凤保宝 期限 1-3 个月
	private By duraItem1 = By.id("com.fengjr.mobile:id/itemDuration1");
	//凤锐通 期限 4-6个月； 凤保宝 期限 4-6 个月
	private By duraItem2 = By.id("com.fengjr.mobile:id/itemDuration2");
	//凤锐通 期限 7-12个月； 凤保宝 期限 7-12 个月
	private By duraItem3 = By.id("com.fengjr.mobile:id/itemDuration3");
	//凤锐通 期限 13-24个月； 
	private By duraItem4 = By.id("com.fengjr.mobile:id/itemDuration4");
	//凤锐通 期限 25个月以上
	private By duraItem5 = By.id("com.fengjr.mobile:id/itemDuration5");
	
	//凤锐通 所有； 凤保宝 所有
	private By rateItem0 = By.id("com.fengjr.mobile:id/itemRateAll");
	//凤锐通 9%以下； 凤保宝 8%以下
	private By rateItem1 = By.id("com.fengjr.mobile:id/itemRateLevel1");
	//凤锐通 9%-11%； 凤保宝 8%-10%
	private By rateItem2 = By.id("com.fengjr.mobile:id/itemRateLevel2");
	//凤锐通 11%-13%； 凤保宝 10%-11%
	private By rateItem3 = By.id("com.fengjr.mobile:id/itemRateLevel3");
	//凤锐通 13%以上； 凤保宝 11%以上
	private By rateItem4 = By.id("com.fengjr.mobile:id/itemRateLevel4");
	
	public AdSearchPage() {
		
	}
	
	@Override
	public boolean selectTypeFengbb(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean selectTypeFengrt(PageContext context) {
		UiObject.waitFor(type).click();
		UiObject.waitFor(typeRT).click();
		return true;
	}
	@Override
	public boolean selectDurationAllMonth(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean selectDuration_1_3Month(PageContext context) {
		UiObject.waitFor(duration).click();
		UiObject.waitFor(duraItem1).click();
		return true;
	}
	@Override
	public boolean selectDuration_4_6Month(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean selectDuration_7_12Month(PageContext context) {
		UiObject.waitFor(duration).click();
		UiObject.waitFor(duraItem3).click();
		return true;
	}
	@Override
	public boolean selectDuration_13_24Month(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean selectDurationBigger25Month(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean selectRateAll(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean selectRateBlow8(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean selectRate_8_10(PageContext context) {
		UiObject.waitFor(rate).click();
		return false;
	}
	@Override
	public boolean selectRate_10_11(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean selectRateBigger11(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean selcetRateBlow9(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean selectRate_9_11(PageContext context) {
		UiObject.waitFor(rate).click();
		UiObject.waitFor(rateItem2).click();
		return true;
	}
	@Override
	public boolean selectRate_11_13(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean selectRateBigger13(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean clickSearch(PageContext context) {
		UiObject.waitFor(SEARCH).click();
		context.update(SearchResultPage.class);
		return true;
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
		return true;
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
		context.update(LoanPage.class);
		return true;
	}
	@Override
	public boolean exitApp(PageContext context) {
		// TODO Auto-generated method stub
		return false;
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
	public By[] getIdentification() {
		return new By[]{SEARCH};
	}

}
