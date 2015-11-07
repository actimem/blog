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

package com.actimem.blog.gson.immutable;

import com.google.gson.Gson;

import java.io.IOException;

/**
 * Gson provides out-of-the box support for immutable objects.
 * However, it relies in an officially not unsupported API called {@code sun.misc.Unsafe}.
 * <br>
 * Oracle has suggested to
 * <a href="https://adtmag.com/blogs/watersworks/2015/08/java-9-hack.aspx">remove this API in Java 9</a>.
 * Many developers have raised concerns about this as it is heavily used in very popular frameworks
 * such as Spring, Mockito, Grails and Hadoop.
 *
 * <a href="https://dzone.com/articles/understanding-sunmiscunsafe/">This article</a>
 * describes the Unsafe API.
 */

public class ImmutableDemo {
    public static void main(String[] args) throws IOException {
        Company company = new Company("Actimem", 1999, 3.5);

        Gson gson = new Gson();
        String json = gson.toJson(company);
        System.out.println(json);

        Company company2 = gson.fromJson(json, Company.class);
        System.out.println(company2.toString());
    }
}
