package com.fengjr.mobile.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fengjr.api.REST;
import com.fengjr.event.request.LoginRequest;
import com.fengjr.event.request.MyInvestsRequest;
import com.fengjr.event.request.RepaymentPlanRequest;
import com.fengjr.event.response.LoginResponse;
import com.fengjr.event.response.MyInvestsResponse;
import com.fengjr.event.response.RepaymentPlanResponse;
import com.fengjr.mobile.base.PageContext;
import com.fengjr.mobile.bean.InvestRecordItem;
import com.fengjr.mobile.bean.RepaymentPlanItem;
import com.fengjr.mobile.utils.Formater;
import com.fengjr.model.Invest;
import com.fengjr.model.Invests;
import com.fengjr.model.RepaymentPlan;
import com.fengjr.model.UserLoginExt;
import com.fengjr.model.enums.LoanPurpose;

public class TestRepaymentPlan extends TestCaseBase {

	@Test
	public void testRepaymentPlan() {
		try {
			PageContext context = new PageContext();
			context.goPersonalCenterPage(context);
			context.clickInvestRecord(context);
			
			// 获取持有投资回款计划
			context.clickHold(context);
			List<? extends InvestRecordItem> fengrtList = context.getInvestRecordList(1);
			InvestRecordItem recordItem = fengrtList.get(0);
			recordItem.clickRepaymentPlan(context);
			List<? extends RepaymentPlanItem> actualData = context.getRepaymentPlanList();

			verifyData(actualData, expectedData());

		} catch (RuntimeException e) {
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
		}

	}
	
	/**
	 * 验证数据一致性
	 * @param actualItems
	 * @param expectItems
	 */
	private void verifyData(List<? extends RepaymentPlanItem> actualItems,
			List<com.fengjr.model.RepaymentPlanItem> expectItems) {

		for (int i = 0; i < actualItems.size(); i++) {
			String expectedAmount = Formater.getDecimalFormatWithTwoPoint(""
					+ expectItems.get(i).repayment.amount);
			String expectedDate = expectItems.get(i).repayment.dueDate;
			String expectedStatus = "未知";
			if(expectItems.get(i).status.equals("REPAYED")){
				expectedStatus = "已还";
				expectedAmount = "+" + expectedAmount;
			}else if(expectItems.get(i).status.equals("UNDUE")){
				expectedStatus = "待还";
				expectedAmount = expectedAmount + "";
			}else if(expectItems.get(i).status.equals("OVERDUE")){
				expectedStatus = "逾期";
				expectedAmount = expectedAmount + "";
			}else if(expectItems.get(i).status.equals("BREACH")){
				expectedStatus = "违约";
				expectedAmount = expectedAmount + "";
			}
			
			String actualAmount = actualItems.get(i).getAmount();
			Assert.assertEquals(actualAmount.replaceAll("\u00A0", ""), expectedAmount, "回款计划列表项金额与服务器返回不一致; i=" + i);
			
			String actualDate = actualItems.get(i).getDate();
			Assert.assertEquals(actualDate.replaceAll("\u00A0", ""), expectedDate, "回款计划列表项日期与服务器返回不一致; i=" + i);
			
			String actualStatus = actualItems.get(i).getStatus();
			Assert.assertEquals(actualStatus.replaceAll("\u00A0", ""), expectedStatus, "回款计划列表项状态与服务器返回不一致; i=" + i);

		}

	}

	/**
	 * 返回期望数据
	 * @return
	 */
	private List<com.fengjr.model.RepaymentPlanItem> expectedData() {
		REST rest = new REST();

		// 登录
		LoginRequest loginRequest = new LoginRequest(getContext());
		loginRequest.add("username", getLoginAccount());
		loginRequest.add("password", getLoginPassword());

		LoginResponse loginResponse = rest.response(loginRequest);
		UserLoginExt userLoginExt = (UserLoginExt) loginResponse.result.data;

		// 个人投资记录
		MyInvestsRequest investRequest = new MyInvestsRequest(1, 10,
				LoanPurpose.FENG_CX, getContext());
		investRequest.ext(userLoginExt);

		MyInvestsResponse investResponse = rest.response(investRequest);
		Invests plain = ((Invests) investResponse.result.data);
		List<Invest> investList = plain.results;
		Invest target = investList.get(0);
		String loanId = target.loanId;
		String investId = target.id;

		// 查看回款计划
		RepaymentPlanRequest request = new RepaymentPlanRequest(getContext(),
				loanId, investId);
		request.ext(userLoginExt);
		RepaymentPlanResponse response = rest.response(request);
		RepaymentPlan repaymentPlan = (RepaymentPlan) response.result.data;

		List<com.fengjr.model.RepaymentPlanItem> expectItems = repaymentPlan.investRepayments;

		return expectItems;
	}


}
