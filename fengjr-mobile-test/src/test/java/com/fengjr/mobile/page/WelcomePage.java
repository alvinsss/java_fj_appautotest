package com.fengjr.mobile.page;

import com.fengjr.mobile.base.Page;
import com.fengjr.mobile.base.PageContext;

public interface WelcomePage extends Page {

	/**
	 * 跳过欢迎页面
	 * @param context
	 */
	boolean skipWelcomePage(PageContext context);
}
