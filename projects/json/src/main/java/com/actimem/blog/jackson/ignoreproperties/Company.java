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

package com.actimem.blog.jackson.ignoreproperties;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Company {
    private String name;
    private int foundingYear;
    private double shareValue;

    @JsonIgnore
    private String unknown;

    @JsonIgnore
    private String anotherUnknown;

    public Company() {
    }

    public int getFoundingYear() {
        return foundingYear;
    }

    public void setFoundingYear(int foundedYear) {
        this.foundingYear = foundedYear;
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

    public String getUnknown() {
        return unknown;
    }

    public void setUnknown(String unknown) {
        this.unknown = unknown;
    }

    public String getAnotherUnknown() {
        return anotherUnknown;
    }

    public void setAnotherUnknown(String anotherUnknown) {
        this.anotherUnknown = anotherUnknown;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Founded: %d, Share: %s", name, foundingYear, shareValue);
    }

}
