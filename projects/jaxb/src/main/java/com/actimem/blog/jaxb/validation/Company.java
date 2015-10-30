package com.actimem.blog.jaxb.validation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Company {
    private String name;
    @XmlElementWrapper
    private List<String> countries = new ArrayList<>();

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<String> getCountries() { return countries; }
}
