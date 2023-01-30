package com.fengjr.event.response;

import java.util.ArrayList;
import java.util.List;

import com.fengjr.event.Response;
import com.fengjr.model.ApiResult;
import com.fengjr.model.ProofExt;

public class ProofsResponse extends Response {

	public List<ProofExt> creditImages = new ArrayList<ProofExt>();

	public ProofsResponse(ApiResult apiResult) {
		super(apiResult);
	}
	
}
