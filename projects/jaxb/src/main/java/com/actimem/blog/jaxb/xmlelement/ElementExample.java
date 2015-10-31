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
 */

package com.actimem.blog.jaxb.xmlelement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ElementExample {
    private String nonAnnotatedElement;

    @XmlElement
    private String nameDefault;

    @XmlElement(name = "nameChanged")
    private String anotherName;

    @XmlElement(required = true)
    private String required;

    @XmlElement(required = false)
    private String notRequired;

    @XmlElement(nillable = true)
    private String nillable;

    @XmlElement(nillable = false)
    private String notNillable;

    public String getAnotherName() {
        return anotherName;
    }

    public void setAnotherName(String anotherName) {
        this.anotherName = anotherName;
    }

    public String getNameDefault() {
        return nameDefault;
    }

    public void setNameDefault(String nameDefault) {
        this.nameDefault = nameDefault;
    }

    public String getNillable() {
        return nillable;
    }

    public void setNillable(String nillable) {
        this.nillable = nillable;
    }

    public String getNonAnnotatedElement() {
        return nonAnnotatedElement;
    }

    public void setNonAnnotatedElement(String nonAnnotatedElement) {
        this.nonAnnotatedElement = nonAnnotatedElement;
    }

    public String getNotNillable() {
        return notNillable;
    }

    public void setNotNillable(String notNillable) {
        this.notNillable = notNillable;
    }

    public String getNotRequired() {
        return notRequired;
    }

    public void setNotRequired(String notRequired) {
        this.notRequired = notRequired;
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }
}
