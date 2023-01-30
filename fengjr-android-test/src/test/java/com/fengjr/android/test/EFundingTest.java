package com.fengjr.android.test;

import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fengjr.android.exception.UiObjectNotFoundException;
import com.fengjr.android.lexicon.imp.MyFundingList;

public class EFundingTest extends TestCaseBase {

	/**
	 * 进入爱众筹界面
	 * @throws UiObjectNotFoundException 
	 * @throws InterruptedException 
	 */
	@BeforeMethod
	public void beforeMethod() throws UiObjectNotFoundException, InterruptedException {
		getNavigator().setReset(false);
		getNavigator().enterFundingPage();
	}
	
	/**
	 * 5.1 列表页展示，列表页排序
	 */
	@Test
	public void testFunding() {
		MyFundingList fundingList = new MyFundingList();
		Reporter.log(fundingList.toString(), true);
	}
	
	
}
