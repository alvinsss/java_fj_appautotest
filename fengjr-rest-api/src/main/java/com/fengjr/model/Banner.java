package com.fengjr.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.net.Uri;
import android.text.TextUtils;

import com.fengjr.model.enums.BaseEnum;

/**
 * @author suetming ( suetming.ma@gmail.com )
 * 
 *         2014-10-15 上午10:07:08
 * 
 */

public class Banner implements Serializable {

	private static final long serialVersionUID = -34929625207018920L;

	public String id;
	public String channelId;
	public String title;
	public String content;
	public String category;
	public String hasImage;
	public String priority;
	public String newsId;
	public String url;
	public String pubDate;
	public String media;
	public String author;
	public String timeRecorded;
	public String previous;
	public String next;
	public String parent;
	public String bgColor;

	// // 当subtype 为publication或mediacoverage 时保持 公告的具体内容
	private Banner mBannerData;

	public Banner getBannerData() {
		return mBannerData;
	}

	public void setBannerData(Banner bannerData) {
		this.mBannerData = bannerData;
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Banner))
			return false;
		if (!TextUtils.isEmpty(id) && !TextUtils.isEmpty(title)) {
			Banner banner = (Banner) obj;
			if (id.equals(banner.id) && title.equals(banner.title)) {
				return true;
			}

		}
		return false;
	}

}
