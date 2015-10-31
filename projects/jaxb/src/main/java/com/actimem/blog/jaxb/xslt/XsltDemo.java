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
 *
 */

package com.actimem.blog.jaxb.xslt;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.InputStream;

public class XsltDemo {
    public static void main(String[] args) throws JAXBException, TransformerException, IOException {
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

        TransformerFactory factory = TransformerFactory.newInstance();
        InputStream resourceAsStream = XsltDemo.class.getResourceAsStream("/examples/xslt/company.xsl");
        StreamSource xslt = new StreamSource(resourceAsStream);
        Transformer transformer = factory.newTransformer(xslt);

        JAXBContext context = JAXBContext.newInstance(Company.class);
        JAXBSource source = new JAXBSource(context, company);
        StreamResult result = new StreamResult(System.out);
        transformer.transform(source, result);
    }
}
