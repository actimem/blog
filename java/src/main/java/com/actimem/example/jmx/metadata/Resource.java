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
package com.actimem.example.jmx.metadata;

import java.util.ArrayList;
import java.util.List;

import com.actimem.example.jmx.mxbean.ResourceItem;

public class Resource implements ResourceMXBean {
	List<String> items = new ArrayList<String>();

	public void addItem(String item) {
		items.add(item);
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
	
	public ResourceItem getItem2() {
		return new ResourceItem("hello", "surname", 70);
	}
}
