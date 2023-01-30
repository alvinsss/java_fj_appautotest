package com.fengjr.mobile.page;

import com.fengjr.mobile.base.Page;
import com.fengjr.mobile.base.PageContext;

/**
 * 众筹界面
 * @author crest
 *
 */
public interface CrowdfundingPage extends Page{

	/**
	 * 点击爱众筹中标题为title的项目
	 * @param context
	 * @param title
	 * @return
	 */
	boolean clickCrowdfundingItem(PageContext context, String title);
}
