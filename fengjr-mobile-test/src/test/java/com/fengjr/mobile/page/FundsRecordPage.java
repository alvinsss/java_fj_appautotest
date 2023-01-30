package com.fengjr.mobile.page;

import java.util.List;

import com.fengjr.mobile.base.Page;
import com.fengjr.mobile.bean.FundsRecordItem;


/**
 * 资金流水记录
 * @author crest
 *
 */
public interface FundsRecordPage extends Page{

	List<? extends FundsRecordItem> getFundRecordList();

}
