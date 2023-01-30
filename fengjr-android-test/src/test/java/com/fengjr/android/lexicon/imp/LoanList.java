package com.fengjr.android.lexicon.imp;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.fengjr.android.exception.UiObjectNotFoundException;
import com.fengjr.android.listener.TraversalListener;
import com.fengjr.android.rest.RESTLoanList;
import com.fengjr.android.uiobj.UiObject;
import com.fengjr.android.uiobj.UiScroller;
import com.fengjr.android.utils.Result;
import com.fengjr.model.FilterParam;
import com.fengjr.model.enums.LoanPurpose;

public class LoanList {

	// 发起众筹
	private By APPLY_FUNDING = By.id("com.fengjr.mobile:id/right");

	private By LIST = By.className("android.widget.ListView");
	private String LIST_ITEM = "//android.widget.ListView/android.widget.FrameLayout";

	private List<LoanItem> loanList = new ArrayList<LoanItem>();
	private LoanPurpose purpose;

	public LoanList(LoanPurpose loanPurpose) {
		purpose = loanPurpose;
		init();
	}

	private void init() {
		UiScroller<LoanItem> uiScroller = new UiScroller<LoanItem>(LIST,
				LIST_ITEM);
		uiScroller.traversal(LoanItem.class, new TraversalListener<LoanItem>() {

			int count = 0;

			@Override
			public void start() {
				count = 0;
			}

			@Override
			public boolean findItem(LoanItem item) {
				count++;
				Logger.getLogger(LoanList.this.getClass()).info(item);
				//if (count <= 5)
				//	item.loadLoanDetails();
				return true;
			}

			@Override
			public void end(List<LoanItem> allItems) {
				loanList = allItems;
			}

		});

	}

	public void clickAppFunding() throws UiObjectNotFoundException {
		UiObject.waitFor(APPLY_FUNDING).click();
	}
	
	public Result testLoansOrder(FilterParam param) {
		RESTLoanList restLoanList = new RESTLoanList(param);
		restLoanList.request();
		return restLoanList.compareLoansOrder(loanList);
	}

	/**
	 * 检查借贷项目顺序是否与服务器返回项目是否一致
	 */
	public Result testLoansOrder() {

		RESTLoanList restLoanList = new RESTLoanList(purpose);
		restLoanList.request();
		return restLoanList.compareLoansOrder(loanList);
	}

	/**
	 * 检查借贷期限日期是否正常展现
	 * 
	 * @param purpose
	 * @return
	 */
	public Result testLoansExpire() {

		RESTLoanList restLoanList = new RESTLoanList(purpose);
		restLoanList.request();
		return restLoanList.compareLoansExpire(loanList);
	}

	/**
	 * 检查借贷金额是否正常展现，是否与后台一致
	 * 
	 * @return
	 */
	public Result testLoansAmmount() {
		RESTLoanList restLoanList = new RESTLoanList(purpose);
		restLoanList.request();
		return restLoanList.compareLoansAmmount(loanList);
	}

	/**
	 * 检查利率是否展现正常，是否与后台数据一致
	 * 
	 * @param purpose
	 * @return
	 */
	public Result testLoansRate() {

		RESTLoanList restLoanList = new RESTLoanList(purpose);
		restLoanList.request();
		return restLoanList.compareLoansRate(loanList);
	}
	
	/**
	 * 检查贷款状态是否展现正常，是否与后台一致
	 * @return
	 */
	public Result testLoansStatus() {
		RESTLoanList restLoanList = new RESTLoanList(purpose);
		restLoanList.request();
		return restLoanList.compareLoansStatus(loanList);
	}

	@Override
	public String toString() {
		return "FundingList [fundingList=" + loanList + "]";
	}

}