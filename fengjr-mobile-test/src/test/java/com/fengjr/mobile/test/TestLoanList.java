package com.fengjr.mobile.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fengjr.mobile.base.PageContext;
import com.fengjr.mobile.bean.LoanItem;
import com.fengjr.mobile.rest.RESTLoanList;
import com.fengjr.model.Loan;
import com.fengjr.model.enums.LoanPurpose;

public class TestLoanList extends TestCaseBase{
	
	/**
	 * 测试理理财列表项前10项是否与服务器返回数据一致
	 *
	 */
	@Test
	public void testListOrderFirst10() {
		try {
			PageContext context = new PageContext();
			context.goLoanPage(context);
			
			context.clickFengbbTab(context);
			List<? extends LoanItem> fengbbList = context.getLoanItemTop10(context);
			
			verifyData(fengbbList);

		} catch (RuntimeException e) {
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	/**
	 * 比较客户端列表与服务器返回列表是否一致
	 * @param clientLoanList
	 * @return
	 */
	private void verifyData(List<? extends LoanItem> clientFengbbList) {
		
		RESTLoanList rest = new RESTLoanList(LoanPurpose.FENG_CX);
		List<Loan> remoteFengbbList = rest.request();
		
		for (int i = 0; i < clientFengbbList.size(); i++) {
			String clientItemTitle = clientFengbbList.get(i).getTitle();
			String remoteItemTitle = remoteFengbbList.get(i).getTitle();
			Assert.assertEquals(clientItemTitle, remoteItemTitle,"凤宝宝列表与服务器返回列表顺序不一致; i=" + i);
		}

	}
}
