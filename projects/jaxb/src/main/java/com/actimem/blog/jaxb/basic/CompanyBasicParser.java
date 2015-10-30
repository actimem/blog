package com.actimem.blog.jaxb.basic;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class CompanyBasicParser {
    private final JAXBContext ctx;
    private final boolean formattedOutput;

    public CompanyBasicParser(boolean formattedOutput) throws JAXBException {
        this.formattedOutput = formattedOutput;
        ctx = JAXBContext.newInstance(Company.class);
    }

    public String toXml(Company company) throws JAXBException {
        StringWriter writer = new StringWriter();
        Marshaller marshaller = ctx.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, formattedOutput);
        marshaller.marshal(company, writer);
        return writer.toString();
    }

    public Company fromXml(String xml) throws JAXBException {
        return (Company)ctx.createUnmarshaller().unmarshal(new StringReader(xml));
    }

}
