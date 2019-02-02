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

package com.actimem.blog.gson.basic;

import com.google.gson.Gson;

import java.io.IOException;

public class WriteDemo {
    public static void main(String[] args) throws IOException {
        Company company = createCompany();

        Gson gson = new Gson();

        // Java to JSON string
        System.out.println(gson.toJson(company));

        // Java to JSON appendable (Writter or OutputStream)
        Appendable appendable = System.out;
        gson.toJson(company, appendable);
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
