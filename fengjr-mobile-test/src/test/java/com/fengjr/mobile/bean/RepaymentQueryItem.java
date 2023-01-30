package com.fengjr.mobile.bean;


/**
 * 回款查询列表项
 * @author crest
 *
 */
public interface RepaymentQueryItem{
	
	/**
	 * 返回回款标题
	 * @return
	 */
	public String getRepementTitle();
	
	/**
	 * 返回回款日期
	 * @return
	 */
	public String getRepementDate();

	/**
	 * 返回回款金额
	 * @return
	 */
	public String getRepementAmmount();
	
}