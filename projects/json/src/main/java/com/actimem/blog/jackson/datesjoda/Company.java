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

package com.actimem.blog.jackson.datesjoda;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

public class Company {
    private String name;
    private LocalDate founded;
    private DateTime updatedTS;

    public Company() {
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDate getFounded() { return founded; }
    public void setFounded(LocalDate founded) { this.founded = founded; }

    public DateTime getUpdatedTS() { return updatedTS; }
    public void setUpdatedTS(DateTime updatedTS) { this.updatedTS = updatedTS; }

    @Override
    public String toString() {
        return String.format("Name: %s, Founded: %s, UpdatedTS: %s", name, founded, updatedTS);
    }
}
