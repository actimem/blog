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

package com.actimem.blog.gson.customtypes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.joda.time.DateTime;

import java.io.IOException;

public class CustomTypesDemo {
    public static void main(String[] args) throws IOException {
        Company company = createCompany();
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(DateTime.class, new DateTimeAdapter())
                .registerTypeAdapter(CompanyId.class, new CompanyIdAdapter())
                .create();

        String json = gson.toJson(company);
        System.out.println(json);

        Company fromJson = gson.fromJson(json, Company.class);
        System.out.println(fromJson);
    }

    private static Company createCompany() {
        Company company = new Company();
        company.setName("Actimem");
        company.setCompanyId(new CompanyId("company id"));
        company.setFounded(new DateTime(1999, 5, 1, 0, 0));
        return company;
    }
}
