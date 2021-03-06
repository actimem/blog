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

package com.actimem.blog.jaxb.dependency.list;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class CompanyListDemo {
    public static void main(String[] args) throws JAXBException {
        Company company = new Company();
        company.setName("Actimem");

        Employee john = new Employee();
        john.setName("John");
        john.setAge(25);

        Employee brad = new Employee();
        brad.setName("Brad");
        brad.setAge(32);

        company.getEmployees().add(john);
        company.getEmployees().add(brad);

        JAXBContext context = JAXBContext.newInstance(Company.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(company, System.out);
    }
}
