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

package com.actimem.blog.jackson.annotations;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Company {
    @JsonProperty("company-name")
    private String name;

    @JsonProperty("established")
    private int foundedYear;

    @JsonProperty("price")
    private double shareValue;

    public Company() {
    }

    public int getFoundedYear() {
        return foundedYear;
    }

    public void setFoundedYear(int foundedYear) {
        this.foundedYear = foundedYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getShareValue() {
        return shareValue;
    }

    public void setShareValue(double shareValue) {
        this.shareValue = shareValue;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Founded: %d, Share: %s", name, foundedYear, shareValue);
    }
}
