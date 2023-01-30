package com.fengjr.mobile.page;

import com.fengjr.mobile.base.Page;
import com.fengjr.mobile.base.PageContext;

/**
 * 凤锐通详情页
 * @author crest
 *
 */
public interface LoanDetailsPage extends Page{
	
	/**
	 * 点击凤锐通投资按钮
	 * @return
	 */
	boolean clickInvest(PageContext context);
	
	/**
	 * 点击凤锐通参与详情
	 * @return
	 */
	boolean clickInvestDetail(PageContext context);
	
	/**
	 * 点击凤锐通“借款担保协议”
	 */
	boolean clickCollateralAgreement(PageContext context);

}
