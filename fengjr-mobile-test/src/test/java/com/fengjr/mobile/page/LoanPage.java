package com.fengjr.mobile.page;

import java.util.List;

import com.fengjr.mobile.base.Page;
import com.fengjr.mobile.base.PageContext;
import com.fengjr.mobile.bean.LoanItem;



/**
 * 理理财页面
 * @author crest
 *
 */
public interface LoanPage extends Page  {

	/**
	 *  点击理理财页面中指定Title的项目
	 * @param context 
	 * @param title
	 * @return
	 */
	boolean clickLoanItem(PageContext context, String title);
	
	/**
	 * 获取理理财当前列表中前10个借款项目
	 * @param context
	 * @return
	 */
	List<? extends LoanItem> getLoanItemTop10(PageContext context);
	
	/**
	 * 获取当前页面中可以投资的项目
	 * @param context
	 * @return
	 */
	List<? extends LoanItem> getLoanItemInvestable(PageContext context);
	
	/**
	 * 点击凤保宝Tab
	 * @param context
	 * @return
	 */
	boolean clickFengbbTab(PageContext context);
	
	/**
	 * 点击凤锐通Tab
	 * @param context
	 * @return
	 */
	boolean clickFengrtTab(PageContext context);

	
}
