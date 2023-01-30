package com.fengjr.mobile.page;

import com.fengjr.mobile.base.Page;
import com.fengjr.mobile.base.PageContext;

/**
 * 首页
 * @author crest
 *
 */
public interface HomePage extends Page{

	/**
	 * 点击公告标题
	 * @param context
	 * @return
	 */
	boolean clickAnnouncementTitle(PageContext context);
	
	/**
	 * 点击公告更多按钮
	 * @param context
	 * @return
	 */
	boolean clickAnnouncementMore(PageContext context);
	
	/**
	 * 点击首页中二维码图标
	 * @param context
	 * @return
	 */
	boolean clickQrcodeIcon(PageContext context);
	

}
