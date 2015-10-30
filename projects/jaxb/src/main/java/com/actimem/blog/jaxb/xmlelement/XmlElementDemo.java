package com.actimem.blog.jaxb.xmlelement;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class XmlElementDemo {
    private final JAXBContext ctx;
    private final boolean formattedOutput;

    public XmlElementDemo(boolean formattedOutput) throws JAXBException {
        this.formattedOutput = formattedOutput;
        ctx = JAXBContext.newInstance(ElementExample.class, ElementListExample.class);
    }

    public String toXml(Object company) throws JAXBException {
        StringWriter writer = new StringWriter();
        Marshaller marshaller = ctx.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, formattedOutput);
        marshaller.marshal(company, writer);
        return writer.toString();
    }

    @SuppressWarnings("unchecked")
    public <T> T fromXml(String xml, Class<T> clazz) throws JAXBException {
        return (T)ctx.createUnmarshaller().unmarshal(new StringReader(xml));
    }

    public static void main(String[] args) throws JAXBException {
        ElementExample elementExample = new ElementExample();
        elementExample.setNonAnnotatedElement("non annotated");
        elementExample.setNameDefault("default");
        elementExample.setRequired("required");
        elementExample.setNotRequired("not required");
        elementExample.setNillable("nillable");
        elementExample.setNotNillable("not nillable");

        JAXBContext ctx = JAXBContext.newInstance(ElementExample.class);
        Marshaller marshaller = ctx.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(elementExample, System.out);

        ElementExample nillableExample = new ElementExample();
        nillableExample.setRequired("required");
        marshaller.marshal(nillableExample, System.out);
    }

}
