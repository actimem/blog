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
package com.actimem.example.jmx.mxbean;

import java.util.SortedMap;
import java.util.TreeMap;

public class Resource implements ResourceMXBean {
	SortedMap<Integer, ResourceItem> items = new TreeMap<>();
	private int nextId = 1;
	
	public void addItem(ResourceItem item) {
		items.put(nextId++, item);
	}

	public ResourceItem getItem(int pos) {
		return items.get(pos);
	}

	public ResourceItem getLastItem() {
		return items.get(nextId);
	}

	public int getSize() {
		return items.size();
	}

	public SortedMap<Integer, ResourceItem> getItems() {
		return items;
	}
}
