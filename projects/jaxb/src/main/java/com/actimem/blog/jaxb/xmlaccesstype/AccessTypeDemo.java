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

package com.actimem.blog.jaxb.xmlaccesstype;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class AccessTypeDemo {
    private final JAXBContext ctx;
    private final boolean formattedOutput;

    public AccessTypeDemo(boolean formattedOutput) throws JAXBException {
        this.formattedOutput = formattedOutput;
        ctx = JAXBContext.newInstance(
                PublicMember.class, Field.class,
                Property.class, None.class);
    }

    public String toXml(Object company) throws JAXBException {
        StringWriter writer = new StringWriter();
        Marshaller marshaller = ctx.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, formattedOutput);
        marshaller.marshal(company, writer);
        return writer.toString();
    }

    @SuppressWarnings("unchecked")
    public <T> T fromXml(String xml, Class<T> targetClass) throws JAXBException {
        return (T)ctx.createUnmarshaller().unmarshal(new StringReader(xml));
    }

    public static void main(String[] args) throws JAXBException {
        AccessTypeDemo demo = new AccessTypeDemo(true);

        PublicMember publicMember = new PublicMember();
        publicMember.setFieldProperty("field");
        publicMember.setAttributeProperty("attribute");
        publicMember.publicField = "public field";
        System.out.println(String.format("PUBLIC_MEMBER:\n%s", demo.toXml(publicMember)));

        Field field = new Field();
        field.setFieldProperty("field");
        field.setAttributeProperty("attribute");
        field.publicField = "public field";
        System.out.println(String.format("FIELD:\n%s", demo.toXml(field)));

        Property property = new Property();
        property.setFieldProperty("field");
        property.setAttributeProperty("attribute");
        property.publicField = "public field";
        System.out.println(String.format("PROPERTY:\n%s", demo.toXml(property)));

        None none = new None();
        none.setFieldProperty("field");
        none.setAttributeProperty("attribute");
        none.publicField = "public field";
        System.out.println(String.format("NONE:\n%s", demo.toXml(none)));

    }

}
