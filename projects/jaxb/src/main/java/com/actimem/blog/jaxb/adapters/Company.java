package com.actimem.blog.jaxb.adapters;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Company {
    private CompanyId companyId;
    private String name;
    private LocalDate foundedDate;
    private DateTime createdAt;

    public CompanyId getCompanyId() { return companyId; }
    public void setCompanyId(CompanyId companyId) { this.companyId = companyId; }

    public DateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(DateTime createdAt) { this.createdAt = createdAt; }

    public LocalDate getFoundedDate() { return foundedDate; }
    public void setFoundedDate(LocalDate foundedDate) { this.foundedDate = foundedDate; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
