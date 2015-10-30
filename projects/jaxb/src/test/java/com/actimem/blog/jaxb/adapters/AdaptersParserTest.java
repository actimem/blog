package com.actimem.blog.jaxb.adapters;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.junit.Test;

import javax.xml.bind.JAXBException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AdaptersParserTest {
    @Test
    public void canMarshalAndUnmarshal() throws JAXBException {
        Company company = new Company();
        company.setCompanyId(new CompanyId("123"));
        company.setName("Actimem");
        company.setFoundedDate(new LocalDate(2003, 2, 3));
        company.setCreatedAt(new DateTime(2003, 2, 3, 15, 20));

        AdaptersParser companyParser = new AdaptersParser(true);
        String xml = companyParser.toXml(company);
        System.out.println(xml);

        Company unmarshalledCompany = companyParser.fromXml(xml);
        assertThat(unmarshalledCompany.getCompanyId(), equalTo(new CompanyId("123")));
        assertThat(unmarshalledCompany.getName(), equalTo("Actimem"));
        assertThat(unmarshalledCompany.getFoundedDate(), equalTo(new LocalDate(2003, 2, 3)));
        assertThat(unmarshalledCompany.getCreatedAt(), equalTo(new DateTime(2003, 2, 3, 15, 20)));
    }

}