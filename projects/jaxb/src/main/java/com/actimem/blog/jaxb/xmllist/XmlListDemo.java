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
