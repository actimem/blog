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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

public class ReadDemo {
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();

        // JSON String to Java
        String json = "{ \"name\" : \"Actimem\", \"foundedYear\" : 1999, \"shareValue\" : 3.5, \"departments\" : [ \"accounts\", \"sales\", \"back office\" ] }";
        Company company = gson.fromJson(json, Company.class);
        System.out.println(company);

        // JSON Reader to Java
        File file = new File("src/main/resources/example/company.json");
        FileReader fileReader = new FileReader(file);
        Company companyFromReader = gson.fromJson(fileReader, Company.class);
        System.out.println(companyFromReader);

        // JSON URL to Java
        URL url = ReadDemo.class.getResource("/example/company.json");
        Reader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        Company companyFromUrl = gson.fromJson(reader, Company.class);
        System.out.println(companyFromUrl);
    }

}
