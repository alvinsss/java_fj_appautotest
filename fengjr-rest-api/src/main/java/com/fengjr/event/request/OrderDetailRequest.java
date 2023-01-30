package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;
import com.fengjr.model.ShippingAddress;

public class OrderDetailRequest extends Request {

	public OrderDetailRequest(Context ctx, String rewardId, String projectId, String shippingAddress, String contact, String email, String realName, boolean needInvoice, String description, double fee) {
		super(ctx, ctx.getString(R.string.api_reward_address));
		
		add("projectId", projectId);
		add("name", realName);
		add("mobile", contact);
		add("email", email);
		add("rewardId", rewardId);
		add("address", shippingAddress);
		add("description", description);
		add("needInvoice", needInvoice);
		add("rewardId", rewardId);
		add("shippingAddressId", "");
		add("fee", fee);
	}
	
	public OrderDetailRequest(Context ctx, String rewardId, String projectId, ShippingAddress address, String description, boolean needInvoice, double fee) {
		super(ctx, ctx.getString(R.string.api_reward_address));
		
		add("projectId", projectId);
		add("name", address.realName);
		add("mobile", address.contact);
		add("email", address.email);
		add("rewardId", rewardId);
		add("address", address.detail);
		add("description", description);
		add("needInvoice", needInvoice);
		add("rewardId", rewardId);
		add("shippingAddressId", address.id);
		add("fee", fee);
	}
	
}

