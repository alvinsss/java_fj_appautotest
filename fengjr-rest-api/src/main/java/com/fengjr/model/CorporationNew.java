package com.fengjr.model;

import java.io.Serializable;

public class CorporationNew implements Serializable{

	private static final long serialVersionUID = 6226250036254182968L;
	public CorporationUserNew user;
	public CorporationInfonew info;
	public CorporationUserNew getUser() {
		return user;
	}
	public void setUser(CorporationUserNew user) {
		this.user = user;
	}
	public CorporationInfonew getInfo() {
		return info;
	}
	public void setInfo(CorporationInfonew info) {
		this.info = info;
	}
	

}
