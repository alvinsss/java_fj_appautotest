package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

/** 
 * @author suetming ( suetming.ma@gmail.com )
 * 
 * 2014-10-4 下午4:53:19 
 * 
 */
public class RegisterRequest extends Request {

	public RegisterRequest(Context ctx) {
		super(ctx, ctx.getString(R.string.api_register));
	}
	
}
