package com.fengjr.model;

import java.io.Serializable;
import java.util.List;

public class AllProjectsItemWithOrdinal implements Serializable,
		Comparable<AllProjectsItemWithOrdinal> {

	private static final long serialVersionUID = -3363269645380522870L;
	public ProjectItemWithOrdinal project;
	public String userName;
	public FundingProjectImages images;
	public List<ProjectTag> tags;

	public static class ProjectItemWithOrdinal extends FundingProject {

		private static final long serialVersionUID = -2300680864033462053L;
		public int ordinal;

	}

	@Override
	public int compareTo(AllProjectsItemWithOrdinal another) {
		//按发标时间升序
		return (int) (this.project.openTime - another.project.openTime);

	}
}
