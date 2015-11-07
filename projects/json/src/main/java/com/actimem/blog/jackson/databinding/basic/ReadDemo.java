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

package com.actimem.blog.jackson.databinding.basic;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class ReadDemo {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        // JSON String to Java
        String json = "{ \"name\" : \"Actimem\", \"foundedYear\" : 1999, \"shareValue\" : 3.5, \"departments\" : [ \"accounts\", \"sales\", \"back office\" ] }";
        Company companyFromString = mapper.readValue(json, Company.class);
        System.out.println(companyFromString);

        // JSON URL to Java
        URL url = ReadDemo.class.getResource("/example/company.json");
        Company companyFromUrl = mapper.readValue(url, Company.class);
        System.out.println(companyFromUrl);

        // JSON File to Java
        File file = new File("src/main/resources/example/company.json");
        Company companyFromFile = mapper.readValue(file, Company.class);
        System.out.println(companyFromFile);

        // JSON Reader to Java
        FileReader fileReader = new FileReader(file);
        Company companyFromReader = mapper.readValue(fileReader, Company.class);
        System.out.println(companyFromReader);
    }

}
