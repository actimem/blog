package com.actimem.blog.jaxb.xmlaccesstype;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Field {
    private String field;

    @XmlAttribute
    private String attribute;

    public String publicField;

    public String getFieldProperty() {
        return field;
    }
    public void setFieldProperty(String value) {
        this.field = value;
    }

    @XmlAttribute
    public String getAttributeProperty() {
        return attribute;
    }
    public void setAttributeProperty(String value) {
        this.attribute = value;
    }

}
