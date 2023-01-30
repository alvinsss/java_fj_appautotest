package com.fengjr.event.response;

import com.fengjr.event.Response;
import com.fengjr.model.ApiResult;

public class ViewInvestContractResponse extends Response {
	private String fileId;
	private String fileName;
	
	public String getFileId() {
		return fileId;
	}
	
	public String getFileName(){
		return fileName;
	}


	public ViewInvestContractResponse(ApiResult apiResult,String fileId,String fileName) {
		super(apiResult);
		this.fileId = fileId;
		this.fileName = fileName;
	}
	
	

}
