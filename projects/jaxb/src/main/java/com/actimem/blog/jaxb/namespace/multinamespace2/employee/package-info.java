@XmlSchema(
        namespace = "http://actimem.com/xsd/employee-multi.xsd",
        elementFormDefault = XmlNsForm.QUALIFIED,
        xmlns = @XmlNs(prefix = "e", namespaceURI = "http://actimem.com/xsd/employee-multi.xsd")
)
package com.actimem.blog.jaxb.namespace.multinamespace2.employee;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;