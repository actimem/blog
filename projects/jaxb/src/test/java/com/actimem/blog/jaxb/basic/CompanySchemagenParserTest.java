package com.actimem.blog.jaxb.basic;

import org.junit.Test;

import javax.xml.bind.JAXBException;

import java.util.GregorianCalendar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CompanySchemagenParserTest {

    @Test
    public void canMarshalAndUnmarshal() throws JAXBException {
        Company company = new Company();
        company.setId(101);
        company.setName("Actimem");
        company.setRanking(10);
        company.setProbabilityDefault(0.3);
        company.setSector(Sector.Finance);
        company.setFoundedDate(new GregorianCalendar(2003, 2, 3).getTime());

        CompanyBasicParser companyParser = new CompanyBasicParser(true);
        String xml = companyParser.toXml(company);
        System.out.println(xml);

        Company unmarshalledCompany = companyParser.fromXml(xml);
        assertThat(unmarshalledCompany.getId(), equalTo(101));
        assertThat(unmarshalledCompany.getName(), equalTo("Actimem"));
        assertThat(unmarshalledCompany.getRanking(), equalTo(10));
        assertThat(unmarshalledCompany.getProbabilityDefault(), equalTo(0.3));
        assertThat(unmarshalledCompany.getSector(), equalTo(Sector.Finance));
        assertThat(unmarshalledCompany.getFoundedDate(), equalTo(new GregorianCalendar(2003, 2, 3).getTime()));
    }

}