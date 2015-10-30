package com.actimem.blog.jaxb.namespace.multinamespace2.employee;

import javax.xml.bind.annotation.XmlType;

@XmlType(namespace = "http://actimem.com/xsd/employee-multi.xsd")
public class Employee {
    private String name;
    private int age;

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
