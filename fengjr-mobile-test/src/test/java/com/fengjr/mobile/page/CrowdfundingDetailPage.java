package com.fengjr.mobile.page;

import org.openqa.selenium.By;

import com.fengjr.mobile.base.Page;
import com.fengjr.mobile.base.PageContext;

/**
 * 众筹详情界面
 * @author crest
 *
 */
public interface CrowdfundingDetailPage extends Page{
	
	public By FAVORITE = By.id("com.fengjr.mobile:id/favorite");
	public By ZAN = By.id("com.fengjr.mobile:id/like");
	public By PROJECT_DETAILS = By.id("com.fengjr.mobile:id/btn_project_desc");

	/**
	 * 点击喜欢按钮
	 */
	boolean clickLike(PageContext context);
	
	/**
	 * 点击赞按钮
	 */
	boolean clickZan(PageContext context);
	
	/**
	 * 点击“查看项目详情”按钮
	 */
	boolean clickProjectDetail(PageContext context);
	
	/**
	 * 点击“我要支持”按钮，第一个按钮的index为0
	 * @param context
	 * @return
	 */
	boolean clickIwannaSupport(PageContext context, int index);

}
