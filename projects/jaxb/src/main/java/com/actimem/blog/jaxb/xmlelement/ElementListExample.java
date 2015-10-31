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
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ElementListExample {
    private List<String> nonAnnotatedList;

    @XmlElement
    private List<String> defaultRequiredList;

    @XmlElement(required = true)
    private List<String> requiredList;

    @XmlElement(required = false)
    private List<String> notRequiredList;

    public List<String> getDefaultRequiredList() {
        return defaultRequiredList;
    }

    public void setDefaultRequiredList(List<String> defaultRequiredList) {
        this.defaultRequiredList = defaultRequiredList;
    }

    public List<String> getNonAnnotatedList() {
        return nonAnnotatedList;
    }

    public void setNonAnnotatedList(List<String> nonAnnotatedList) {
        this.nonAnnotatedList = nonAnnotatedList;
    }

    public List<String> getNotRequiredList() {
        return notRequiredList;
    }

    public void setNotRequiredList(List<String> notRequiredList) {
        this.notRequiredList = notRequiredList;
    }

    public List<String> getRequiredList() {
        return requiredList;
    }

    public void setRequiredList(List<String> requiredList) {
        this.requiredList = requiredList;
    }
}
