package com.fengjr.event.response;

import com.fengjr.event.Response;
import com.fengjr.model.ApiResult;

public class ViewLoanTemplateResponse extends Response {
	private String fileId;
	
	public String getFileId() {
		return fileId;
	}

	public ViewLoanTemplateResponse(ApiResult apiResult,String fileId) {
		super(apiResult);
		this.fileId = fileId;
	}
	
	

}
