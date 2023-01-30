package com.fengjr.android.test;

import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fengjr.android.exception.UiObjectNotFoundException;
import com.fengjr.android.lexicon.IInvestPage;
import com.fengjr.android.lexicon.ISearchPage;
import com.fengjr.android.lexicon.imp.LoanList;
import com.fengjr.android.lexicon.imp.SearchPage;
import com.fengjr.android.uiobj.UiObject;
import com.fengjr.android.utils.Result;
import com.fengjr.model.enums.LoanPurpose;


public class DLoansTest extends TestCaseBase {
	
	// 客户端凤保宝贷款列表
	private LoanList moneyAList;
	
	// 客户端凤锐通贷款列表
	private LoanList moneyBList;
	
	/**
	 * 进入理理财投资界面
	 * @throws UiObjectNotFoundException 
	 * @throws InterruptedException 
	 */
	@BeforeMethod
	public void beforeMethod() throws UiObjectNotFoundException, InterruptedException {
		getNavigator().setReset(true);
		getNavigator().enterLoanPage();
	}
	
	/**
	 * 4.1 
	 * 1.1 凤保宝列表是否与服务器返回一致，排序是否正常
	 * @throws InterruptedException
	 * @throws UiObjectNotFoundException 
	 */
	@Test
	public void testLoansOrderBB() throws UiObjectNotFoundException {
		
		if (moneyAList == null) {
			UiObject.waitFor(IInvestPage.MONEY_A).click();
			moneyAList = new LoanList(LoanPurpose.FENG_CX);
		}
		
//		Reporter.log(moneyAList.toString(), true);
		Result result = moneyAList.testLoansOrder();
		result.assertResult();
	}
	
	/**
	 * 1.2 凤保宝贷款金额是否与服务器返回一致，是否显示正常
	 * @throws UiObjectNotFoundException
	 */
	@Test
	public void testLoansAmmountBB() throws UiObjectNotFoundException {
		if (moneyAList == null) {
			UiObject.waitFor(IInvestPage.MONEY_A).click();
			moneyAList = new LoanList(LoanPurpose.FENG_CX);
		}
		
//		Reporter.log(moneyAList.toString(), true);
		Result result = moneyAList.testLoansAmmount();
		result.assertResult();		
	}
	
	/**
	 * 1.3 凤保宝投资期限是否展现正常，是否与服务器返回一致
	 * @throws UiObjectNotFoundException 
	 */
	@Test
	public void testLoansExpireBB() throws UiObjectNotFoundException {
		if (moneyAList == null) {
			UiObject.waitFor(IInvestPage.MONEY_A).click();
			moneyAList = new LoanList(LoanPurpose.FENG_CX);
		}
		
//		Reporter.log(moneyAList.toString(), true);
		Result result = moneyAList.testLoansExpire();
		result.assertResult();
	}
	
	/**
	 * 1.4 凤保宝年利率是否展现正常，是否与服务器返回一致
	 * @throws UiObjectNotFoundException
	 */
	@Test
	public void testLoansRateBB () throws UiObjectNotFoundException {
		if (moneyAList == null) {
			UiObject.waitFor(IInvestPage.MONEY_A).click();
			moneyAList = new LoanList(LoanPurpose.FENG_CX);
		}
		
//		Reporter.log(moneyAList.toString(), true);
		Result result = moneyAList.testLoansRate();
		result.assertResult();
	}
	
	/**
	 * 1.5 凤保宝年利率是否展现正常，是否与服务器返回一致
	 * @throws UiObjectNotFoundException
	 */
	@Test
	public void testLoansStatusBB () throws UiObjectNotFoundException {
		if (moneyAList == null) {
			UiObject.waitFor(IInvestPage.MONEY_A).click();
			moneyAList = new LoanList(LoanPurpose.FENG_CX);
		}
		
//		Reporter.log(moneyAList.toString(), true);
		Result result = moneyAList.testLoansStatus();
		result.assertResult();
	}
	
	/**
	 * 2.1 凤锐通列表排序：第一排序按状态，第而排序按回报率
	 */
	@Test
	public void testLoansOrderRT() throws UiObjectNotFoundException {
		
		if (moneyBList == null) {
			UiObject.waitFor(IInvestPage.MONEY_B).click();
			moneyBList = new LoanList(LoanPurpose.FENG_RT);
		}

//		Reporter.log(moneyBList.toString(), true);
		Result result = moneyBList.testLoansOrder();
		result.assertResult();
	}
	
	/**
	 * 2.2 凤锐通贷款金额是否显示正常，是否与服务器返回一致
	 * @throws UiObjectNotFoundException
	 */
	@Test
	public void testLoansAmountRT() throws UiObjectNotFoundException {
		if (moneyBList == null) {
			UiObject.waitFor(IInvestPage.MONEY_B).click();
			moneyBList = new LoanList(LoanPurpose.FENG_RT);
		}

//		Reporter.log(moneyBList.toString(), true);
		Result result = moneyBList.testLoansAmmount();
		result.assertResult();
	}
	
	/**
	 * 2.3 凤锐通投资期限是否展现正常，是否与服务器返回一致
	 * @throws UiObjectNotFoundException 
	 */
	@Test
	public void testLoansExpireRT() throws UiObjectNotFoundException {
		if (moneyBList == null) {
			UiObject.waitFor(IInvestPage.MONEY_B).click();
			moneyBList = new LoanList(LoanPurpose.FENG_RT);
		}
		
//		Reporter.log(moneyBList.toString(), true);
		Result result = moneyBList.testLoansExpire();
		result.assertResult();
	}
	
	/**
	 * 2.4 测试年利率是否展现正常，是否与服务器返回一致
	 * @throws UiObjectNotFoundException
	 */
	@Test
	public void testLoansRateRT () throws UiObjectNotFoundException {
		if (moneyBList == null) {
			UiObject.waitFor(IInvestPage.MONEY_B).click();
			moneyBList = new LoanList(LoanPurpose.FENG_RT);
		}
		
//		Reporter.log(moneyBList.toString(), true);
		Result result = moneyBList.testLoansRate();
		result.assertResult();
	}
	
	/**
	 * 2.5 测试凤锐通贷款状态是否展现正常，是否与服务器返回一致
	 * @throws UiObjectNotFoundException
	 */
	@Test
	public void testLoansStatusRT () throws UiObjectNotFoundException {
		if (moneyBList == null) {
			UiObject.waitFor(IInvestPage.MONEY_B).click();
			moneyBList = new LoanList(LoanPurpose.FENG_RT);
		}
		
//		Reporter.log(moneyBList.toString(), true);
		Result result = moneyBList.testLoansStatus();
		result.assertResult();
	}
	
	/**
	 * 4.2 可根据指定内容进行搜索
	 * 
	 * 1.类型，2.期限，3.收益率
	 * @throws UiObjectNotFoundException 
	 */
	@Test
	public void testSearchBB() throws UiObjectNotFoundException {
		getNavigator().enterInvestSearchPage();
		//点击搜索按钮
		SearchPage searchPage = new SearchPage(LoanPurpose.FENG_CX);
		List<Result> results = searchPage.testSearchResult();
		for (Result result: results) {
			result.assertResult();
		}
	}
	
	@Test
	public void testSearchRT() throws UiObjectNotFoundException {
		getNavigator().enterInvestSearchPage();
		//点击搜索按钮
		SearchPage searchPage = new SearchPage(LoanPurpose.FENG_RT);
		List<Result> results = searchPage.testSearchResult();
		for (Result result: results) {
			result.assertResult();
		}
	}
	
	/**
	 * 4.3 凤保宝项目详情页
	 * @throws UiObjectNotFoundException 
	 */
	@Test
	public void testLoansDetailBB() throws UiObjectNotFoundException {
//		getNavigator().enterInvestADetailPage();
//		UiObject uio = new UiObject(By.className("android.widget.ScrollView"));
//		LoadDetails details = new LoadDetails(uio, LoadDetails.COMPANY);
//		Reporter.log("LoadDetails-BB [loadDetails=" + details + "]", true);
//		UiObject.waitFor(LoadDetails.BACK).click();
	}
	
	/**
	 * 4.4 凤锐通项目详情页
	 * @throws UiObjectNotFoundException 
	 */
	@Test
	public void testLoansDetailRT() throws UiObjectNotFoundException {
//		getNavigator().enterInvestBDetailPage();
//		UiObject uio = new UiObject(By.className("android.widget.ScrollView"));
//		LoadDetails details = new LoadDetails(uio, LoadDetails.PERSONAL);
//		Reporter.log("LoadDetails-RT [loadDetails=" + details + "]", true);
//		UiObject.waitFor(LoadDetails.BACK).click();
	}
	
}
