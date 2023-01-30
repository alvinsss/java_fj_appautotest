package com.fengjr.android.lexicon.imp;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import com.fengjr.android.exception.UiObjectNotFoundException;
import com.fengjr.android.lexicon.ISearchPage;
import com.fengjr.android.uiobj.UiObject;
import com.fengjr.android.utils.Result;
import com.fengjr.model.FilterParam;
import com.fengjr.model.enums.LoanPurpose;

public class SearchPage {
 
	private LoanPurpose loanPurpose;
	
	private By searchBtn = By.id("com.fengjr.mobile:id/search");
	
	private By type = By.id("com.fengjr.mobile:id/type");
	private By duration = By.id("com.fengjr.mobile:id/duration");
	private By rate = By.id("com.fengjr.mobile:id/rate");
	
	private By typeBB = By.id("com.fengjr.mobile:id/typeFengBao");
	private By typeRT = By.id("com.fengjr.mobile:id/typeFengTong");
	
	private By duraItem0 = By.id("com.fengjr.mobile:id/itemDuration0");
	private By duraItem1 = By.id("com.fengjr.mobile:id/itemDuration1");
	private By duraItem2 = By.id("com.fengjr.mobile:id/itemDuration2");
	private By duraItem3 = By.id("com.fengjr.mobile:id/itemDuration3");
	private By duraItem4 = By.id("com.fengjr.mobile:id/itemDuration4");
	private By duraItem5 = By.id("com.fengjr.mobile:id/itemDuration5");
	
	private By rateItem0 = By.id("com.fengjr.mobile:id/itemRateAll");
	private By rateItem1 = By.id("com.fengjr.mobile:id/itemRateLevel1");
	private By rateItem2 = By.id("com.fengjr.mobile:id/itemRateLevel2");
	private By rateItem3 = By.id("com.fengjr.mobile:id/itemRateLevel3");
	private By rateItem4 = By.id("com.fengjr.mobile:id/itemRateLevel4");
	
	int[][] durationsBB = {{0,60}, {1,3}, {4,6}, {7,12}};
	int[][] ratesBB = {{0,100}, {0,8}, {8,10}, {10,11}, {11,100}};
	By[] duraByBB = {duraItem0, duraItem1, duraItem2, duraItem3};
	By[] rateByBB = {rateItem0, rateItem1, rateItem2, rateItem3, rateItem4};
	
	int[][] durationsRT = {{0,60}, {1,3}, {4,6}, {7,12}, {13, 24}, {25, 60}};
	int[][] ratesRT = {{0,100}, {0,9}, {9,11}, {11,13}, {13, 100}};
	By[] duraByRT = {duraItem0, duraItem1, duraItem2, duraItem3, duraItem4, duraItem5};
	By[] rateByRT = {rateItem0, rateItem1, rateItem2, rateItem3, rateItem4};
	
	public SearchPage(LoanPurpose purpose) {
		loanPurpose = purpose;
	}
	
	public List<Result> testSearchResult() throws UiObjectNotFoundException {
		List<Result> results = new ArrayList<Result>();
		
		int[][] durations;
		int[][] rates;
		By[] durasBy;
		By[] ratesBy;
		
		if (loanPurpose == LoanPurpose.FENG_CX) {
			durations = durationsBB;
			rates = ratesBB;
			durasBy = duraByBB;
			ratesBy = rateByBB;
			selectType(typeBB);
		} else {
			durations = durationsRT;
			rates = ratesRT;
			durasBy = duraByRT;
			ratesBy = rateByRT;
			selectType(typeRT);
		}
		
		for (int i = 0; i < durasBy.length; i++) {
			for (int j = 0; j < ratesBy.length; j++) {
				selectDuration(durasBy[i]);
				selectRate(ratesBy[j]);
				clickSearchButton();
				
				int[] duration = durations[i];
				int[] rate = rates[j];
				
				FilterParam param = generateFilterParam(duration, rate);
				
				LoanList loanList = new LoanList(loanPurpose);
				Result result = loanList.testLoansOrder(param);
				results.add(result);
				
				clickBack();
			}
		}
		
		clickBack();
		return results;
	}
	
	private void selectType(By typeItem) throws UiObjectNotFoundException {
		UiObject.waitFor(type).click();
		UiObject.waitFor(typeItem).click();
		
	}
	
	private void selectDuration(By duraItem) throws UiObjectNotFoundException {
		UiObject.waitFor(duration).click();
		UiObject.waitFor(duraItem).click();
	}
	
	private void selectRate(By rateItem) throws UiObjectNotFoundException {
		UiObject.waitFor(rate).click();
		UiObject.waitFor(rateItem).click();
	}
	
	private void clickSearchButton() throws UiObjectNotFoundException {
		UiObject.waitFor(searchBtn).click();
	}
	
	private void clickBack() throws UiObjectNotFoundException {
		UiObject.waitFor(ISearchPage.BACK).click();
	}
	
	private FilterParam generateFilterParam(int[] duration, int[] rate) {
		FilterParam param = new FilterParam();
		param.purpose = loanPurpose;
		param.lastLoanId = "0";
		param.pageSize = "10000";
		param.status = "SCHEDULED";
		param.minDuration = String.valueOf(duration[0]);
		param.maxDuration = String.valueOf(duration[1]);
		param.minRate = String.valueOf(rate[0]);
		param.maxRate = String.valueOf(rate[1]);
		return param;
	}
}

