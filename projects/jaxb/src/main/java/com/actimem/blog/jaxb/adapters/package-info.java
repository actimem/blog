@XmlJavaTypeAdapters({
        @XmlJavaTypeAdapter(type=DateTime.class, value = DateTimeAdapter.class),
        @XmlJavaTypeAdapter(type=LocalDate.class, value = LocalDateAdapter.class),
        @XmlJavaTypeAdapter(type=CompanyId.class, value = CompanyIdAdapter.class)
})
package com.actimem.blog.jaxb.adapters;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;