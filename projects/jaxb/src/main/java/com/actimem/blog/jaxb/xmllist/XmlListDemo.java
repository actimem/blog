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

package com.actimem.blog.jaxb.xmllist;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class XmlListDemo {
    public static void main(String[] args) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(XmlListExample.class, XmlListExampleWrapped.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        XmlListExample example = new XmlListExample();
        example.getNames().add("First");
        example.getNames().add("Second");
        example.getNames().add("Third");
        marshaller.marshal(example, System.out);

        XmlListExampleWrapped example2 = new XmlListExampleWrapped();
        example2.getNames().add("First");
        example2.getNames().add("Second");
        example2.getNames().add("Third");
        marshaller.marshal(example2, System.out);
    }
}
