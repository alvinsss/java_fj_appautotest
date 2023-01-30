package com.fengjr.model;

import java.util.ArrayList;
import java.util.List;

/**
 * “个人中心”->“投资纪录“->“已转让”列表返回的已转让信息
 * @author gaoge
 *
 */
public class Claims {
	
	public List<Claim> results = new ArrayList<Claim>();
	
	public int totalSize;
	
}
