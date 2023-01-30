package com.fengjr.model;

import java.io.Serializable;
import java.util.List;


public class FundingProjectExt implements Serializable {

	private static final long serialVersionUID = -367542887355618782L;

	public FundingProject project;
	public String userName;
	public FundingProjectImages images;
	public List<ProjectTag> tags;
	
	public void update(FundingProjectExt otherObj){
		project = otherObj.project;
		userName = otherObj.userName;
		images = otherObj.images;
		tags = otherObj.tags;
		
	}
}
