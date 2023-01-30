package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class ViewInvestContractRequest extends Request {
	
	public static final int TYPE_LOAN_TEMPLATE = 0;
	public static final int TYPE_INVEST_CONTRACT = 1;
	
	//文件名fileId和文件后缀.pdf构成整个文件名
	String fileId;
	//文件后缀名，如.pdf,.doc
	String fileExt;
	
	String fileName;
	
	
	public String getFileExt() {
		return fileExt;
	}

	public String getFileId() {
		return fileId;
	}
	
	public String getFileName(){
		return fileName;
	}


	/**
	 * @param ctx
	 * @param fileId
	 * @param fileExt
	 * @param url
	 */
	public ViewInvestContractRequest(Context ctx,String fileId,String fileName,String fileExt){
		super(ctx, ctx.getString(R.string.api_v2_invest_contract, fileId));
		this.fileId = fileId;
		this.fileExt = fileExt;
		this.fileName = fileName;
		
	}

}
