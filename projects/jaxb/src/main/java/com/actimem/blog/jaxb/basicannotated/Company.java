package com.actimem.blog.jaxb.basicannotated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@XmlRootElement(name = "super-company")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="companyType",
        propOrder = {"name", "foundedDate", "probabilityDefault", "ranking"})
public class Company {
    @XmlAttribute(name = "id")
    private int id;

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "rank")
    private int ranking;

    @XmlElement(name = "default-prob")
    private double probabilityDefault;

    @XmlElement(name = "founded")
    private Date foundedDate;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getRanking() { return ranking; }
    public void setRanking(int ranking) { this.ranking = ranking; }

    public double getProbabilityDefault() { return probabilityDefault; }
    public void setProbabilityDefault(double probabilityDefault) { this.probabilityDefault = probabilityDefault; }

    public Date getFoundedDate() { return foundedDate; }
    public void setFoundedDate(Date foundedDate) { this.foundedDate = foundedDate; }
}
