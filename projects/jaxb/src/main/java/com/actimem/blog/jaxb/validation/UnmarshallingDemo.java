package com.actimem.blog.jaxb.validation;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.net.URL;

public class UnmarshallingDemo {

    public static void main(String[] args) throws Exception {
        URL schemaURL = UnmarshallingDemo.class.getResource("/examples/validation/company.xsd");
        URL xmlUrl = UnmarshallingDemo.class.getResource("/examples/validation/company.xml");

        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(schemaURL);

        JAXBContext context = JAXBContext.newInstance(Company.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        unmarshaller.setSchema(schema);
        unmarshaller.setEventHandler(companyErrorHandler);
        unmarshaller.unmarshal(xmlUrl);
    }

    private static ValidationEventHandler companyErrorHandler = new ValidationEventHandler() {
        @Override
        public boolean handleEvent(ValidationEvent event) {
            System.err.println(String.format("ERROR: %s (%d, %d) Severity: %s", event.getMessage(),
                    event.getLocator().getLineNumber(),
                    event.getLocator().getColumnNumber(),
                    event.getSeverity()));
            return true;
        }
    };
}
