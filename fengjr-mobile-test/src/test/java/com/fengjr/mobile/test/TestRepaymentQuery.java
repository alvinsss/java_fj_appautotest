package com.fengjr.mobile.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fengjr.api.REST;
import com.fengjr.event.request.LoginRequest;
import com.fengjr.event.request.ReturnMoneyQueryRequest;
import com.fengjr.event.response.LoginResponse;
import com.fengjr.event.response.ReturnMoneyQueryRespone;
import com.fengjr.mobile.base.PageContext;
import com.fengjr.mobile.bean.RepaymentQueryItem;
import com.fengjr.mobile.utils.Formater;
import com.fengjr.model.ReturnMoneyDayItem;
import com.fengjr.model.ReturnMoneyDayItemEvent;
import com.fengjr.model.UserLoginExt;

public class TestRepaymentQuery extends TestCaseBase{

	@Test
	public void testRepaymentQuery() {
		try {
			PageContext context = new PageContext();
			context.goPersonalCenterPage(context);
			context.clickRepementQuery(context);
			
			String ammount = context.getRepementMonth();
			List<? extends RepaymentQueryItem> repements = context.getRepementList();
			
			verifyData(ammount, repements);
			

		} catch (RuntimeException e) {
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	/**
	 * 验证未来一个月收款总额和回款列表与服务器返回数据是否一致
	 * @param actualAmmout
	 * @param actualRepementList
	 */
	private void verifyData(String actualAmmout, List<? extends RepaymentQueryItem> actualRepementList) {
		
		REST rest = new REST();
		//登录请求
		LoginRequest loginRequest = new LoginRequest(getContext());
		loginRequest.add("username", getLoginAccount());
		loginRequest.add("password", getLoginPassword());
	
		LoginResponse loginResponse = rest.response(loginRequest);
		UserLoginExt userLoginExt = (UserLoginExt) loginResponse.result.data;
		
		//回款查询请求
		ReturnMoneyQueryRequest repementRequest = new ReturnMoneyQueryRequest(getContext(), userLoginExt.user.id);
		repementRequest.ext(userLoginExt);
		
		ReturnMoneyQueryRespone repementResponse = rest.response(repementRequest);
		List<ReturnMoneyDayItem> repementList = (List<ReturnMoneyDayItem>)repementResponse.result.data;
		
		//过滤出回款事件
		List<ReturnMoneyDayItemEvent> expectedEvents = filter(repementList);
		//计算回款总额
		String expectedAmmount = repementAmmount(expectedEvents);
		
		Assert.assertEquals(actualAmmout.replaceAll("\u00A0", ""), expectedAmmount, "未来一个月收款总额与服务器返回数据不一致");
		
		for (int i = 0; i < actualRepementList.size(); i++) {
			
			String actualTitle = actualRepementList.get(i).getRepementTitle();
			String expectedTitle = expectedEvents.get(i).loanTitle;
			Assert.assertEquals(actualTitle, expectedTitle, "回款列表借项款标题与服务器返回数据不一致： i =" + i);
			
			String actualDate = actualRepementList.get(i).getRepementDate();
			String expectedDate = Formater.simpleDateTimeformatWithoutTime(new Date(expectedEvents.get(i).eventTime));
			Assert.assertEquals(actualDate, expectedDate, "回款列表项日期与服务器返回日期不一致： i=" + i);
			
			String actualMoney = actualRepementList.get(i).getRepementAmmount();
			String expectedMoney = "+" + Formater.getDecimalFormatWithTwoPoint("" + expectedEvents.get(i).amount);
			Assert.assertEquals(actualMoney.replaceAll("\u00A0", ""), expectedMoney, "回款列表项回款金额与服务器返回金额不一致： i=" + i);
		}

	}
	
	/**
	 * 因为API返回的列表中不仅包括回款操作，还包括提现，投资，充值等操作,所以这里要对数据进行过滤
	 * @return
	 */
	private List<ReturnMoneyDayItemEvent> filter(List<ReturnMoneyDayItem> repementList){
		
		ArrayList<ReturnMoneyDayItemEvent> eventList = new ArrayList<ReturnMoneyDayItemEvent>();
		
		for(ReturnMoneyDayItem item : repementList){
			for(ReturnMoneyDayItemEvent eventItem : item.events){
				if(eventItem.eventType.equals("INVEST_REPAY")){
					eventList.add(eventItem);
				}
			}
		}
		
		Collections.sort(eventList);
		return eventList;
	}
	
	/**
	 * 计算未来一个月收款总额
	 * @param eventList
	 * @return
	 */
	private String repementAmmount(List<ReturnMoneyDayItemEvent> eventList) {
		double returnMoneyAmount = 0;
		for (ReturnMoneyDayItemEvent event: eventList) {
			returnMoneyAmount += event.amount;
		}
		return Formater.getDecimalFormatWithTwoPoint("" + returnMoneyAmount);
	}
}
