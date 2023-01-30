package com.fengjr.mobile.page;

import com.fengjr.mobile.base.Page;
import com.fengjr.mobile.base.PageContext;

public interface SearchPage extends Page{

	/**
	 * 选择凤保宝类型
	 */
	boolean selectTypeFengbb(PageContext context);
	
	/**
	 * 选择凤锐通类型
	 */
	boolean selectTypeFengrt(PageContext context);
	
	/**
	 * 选择期限为所有
	 */
	boolean selectDurationAllMonth(PageContext context);
	
	/**
	 * 选择期限为1-3个月
	 */
	boolean selectDuration_1_3Month(PageContext context);
	
	/**
	 * 选择期限未4-6个月
	 */
	boolean selectDuration_4_6Month(PageContext context);
	
	/**
	 * 选择期限为7-12个月
	 */
	boolean selectDuration_7_12Month(PageContext context);
	
	/**
	 * 选择期限为13-24个月
	 */
	boolean selectDuration_13_24Month(PageContext context);
	
	/**
	 * 选择期限未大于25个月
	 */
	boolean selectDurationBigger25Month(PageContext context);
	
	/**
	 * 选择利率为所有
	 */
	boolean selectRateAll(PageContext context);
	
	/**
	 * 选择利率为8%以下
	 */
	boolean selectRateBlow8(PageContext context);
	
	/**
	 * 选择利率未8%-10%
	 */
	boolean selectRate_8_10(PageContext context);
	
	/**
	 * 选择利率未10%-11%
	 */
	boolean selectRate_10_11(PageContext context);
	
	/**
	 * 选择利率为大于11%
	 */
	boolean selectRateBigger11(PageContext context);
	
	/**
	 * 选择利率为9%以下
	 */
	boolean selcetRateBlow9(PageContext context);
	
	/**
	 * 选择利率为9%-11%
	 */
	boolean selectRate_9_11(PageContext context);
	
	/**
	 * 选择利率为11%-13%
	 */
	boolean selectRate_11_13(PageContext context);
	
	/**
	 * 选择利率为13%以上
	 */
	boolean selectRateBigger13(PageContext context);
	
	/**
	 * 点击搜索按钮
	 */
	boolean clickSearch(PageContext context);
}
