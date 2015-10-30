package com.actimem.blog.jaxb.xmllist;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlListExampleWrapped {
    private List<String> names = new ArrayList<>();

    public List<String> getNames() {
        return names;
    }
}
