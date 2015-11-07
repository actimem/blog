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

package com.actimem.blog.gson.unknownproperties;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class UnknownPropertyDemoFail {
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();

        URL url = UnknownPropertyDemoFail.class.getResource("/unknown/company.json");
        InputStreamReader reader = new InputStreamReader(url.openStream(), "UTF-8");
        Company company = gson.fromJson(reader, Company.class);
        System.out.println(company.toString());
    }
}
