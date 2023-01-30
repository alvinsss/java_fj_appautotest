package com.fengjr.mobile.rest;

import java.util.List;

import android.content.Context;

public abstract class RestBase {

	public Context getContext() {
		return new Context();
	}
	
	public abstract List request();
}
