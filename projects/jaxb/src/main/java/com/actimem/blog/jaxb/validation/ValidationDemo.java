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

package com.actimem.blog.jaxb.validation;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.util.JAXBSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.net.URL;

public class ValidationDemo {
    public static void main(String[] args) throws Exception {
        Company company = new Company();
        company.setName("Actimem");
        company.getCountries().add("UK");
        company.getCountries().add("FR");
        company.getCountries().add("GE");
        company.getCountries().add("XX");

        JAXBContext context = JAXBContext.newInstance(Company.class);
        JAXBSource source = new JAXBSource(context, company);

        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        URL schemaURL = ValidationDemo.class.getResource("/examples/validation/company.xsd");
        Schema schema = schemaFactory.newSchema(schemaURL);

        Validator validator = schema.newValidator();
        validator.setErrorHandler(companyErrorHandler);
        validator.validate(source);
    }

    public static final ErrorHandler companyErrorHandler = new ErrorHandler() {
        @Override
        public void warning(SAXParseException exception) throws SAXException {
        }

        @Override
        public void error(SAXParseException exception) throws SAXException {
            System.err.println(String.format("ERROR: %s", exception));
        }

        @Override
        public void fatalError(SAXParseException exception) throws SAXException {
        }
    };
}
