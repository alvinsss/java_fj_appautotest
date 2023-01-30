package com.fengjr.mobile.base;



/**
 * 导航接口
 * @author crest
 *
 */
public interface Navigator {
	
	boolean goAboutUsPage(PageContext context);
	
	boolean goAddressInfoPage(PageContext context); 
	
	boolean goConfirmInvestPage(PageContext context);
	
	boolean goConfirmSupportPage(PageContext context);
	
	boolean goCrowdfundingDetailPage(PageContext context);
	
	boolean goCrowdfundingProjectDetails(PageContext context);
	
	boolean goFeedbackPage(PageContext context);
	
	boolean goFundsRecord(PageContext context);
	
	boolean goFundTrusteeshipAccountPage(PageContext context);
	
	boolean goLatestNewsPage(PageContext context);
	
	boolean goMediaReportPage(PageContext context);
	
	boolean goPatternLockPage(PageContext context);
	
	boolean goRepaymentPlan(PageContext context);
	
	boolean goWelcomePage(PageContext context);

	// 去登录界面
	boolean goLoginPage(PageContext context);
	
	// 去注册界面
	boolean goRegisterPage(PageContext context);
	
	// 去HOME页面
	boolean goHomPage(PageContext context);
	
	// 去二维码界面
	boolean goQRCodePage(PageContext context);
	
	// 去理理财界面
	boolean goLoanPage(PageContext context);
	
	// 去搜索界面
	boolean goSearchPage(PageContext context);
	
	// 去爱众筹界面
	boolean goCrowdfundingPage(PageContext context);
	
	// 去个人中心界面
	boolean goPersonalCenterPage(PageContext context);
	
	// 去设置界面
	boolean goSettingPage(PageContext context);
	
	// 去投资记录界面
	boolean goInvestRecordPage(PageContext context);
	
	// 去我的众筹界面
	boolean goMyCrowdfundingPage(PageContext context);
	
	// 去资金流水界面
	boolean goFundsRecordPage(PageContext context);
	
	// 去回款查询界面
	boolean goIncomeQueryPage(PageContext context);
	
	boolean goLatestAnnouncementPage(PageContext context);
	
	boolean goBack(PageContext context);

	boolean exitApp(PageContext context);

}
