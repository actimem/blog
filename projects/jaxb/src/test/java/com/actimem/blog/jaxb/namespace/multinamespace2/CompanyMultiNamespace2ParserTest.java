package com.actimem.blog.jaxb.namespace.multinamespace2;

import com.actimem.blog.jaxb.namespace.multinamespace2.company.Company;
import com.actimem.blog.jaxb.namespace.multinamespace2.employee.Employee;
import org.junit.Test;

import javax.xml.bind.JAXBException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CompanyMultiNamespace2ParserTest {
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

        company.addEmployee(john);
        company.addEmployee(brad);

        CompanyMultiNamespace2Parser companyParser = new CompanyMultiNamespace2Parser(true);
        String xml = companyParser.toXml(company);
        System.out.println(xml);

        Company unmarshalledCompany = companyParser.fromXml(xml);
        assertThat(unmarshalledCompany.getEmployees().size(), equalTo(2));
        Employee employee1 = unmarshalledCompany.getEmployees().get(0);
        Employee employee2 = unmarshalledCompany.getEmployees().get(1);
        assertThat(employee1.getName(), equalTo("John"));
        assertThat(employee2.getName(), equalTo("Brad"));
    }

}