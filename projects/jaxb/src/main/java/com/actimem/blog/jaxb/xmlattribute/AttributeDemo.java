package com.actimem.blog.jaxb.xmlattribute;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class AttributeDemo {
    public static void main(String[] args) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(AttributeExample.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        AttributeListExample example = new AttributeListExample();
        example.getListAttributes().add("First");
        example.getListAttributes().add("Second");
        example.getListAttributes().add("Third");

        marshaller.marshal(example, System.out);
    }
}
