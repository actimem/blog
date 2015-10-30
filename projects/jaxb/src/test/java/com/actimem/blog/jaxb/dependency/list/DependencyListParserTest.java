package com.actimem.blog.jaxb.dependency.list;

import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import java.io.StringReader;
import java.io.StringWriter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DependencyListParserTest {
    @Test
    public void canMarshalAndUnmarshalDependencies() throws JAXBException {
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

        DependencyListParser companyParser = new DependencyListParser(true);
        String xml = companyParser.toXml(company);
        System.out.println(xml);

        Company unmarshalledCompany = companyParser.fromXml(xml);
        assertThat(unmarshalledCompany.getEmployees().size(), equalTo(2));
        Employee employee1 = unmarshalledCompany.getEmployees().get(0);
        Employee employee2 = unmarshalledCompany.getEmployees().get(1);
        assertThat(employee1.getName(), equalTo("John"));
        assertThat(employee2.getName(), equalTo("Brad"));
    }

    @Test
    public void xxx() throws JAXBException {
        Company company = new Company();
        JAXBContext ctx = JAXBContext.newInstance(Company.class);

        StringWriter writer = new StringWriter();
        ctx.createMarshaller().marshal(company, writer);
        String xml = writer.toString();

        Company unmarshalledCompany = (Company)ctx.createUnmarshaller().unmarshal(new StringReader(xml));
    }
}