package com.fengjr.mobile.page;

import com.fengjr.mobile.base.Page;
import com.fengjr.mobile.base.PageContext;

/**
 * 关于我们
 * @author crest
 *
 */
public interface AboutUsPage extends Page{

	/**
	 * 点击新手指南
	 * @return
	 */
	boolean clickGuide(PageContext context);
	
	/**
	 * 点击安全保障
	 * @return
	 */
	boolean clickSecurity(PageContext context);
}
