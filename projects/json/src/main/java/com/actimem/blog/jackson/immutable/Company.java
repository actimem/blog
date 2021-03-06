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

package com.actimem.blog.jackson.immutable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Company {
    private String name;
    private int foundedYear;
    private double shareValue;

    @JsonCreator
    public Company(@JsonProperty("name") String name,
                   @JsonProperty("foundedYear") int foundedYear,
                   @JsonProperty("shareValue") double shareValue) {
        this.name = name;
        this.foundedYear = foundedYear;
        this.shareValue = shareValue;
    }

    public int getFoundedYear() { return foundedYear; }
    public String getName() { return name; }
    public double getShareValue() { return shareValue; }

    @Override
    public String toString() {
        return String.format("Name: %s, Founded: %d, Share: %s", name, foundedYear, shareValue);
    }
}
