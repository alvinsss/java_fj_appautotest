package com.fengjr.android.rest;

import android.content.Context;

public abstract class RestBase {

	public Context getContext() {
		return new Context();
	}
	
	public abstract void request();
}
