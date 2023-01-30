package com.fengjr.mobile.page;

import java.util.List;

import com.fengjr.mobile.base.Page;
import com.fengjr.mobile.bean.RepaymentQueryItem;

public interface RepementQueryPage extends Page{

	/**
	 * 返回未来一个月的收款总额
	 * @return
	 */
	String getRepementMonth();

	/**
	 * 返回回款列表
	 * @return
	 */
	List<? extends RepaymentQueryItem> getRepementList();

}
