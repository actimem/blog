package com.actimem.blog.jaxb.namespace.multinamespace2.company;

import com.actimem.blog.jaxb.namespace.multinamespace2.employee.Employee;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Company {
    @XmlAttribute
    private int id;
    private String name;

    private int ranking;
    private List<Employee> employees = new ArrayList<>();

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getRanking() { return ranking; }
    public void setRanking(int ranking) { this.ranking = ranking; }

    public List<Employee> getEmployees() { return employees; }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

}
