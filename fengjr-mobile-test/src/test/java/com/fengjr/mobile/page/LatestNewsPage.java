package com.fengjr.mobile.page;

import com.fengjr.mobile.base.Page;
import com.fengjr.mobile.base.PageContext;

/**
 * 最新动态界面
 * @author crest
 *
 */
public interface LatestNewsPage extends Page {
	
	/**
	 * 点击最新公告TAB
	 */
	boolean clickLatestAnnouncementTab(PageContext context);
	
	/**
	 * 点击媒体报道TAB
	 * @return
	 */
	boolean clickLatestMediaReportTab(PageContext context);
	


}
