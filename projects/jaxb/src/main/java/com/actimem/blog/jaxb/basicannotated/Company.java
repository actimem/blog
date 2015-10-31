/*
 * Copyright 2015 BCN IT Consulting Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

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
