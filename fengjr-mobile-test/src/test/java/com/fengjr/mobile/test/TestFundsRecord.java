package com.fengjr.mobile.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fengjr.api.REST;
import com.fengjr.event.request.FundRecordsRequest;
import com.fengjr.event.request.LoginRequest;
import com.fengjr.event.response.FundRecordsResponse;
import com.fengjr.event.response.LoginResponse;
import com.fengjr.mobile.base.PageContext;
import com.fengjr.mobile.bean.FundsRecordItem;
import com.fengjr.mobile.utils.Formater;
import com.fengjr.model.FundRecord;
import com.fengjr.model.FundRecords;
import com.fengjr.model.UserLoginExt;
import com.fengjr.model.enums.FundRecordOperation;
import com.fengjr.model.enums.FundRecordType;

public class TestFundsRecord extends TestCaseBase{

	@Test
	public void testFundsRecord() {
		try {
			PageContext context = new PageContext();
			context.goPersonalCenterPage(context);
			context.clickFundsRecord(context);
			
			List<? extends FundsRecordItem> recordList = context.getFundRecordList();
			
			verifyData(recordList);

		} catch (RuntimeException e) {
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	private void verifyData(List<? extends FundsRecordItem> actualList) {
		
		REST rest = new REST();
		//登录
		LoginRequest loginRequest = new LoginRequest(getContext());
		loginRequest.add("username", getLoginAccount());
		loginRequest.add("password", getLoginPassword());
	
		LoginResponse loginResponse = rest.response(loginRequest);
		UserLoginExt userLoginExt = (UserLoginExt) loginResponse.result.data;
		
		FundRecordsRequest request = new FundRecordsRequest(getContext(), 1, 10000, FundRecordType.ALL);
		request.ext(userLoginExt);
		
		FundRecordsResponse response = rest.response(request);
		FundRecords fundRecords = (FundRecords) response.result.data;
		List<FundRecord> expectedList = fundRecords.results;
		
		for (int i = 0; i < actualList.size(); i++) {
			String actualCurrency = actualList.get(i).getAmmount();
			String actualStatus = actualList.get(i).getStatus();
			String actualType = actualList.get(i).getOrderId();
			
			updateFundExpectedValue(expectedList.get(i));
			
			Assert.assertEquals(actualCurrency.replaceAll("\u00A0", ""), expectedCurrency, "资金流水列表项显示金额与服务器返回不一致; i=" + i);
			Assert.assertEquals(actualStatus.replaceAll("\u00A0", ""), expectedStatus, "资金流水列表项显示状态与服务器返回不一致; i=" + i);
			Assert.assertEquals(actualType.replaceAll("\u00A0", ""), expectedType, "资金流水列表项显示订单号与服务器返回不一致; i=" + i);
		}
	}
	
	/**
	 * 更新当前资金流水列表项的期望数值
	 * @param fund
	 */
	private void updateFundExpectedValue(FundRecord fund) {
		
		FundRecordOperation operation = FundRecordOperation
				.valueOf(fund.operation);
		
		String fundType = "未知";
		try {
			fundType = FundRecordType.valueOf(fund.type).getKey();
		} catch (Exception e) {

		}
		
		expectedType = fund.hint;
		expectedStatus = fundType;

		if (fund.type.equals("TRANSFER")) {
			if (operation == FundRecordOperation.IN) {
				expectedCurrency = "+"+Formater.getCurrency(fund.amount);
				expectedStatus = "转账还款";
			} else if (operation == FundRecordOperation.OUT) {
				expectedCurrency = "-"+Formater.getCurrency(fund.amount);
				expectedStatus = "转账扣款";
				if (fund.type.equals("INVEST")) {
					expectedStatus = fundType + "-投资";
				}
			}
		} else {
			if (operation == FundRecordOperation.IN) {
				expectedCurrency = "+" + Formater.getCurrency(fund.amount);

			} else if (operation == FundRecordOperation.OUT) {
				expectedCurrency = "-" + Formater.getCurrency(fund.amount);
				if (fund.type.equals("INVEST")) {
					expectedStatus = fundType + "-投资";
				}
			} else if (operation == FundRecordOperation.FREEZE) {
				expectedCurrency = Formater.getCurrency(fund.amount);
				if (fund.type.equals("INVEST")) {
					expectedStatus = fundType + "-冻结";
				}
			} else if (operation == FundRecordOperation.RELEASE) {
				expectedCurrency = Formater.getCurrency(fund.amount);
				if (fund.type.equals("INVEST")) {
					expectedStatus = fundType + "-解冻";
				}
			}
		}
	}
	
	private String expectedCurrency;
	private String expectedStatus;
	private String expectedType;
}
