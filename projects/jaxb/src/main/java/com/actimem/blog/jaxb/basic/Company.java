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
