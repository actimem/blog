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

package com.actimem.blog.jackson.databinding.unknownpropertiesannotation;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class UnknownPropertyDemo {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        URL json = UnknownPropertyDemo.class.getResource("/unknown/company.json");
        Company company = mapper.readValue(json, Company.class);
        System.out.println(String.format("Name: %s", company.getName()));
        System.out.println(String.format("Unknown: %s", company.getUnknown()));
    }
}
