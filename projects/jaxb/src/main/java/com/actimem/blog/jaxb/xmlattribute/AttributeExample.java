package com.actimem.blog.jaxb.xmlattribute;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AttributeExample {
    @XmlAttribute
    private String defaultAttribute;

    @XmlAttribute(name = "named-attribute")
    private String namedAttribute;

    @XmlAttribute(required = true)
    private String requiredAttribute;

    @XmlAttribute(required = false)
    private String optionalAttribute;

    public String getDefaultAttribute() {
        return defaultAttribute;
    }

    public void setDefaultAttribute(String defaultAttribute) {
        this.defaultAttribute = defaultAttribute;
    }

    public String getNamedAttribute() {
        return namedAttribute;
    }

    public void setNamedAttribute(String namedAttribute) {
        this.namedAttribute = namedAttribute;
    }

    public String getOptionalAttribute() {
        return optionalAttribute;
    }

    public void setOptionalAttribute(String optionalAttribute) {
        this.optionalAttribute = optionalAttribute;
    }

    public String getRequiredAttribute() {
        return requiredAttribute;
    }

    public void setRequiredAttribute(String requiredAttribute) {
        this.requiredAttribute = requiredAttribute;
    }

}
