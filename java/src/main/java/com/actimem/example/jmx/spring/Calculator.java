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
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(
		objectName = "Examples:type=JMX,name=Calculator",
		description = "A calculator to demonstrate JMX in the SpringFramework")
public class Calculator {
	private String name;
	private int lastCalculation;

	@ManagedAttribute(description = "Calculator name")
	public String getName() {
		return name;
	}

	@ManagedAttribute(description = "Calculator name")
	public void setName(String name) {
		this.name = name;
	}

	@ManagedAttribute(description = "The last calculation")
	public int getLastCalculation() {
		return lastCalculation;
	}

	@ManagedOperation(description = "Calculate two numbers")
	@ManagedOperationParameters({
			@ManagedOperationParameter(name = "x", description = "The first number"),
			@ManagedOperationParameter(name = "y", description = "The second number")
	})
	public void calculate(int x, int y) {
		lastCalculation = x + y;
	}
}
