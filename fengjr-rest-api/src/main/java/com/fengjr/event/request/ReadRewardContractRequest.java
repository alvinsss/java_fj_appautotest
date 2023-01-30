package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class ReadRewardContractRequest extends Request {
	// 文件名fileId和文件后缀.pdf构成整个文件名
	String fileId;
	// 文件后缀名，如.pdf,.doc
	String fileExt;

	public String getFileExt() {
		return fileExt;
	}

	public String getFileId() {
		return fileId;
	}

	public ReadRewardContractRequest(Context ctx, String investid,String fileExt) {
		super(ctx, ctx.getString(R.string.api_reward_contract, investid));
		this.fileId = investid;
		this.fileExt = fileExt;
	}

}
