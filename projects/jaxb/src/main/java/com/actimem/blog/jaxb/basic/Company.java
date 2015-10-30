package com.actimem.blog.jaxb.basic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Company {
    @XmlAttribute
    private int id;
    private String name;
    private int ranking;
    private double probabilityDefault;
    private Sector sector;
    private Date foundedDate;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getRanking() { return ranking; }
    public void setRanking(int ranking) { this.ranking = ranking; }

    public double getProbabilityDefault() { return probabilityDefault; }
    public void setProbabilityDefault(double probabilityDefault) { this.probabilityDefault = probabilityDefault; }

    public Sector getSector() { return sector; }
    public void setSector(Sector sector) { this.sector = sector; }

    public Date getFoundedDate() { return foundedDate; }
    public void setFoundedDate(Date foundedDate) { this.foundedDate = foundedDate; }
}
