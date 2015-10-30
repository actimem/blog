package com.actimem.blog.jaxb.dependency.map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Company {
    private String name;
    private Map<String, Employee> employees = new HashMap<>();

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Map<String, Employee> getEmployees() { return employees; }

    public void addEmployee(Employee employee) {
        employees.put(employee.getName(), employee);
    }
}
