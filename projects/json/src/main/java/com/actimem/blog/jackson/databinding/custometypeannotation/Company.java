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

package com.actimem.blog.jackson.databinding.custometypeannotation;

import com.actimem.blog.jackson.databinding.customtypes.CompanyId;
import com.actimem.blog.jackson.databinding.customtypes.CompanyIdDeserializer;
import com.actimem.blog.jackson.databinding.customtypes.CompanyIdSerializer;
import com.actimem.blog.jackson.databinding.customtypes.DateTimeDeserializer;
import com.actimem.blog.jackson.databinding.customtypes.DateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.joda.time.DateTime;

public class Company {
    @JsonSerialize(using = CompanyIdSerializer.class)
    @JsonDeserialize(using = CompanyIdDeserializer.class)
    private CompanyId companyId;
    private String name;

    @JsonSerialize(using = DateTimeSerializer.class)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private DateTime founded;

    public Company() {
    }

    public CompanyId getCompanyId() {
        return companyId;
    }

    public void setCompanyId(CompanyId companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DateTime getFounded() {
        return founded;
    }

    public void setFounded(DateTime founded) {
        this.founded = founded;
    }

    @Override
    public String toString() {
        return String.format("CompanyId: %s, Name: %s, Founded: %s", companyId, name, founded);
    }
}
