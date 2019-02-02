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

package com.actimem.blog.jackson.basic;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.io.StringWriter;

public class WriteDemoMultiple {
    public static void main(String[] args) throws IOException {
        Company company = createCompany();

        ObjectMapper mapper = new ObjectMapper();

        // Java to JSON String
        String json = mapper.writeValueAsString(company);
        System.out.println(json);

        // Java to JSON String using pretty printer
        String jsonPretty = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(company);
        System.out.println(jsonPretty);

        // Java to JSON String using pretty printer
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        String jsonPretty2 = mapper.writeValueAsString(company);
        System.out.println(jsonPretty2);

        // Java to JSON Writer
        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, company);
        System.out.println(writer);
    }

    private static Company createCompany() {
        Company company = new Company();
        company.setName("Actimem");
        company.setFoundingYear(1999);
        company.setShareValue(3.5);
        company.getDepartments().add("accounts");
        company.getDepartments().add("sales");
        company.getDepartments().add("back office");
        return company;
    }
}
