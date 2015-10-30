package com.actimem.blog.jaxb.xmlattribute;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AttributeListExample {
    @XmlAttribute
    private List<String> listAttributes = new ArrayList<>();

    public List<String> getListAttributes() {
        return listAttributes;
    }

    public void setListAttributes(List<String> listAttributes) {
        this.listAttributes = listAttributes;
    }
}
