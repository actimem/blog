/*
 * Copyright 2015 BCN IT Consulting Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.actimem.example.jmx.spring;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

import java.util.ArrayList;
import java.util.List;

@ManagedResource(objectName = "Examples:type=JMX,name=Resource")
public class Resource {
    List<String> items = new ArrayList<>();

	@ManagedAttribute
   	public String getLastItem() {
   		return items.get(getSize()-1);
   	}

	@ManagedAttribute
   	public int getSize() {
   		return items.size();
   	}

	@ManagedOperation
   	public void addItem(String item) {
   		items.add(item);
   	}

	@ManagedOperation
   	public String getItem(int pos) {
   		return items.get(pos);
   	}

	@ManagedOperation
   	public List<String> getItems() {
   		return items;
   	}
}
