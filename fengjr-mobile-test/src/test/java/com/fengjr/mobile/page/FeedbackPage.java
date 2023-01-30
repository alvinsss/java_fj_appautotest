package com.fengjr.mobile.page;

import com.fengjr.mobile.base.Page;
import com.fengjr.mobile.base.PageContext;

/**
 * 反馈界面
 * @author crest
 *
 */
public interface FeedbackPage extends Page{

	/**
	 * 输入意见
	 * @return
	 */
	boolean inputSuggestion(PageContext context, String suggestion);
	
	/**
	 * 输入姓名
	 * @return
	 */
	boolean inputFeedbackName(PageContext context, String name);
	
	/**
	 * 输入联系信息
	 * @return
	 */
	boolean inputContactInfo(PageContext context, String contractInfo);
	
	/**
	 * 点击提交反馈
	 * @return
	 */
	boolean clickSumitFeedback(PageContext context);
}
