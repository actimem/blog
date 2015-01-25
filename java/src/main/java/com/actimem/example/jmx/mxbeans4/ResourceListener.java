/*
 * Copyright 2012 The Apache Software Foundation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.actimem.example.jmx.mxbeans4;

import javax.management.Notification;
import javax.management.NotificationFilter;
import javax.management.NotificationFilterSupport;
import javax.management.NotificationListener;

public class ResourceListener implements NotificationListener {

	private final String notificationType;

	public ResourceListener(String notificationType) {
		this.notificationType = notificationType;
	}
	
	public void handleNotification(Notification notification, Object handback) {
		System.out.println(String.format("Listener %s: %s", notificationType, notification.getMessage()));
	}

	public NotificationFilter getNotificationFilter() {
		NotificationFilterSupport filter = new NotificationFilterSupport();
		filter.enableType(notificationType);
		return filter;
	}
}
