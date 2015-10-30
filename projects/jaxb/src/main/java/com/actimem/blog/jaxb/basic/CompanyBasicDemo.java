package com.actimem.blog.jaxb.basic;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.GregorianCalendar;

public class CompanyBasicDemo {
    public static void main(String[] args) throws JAXBException {
        Company company = new Company();
        company.setId(101);
        company.setName("Actimem");
        company.setRanking(10);
        company.setProbabilityDefault(0.3);
        company.setFoundedDate(new GregorianCalendar(2003, 2, 3).getTime());

        // Create the JAXBContext
        JAXBContext context = JAXBContext.newInstance(Company.class);

        // Create the Marshaller
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // Marshal the Java class into XML
        StringWriter writer = new StringWriter();
        marshaller.marshal(company, writer);
        String xml = writer.toString();
        System.out.println(xml);

        // Unmarshal the XML into Java
        Company unmarshalled = (Company)context.createUnmarshaller().unmarshal(new StringReader(xml));
    }
}
