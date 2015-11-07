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

package com.actimem.blog.gson.dates;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;

public class FormattedDateDemo {
    public static void main(String[] args) throws IOException {
        Company company = new Company();
        company.setName("Actimem");
        company.setFounded(new GregorianCalendar(2015, 5, 20).getTime());
        company.setUpdatedTs(new Date());

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").create();
        String json = gson.toJson(company);
        System.out.println(json);

        Company company2 = gson.fromJson(json, Company.class);
        System.out.println(company2.toString());
    }
}
