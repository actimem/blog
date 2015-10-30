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
