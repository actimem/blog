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

package com.actimem.blog.jackson.dependencies;

public class Address {
    private String street;
    private String city;

    private Address() {
    }

    public Address(String street, String city) {
        this.city = city;
        this.street = street;
    }

    public String getCity() { return city; }
    public String getStreet() { return street; }

    @Override
    public String toString() {
        return String.format("Street: %s, City: %s", street, city);
    }
}
