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

package com.actimem.blog.gson.customtypeadapters;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.joda.time.DateTime;

import java.io.IOException;

public class CompanyIdTypeAdapter extends TypeAdapter<CompanyId> {
    @Override
    public void write(JsonWriter out, CompanyId value) throws IOException {
        out.value(value.getId());
    }

    @Override
    public CompanyId read(JsonReader in) throws IOException {
        return new CompanyId(in.nextString());
    }
}
