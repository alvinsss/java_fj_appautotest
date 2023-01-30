package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;
import com.fengjr.model.ShippingAddress;

public class ShippingAddressRequest extends Request {

	public ShippingAddressRequest(Context ctx, ShippingAddress sa) {
		super(ctx, ctx.getString(R.string.api_v2_shipping_address, String.valueOf(sa.id)) );
		
		add("realName", sa.realName);
		add("contact", sa.contact);
		add("email", sa.email);
		add("detail", sa.detail);
		add("alias", sa.alias);
	}

}
