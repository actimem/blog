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

import java.util.List;

import com.actimem.example.jmx.mxbean.ResourceItem;

@Description("A test resource")
public interface ResourceMXBean {
	@Description("The last item")
	public String getLastItem();
	
	@Description("Number of items")
	public int getSize();

	@Description("Add a new item to the queue")
	public void addItem(@Description("The item to add") @Name("Item") String item);

	@Description("Returns the item on the provided position")
	public String getItem(@Name("Position") int pos);

	@Description("Returns all the items in this resource")
	public List<String> getItems();
	
	@Description("Returns all the items in this resource")
	public ResourceItem getItem2();
}
