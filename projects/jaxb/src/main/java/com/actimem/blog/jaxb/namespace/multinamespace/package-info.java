@XmlSchema(
        namespace = "http://actimem.com/xsd/company-multi.xsd",
        elementFormDefault = XmlNsForm.QUALIFIED,
        xmlns = {
                @XmlNs(prefix = "", namespaceURI = "http://actimem.com/xsd/company-multi.xsd"),
                @XmlNs(prefix = "e", namespaceURI = "http://actimem.com/xsd/employee-multi.xsd"),
                }
)
package com.actimem.blog.jaxb.namespace.multinamespace;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;