package com.fengjr.mobile.page;

import com.fengjr.mobile.base.Page;
import com.fengjr.mobile.base.PageContext;

public interface PatternLockPage extends Page{

	/**
	 * 绘制手势密码
	 * @param context
	 * @param pattern 
	 * @return
	 */
	boolean drawPatternLock(PageContext context, int[] pattern);


}
