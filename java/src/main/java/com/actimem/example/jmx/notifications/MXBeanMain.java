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
package com.actimem.example.jmx.notifications;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class MXBeanMain {
	public static void main(String[] args) throws Exception {
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		ObjectName name = new ObjectName("Examples:type=JMX,name=MXBean");
		Resource resource = new Resource();
		resource.addItem("item 1");
		resource.addItem("item 2");
		
		mbs.registerMBean(resource, name);
		
		ResourceListener addItemListener = new ResourceListener("example.resource.addItem");
		ResourceListener addSecretItemListener = new ResourceListener("example.resource.addSecretItem");
		mbs.addNotificationListener(name, addItemListener, addItemListener.getNotificationFilter(), null);
		mbs.addNotificationListener(name, addSecretItemListener, addSecretItemListener.getNotificationFilter(), null);
		
		Thread.sleep(Long.MAX_VALUE);
	}
}
