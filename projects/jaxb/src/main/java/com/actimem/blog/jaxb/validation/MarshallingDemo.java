package com.actimem.blog.jaxb.validation;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.net.URL;

public class MarshallingDemo {

    public static void main(String[] args) throws Exception {
        Company company = new Company();
        company.setName("Actimem");
        company.getCountries().add("UK");
        company.getCountries().add("FR");
        company.getCountries().add("GE");
        company.getCountries().add("XX");

        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        URL schemaURL = MarshallingDemo.class.getResource("/examples/validation/company.xsd");
        Schema schema = schemaFactory.newSchema(schemaURL);

        JAXBContext context = JAXBContext.newInstance(Company.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setSchema(schema);
        marshaller.setEventHandler(companyErrorHandler);
        marshaller.marshal(company, System.out);
    }

    private static ValidationEventHandler companyErrorHandler = new ValidationEventHandler() {
        @Override
        public boolean handleEvent(ValidationEvent event) {
            System.err.println(String.format("ERROR: %s (%d, %d) Severity: %s", event.getMessage(),
                    event.getLocator().getLineNumber(),
                    event.getLocator().getColumnNumber(),
                    event.getSeverity()));
            return false;
        }
    };
}
