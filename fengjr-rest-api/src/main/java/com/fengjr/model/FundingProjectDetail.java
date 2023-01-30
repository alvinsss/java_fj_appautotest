package com.fengjr.model;

import java.io.Serializable;
import java.util.List;

public class FundingProjectDetail implements Serializable {

	private static final long serialVersionUID = -7654909865081866178L;
	
	public List<FundingReward> rewards;
	
	public List<ProjectTag> projTags;
	
	public FundingProjectExt ext;
	
	public Tags tags;
	
	public List<ProjectInvestLog> invests;
}
