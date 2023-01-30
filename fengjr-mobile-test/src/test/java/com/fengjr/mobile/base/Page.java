package com.fengjr.mobile.base;

import org.openqa.selenium.By;


/**
 * 表示应用中的一个UI界面
 * @author crest
 */
public interface Page extends Navigator{

	
	By[] getIdentification();
}
