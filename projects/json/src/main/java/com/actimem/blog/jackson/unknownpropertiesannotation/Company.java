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

package com.actimem.blog.jackson.unknownpropertiesannotation;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class Company {
    private String name;
    private Map<String, Object> otherProperties = new HashMap<>();

    public Company() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonAnyGetter
    public Map<String, Object> getUnknown() {
        return otherProperties;
    }

    @JsonAnySetter
    public void setUnknown(String name, Object value) {
        otherProperties.put(name, value);
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Unknown: %s", name, otherProperties);
    }

}
