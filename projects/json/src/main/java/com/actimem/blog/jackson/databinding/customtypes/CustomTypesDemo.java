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

package com.actimem.blog.jackson.databinding.customtypes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.joda.time.DateTime;

import java.io.IOException;

public class CustomTypesDemo {
    public static void main(String[] args) throws IOException {
        Company company = new Company();
        company.setCompanyId(new CompanyId("id"));
        company.setName("Actimem");
        company.setFounded(new DateTime());

        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule("Module");
        module.addSerializer(CompanyId.class, new CompanyIdSerializer());
        module.addDeserializer(CompanyId.class, new CompanyIdDeserializer());
        module.addSerializer(DateTime.class, new DateTimeSerializer());
        module.addDeserializer(DateTime.class, new DateTimeDeserializer());
        mapper.registerModule(module);

        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        String json = mapper.writeValueAsString(company);
        System.out.println(json);

        Company company2 = mapper.readValue(json, Company.class);
        System.out.println(company2.toString());
    }
}
