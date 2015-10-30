package com.actimem.blog.jaxb.xmlvalue;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class ValueDemo {
    public static void main(String[] args) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(ValueExample.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        ValueExample example = new ValueExample();
        example.setName("name");
        example.setValue("A very large value");

        marshaller.marshal(example, System.out);
    }
}
