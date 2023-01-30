package com.fengjr.event.response;

import com.fengjr.event.Response;
import com.fengjr.model.ApiResult;

public class ReadRewardContractResponse extends Response {
	private String fileId;

	public String getFileId() {
		return fileId;
	}

	public ReadRewardContractResponse(ApiResult result, String fileid) {
		super(result);
		this.fileId = fileid;
	}

}
