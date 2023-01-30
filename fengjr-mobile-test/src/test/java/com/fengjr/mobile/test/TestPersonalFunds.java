package com.fengjr.mobile.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fengjr.api.REST;
import com.fengjr.event.request.FundRequest;
import com.fengjr.event.request.LoginRequest;
import com.fengjr.event.request.StatisticsRequest;
import com.fengjr.event.response.FundResponse;
import com.fengjr.event.response.LoginResponse;
import com.fengjr.event.response.StatisticsResponse;
import com.fengjr.mobile.base.PageContext;
import com.fengjr.mobile.utils.Formater;
import com.fengjr.model.UserFund;
import com.fengjr.model.UserLoginExt;
import com.fengjr.model.UserStatistics;

public class TestPersonalFunds extends TestCaseBase {
	
	//累计收益
	private String incomeTotal;
	//帐号总余额
	private String moneyTotal;
	//可用余额
	private String blanceAvaliable;
	//待收本息
	private String principalIntrestDuein; 
	//冻结金额
	private String moneyFrozen;
	
	/**
	 * 测试个人中心资金数据是否与服务器返回数据一致
	 */
	@Test
	public void testPersonalFunds() {
		try {
			PageContext context = new PageContext();
			context.goPersonalCenterPage(context);
			
			incomeTotal = context.getIncomeTotal(context);
			moneyTotal = context.getMoneyTotal(context);
			blanceAvaliable = context.getBlanceAvaliable(context);
			principalIntrestDuein = context.getPrincipalAndIntrestDuein(context);
			moneyFrozen = context.getMoneyFrozen(context);
			
			verifyData();
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	private void verifyData() {
		
		REST rest = new REST();
		//登录
		LoginRequest loginRequest = new LoginRequest(getContext());
		loginRequest.add("username", getLoginAccount());
		loginRequest.add("password", getLoginPassword());
	
		LoginResponse loginResponse = rest.response(loginRequest);
		UserLoginExt userLoginExt = (UserLoginExt) loginResponse.result.data;
		
		StatisticsRequest statRequest = new StatisticsRequest(getContext());
		statRequest.ext(userLoginExt);
		
		StatisticsResponse statResponse = rest.response(statRequest);
		UserStatistics statistics = (UserStatistics) statResponse.result.data;
		
		FundRequest fundRequest = new FundRequest(getContext());
		fundRequest.ext(userLoginExt);
		
		FundResponse fundResponse = rest.response(fundRequest);
		UserFund userFund = (UserFund) fundResponse.result.data;
		
		//累计收益
		String income = Formater.getCurrency(statistics.invest.investInterestAmount);
		for (char curr : incomeTotal.toCharArray()){
			   //print out the character or do whatever you wanna have
			   int code = curr;
			   System.out.println(String.format("%x",code));
			}
		Assert.assertEquals(incomeTotal.replaceAll("\u00A0", ""), income.trim(), "客户端累计收益与后台返回不一致");
		
		//待收本息
		String dueInAmmount = Formater.getCurrency(userFund.dueInAmount);
		Assert.assertEquals(principalIntrestDuein.replaceAll("\u00A0", ""), dueInAmmount.trim(), "客户端待收本息与后台返回不一致");
		
		//可用余额
		String availableAmount = Formater.getCurrency(userFund.availableAmount);
		Assert.assertEquals(blanceAvaliable.replaceAll("\u00A0", ""), availableAmount.trim(), "客户端可用余额与后台返回不一致");
		
		//冻结金额
		String frozenAmmount = Formater.getCurrency(userFund.frozenAmount);
		Assert.assertEquals(moneyFrozen.replaceAll("\u00A0", ""), frozenAmmount.trim(), "客户端冻结金额与后台返回不一致");
		
		//帐户总余额
		String totalAmmount = Formater.getCurrency(userFund.availableAmount
				+ userFund.frozenAmount + userFund.dueInAmount);
		Assert.assertEquals(moneyTotal.replaceAll("\u00A0", ""), totalAmmount.trim(), "客户端帐号总余额与后台返回不一致");
		
	}
	
}
