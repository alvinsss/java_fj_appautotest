package com.fengjr.mobile.page;

import java.util.List;

import com.fengjr.mobile.base.Page;
import com.fengjr.mobile.bean.RepaymentPlanItem;

public interface RepaymentPlan extends Page {

	/**
	 * 返回回款计划列表
	 * @return
	 */
	List<? extends RepaymentPlanItem> getRepaymentPlanList();


}
