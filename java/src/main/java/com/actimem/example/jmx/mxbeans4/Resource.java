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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

public class Resource extends NotificationBroadcasterSupport implements ResourceMXBean {
	List<String> items = new ArrayList<String>();

	public void addItem(String item) {
		items.add(item);
		notifyItemAdded(item);
	}

	public String getItem(int pos) {
		return items.get(pos);
	}

	public String getLastItem() {
		return items.get(getSize()-1);
	}

	public int getSize() {
		return items.size();
	}

	public List<String> getItems() {
		return items;
	}
	
	private static int notificationNum = 0;
	private static String secretItem = "Secret";
	private void notifyItemAdded(String item) {
		notificationNum++;
		String notificationType = !item.equals(secretItem) ? "example.resource.addItem" : "example.resource.addSecretItem";
		Notification notification = new Notification(
				notificationType, 
				"Resource", 
				notificationNum, 
				new Date().getTime(), 
				"Added item: " + item);
		sendNotification(notification);
	}
}
