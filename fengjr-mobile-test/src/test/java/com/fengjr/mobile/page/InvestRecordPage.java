package com.fengjr.mobile.page;

import java.util.List;

import com.fengjr.mobile.base.Page;
import com.fengjr.mobile.base.PageContext;
import com.fengjr.mobile.bean.InvestRecordItem;

/**
 * 投资记录界面
 * @author crest
 *
 */
public interface InvestRecordPage extends Page{
	
	/**
	 * 返回最大数目为num的投资记录列表项
	 * @param num
	 * @return
	 */

	List<? extends InvestRecordItem> getInvestRecordList(int num);
	
	/**
	 * 点击持有Tab页面
	 * @param context
	 * @return
	 */
	boolean clickHold(PageContext context);
	
	/**
	 * 点击已转让Tab页面
	 * @param context
	 * @return
	 */
	boolean clickTransferred(PageContext context);

}
