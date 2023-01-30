package com.fengjr.model;

import java.io.Serializable;

public class Assessment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2417927653142094365L;
	
	public double score;

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
