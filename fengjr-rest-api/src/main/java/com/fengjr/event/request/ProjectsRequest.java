package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;
import com.fengjr.model.enums.ProjectStatus;

public class ProjectsRequest extends Request {

	public ProjectsRequest(Context ctx, String lastProjectId, int pageSize,
			ProjectStatus status) {
		super(ctx, ctx.getString(R.string.api_projects));

		add("lastProjectId", lastProjectId).add("pageSize",
				String.valueOf(pageSize));

		if (status != null) {

			add("status", status.name());

		}
	}

}
