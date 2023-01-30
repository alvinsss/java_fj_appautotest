package com.fengjr.model;

import java.io.Serializable;
import java.util.List;

public class WebNotifications implements Serializable {
	private static final long serialVersionUID = 7916373595709748942L;
	public List<NotificationModel> results;
	public int totalSize;
	
	public class NotificationModel{
		public String id;
		public String realm;
		public String type;
		public String status;
		public String senderId;
		public String senderName;
		public String receiverId;
		public String receiverName;
		public String title;
		public String content;
		public String sentTime;		
	}

	
}
