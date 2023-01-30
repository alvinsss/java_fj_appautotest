package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class ViewLoanTemplateRequest extends Request {
	
	public static final int TYPE_LOAN_TEMPLATE = 0;
	public static final int TYPE_INVEST_CONTRACT = 1;
	
	//文件名fileId和文件后缀.pdf构成整个文件名
	String fileId;
	//文件后缀名，如.pdf,.doc
	String fileExt;
	
	
	public String getFileExt() {
		return fileExt;
	}

	public String getFileId() {
		return fileId;
	}


	/**
	 * @param ctx
	 * @param fileId
	 * @param fileExt
	 * @param url
	 */
	public ViewLoanTemplateRequest(Context ctx,String fileId,String fileExt){
		super(ctx, ctx.getString(R.string.api_v2_loan_template, fileId));
		this.fileId = fileId;
		this.fileExt = fileExt;
		
	}

}
