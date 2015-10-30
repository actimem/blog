package com.actimem.blog.jaxb.basicannotated;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.util.GregorianCalendar;

public class BasicAnnotatedDemo {
    public static void main(String[] args) throws JAXBException {
        Company company = new Company();
        company.setId(101);
        company.setName("Actimem");
        company.setRanking(10);
        company.setProbabilityDefault(0.3);
        company.setFoundedDate(new GregorianCalendar(2003, 2, 3).getTime());

        JAXBContext context = JAXBContext.newInstance(Company.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(company, System.out);
    }

}
