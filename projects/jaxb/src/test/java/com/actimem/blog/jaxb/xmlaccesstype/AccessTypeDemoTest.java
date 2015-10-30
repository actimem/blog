package com.actimem.blog.jaxb.xmlaccesstype;

import org.junit.Test;

import javax.xml.bind.JAXBException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AccessTypeDemoTest {
    @Test
    public void publicMemberXmlAccessorType() throws JAXBException {
        PublicMember publicMember = new PublicMember();
        publicMember.setFieldProperty("field");
        publicMember.setAttributeProperty("attribute");
        publicMember.publicField = "public field";

        AccessTypeDemo demo = new AccessTypeDemo(true);
        String xml = demo.toXml(publicMember);
        System.out.println(xml);

        PublicMember unmarshalled = demo.fromXml(xml, PublicMember.class);
        assertThat(unmarshalled.getFieldProperty(), equalTo("field"));
        assertThat(unmarshalled.getAttributeProperty(), equalTo("attribute"));
        assertThat(unmarshalled.publicField, equalTo("public field"));
    }

    @Test
    public void fieldXmlAccessorType() throws JAXBException {
        Field instnace = new Field();
        instnace.setFieldProperty("field");
        instnace.setAttributeProperty("attribute");
        instnace.publicField = "public field";

        AccessTypeDemo demo = new AccessTypeDemo(true);
        String xml = demo.toXml(instnace);
        System.out.println(xml);

        Field unmarshalled = demo.fromXml(xml, Field.class);
        assertThat(unmarshalled.getFieldProperty(), equalTo("field"));
        assertThat(unmarshalled.getAttributeProperty(), equalTo("attribute"));
        assertThat(unmarshalled.publicField, equalTo("public field"));
    }

    @Test
    public void propertyXmlAccessorType() throws JAXBException {
        Property instance = new Property();
        instance.setFieldProperty("field");
        instance.setAttributeProperty("attribute");
        instance.publicField = "public field";

        AccessTypeDemo demo = new AccessTypeDemo(true);
        String xml = demo.toXml(instance);
        System.out.println(xml);

        Property unmarshalled = demo.fromXml(xml, Property.class);
        assertThat(unmarshalled.getFieldProperty(), equalTo("field"));
        assertThat(unmarshalled.getAttributeProperty(), equalTo("attribute"));
        assertThat(unmarshalled.publicField, equalTo(null));
    }

    @Test
    public void noneXmlAccessorType() throws JAXBException {
        None instance = new None();
        instance.setFieldProperty("field");
        instance.setAttributeProperty("attribute");
        instance.publicField = "public field";

        AccessTypeDemo demo = new AccessTypeDemo(true);
        String xml = demo.toXml(instance);
        System.out.println(xml);

        None unmarshalled = demo.fromXml(xml, None.class);
        assertThat(unmarshalled.getFieldProperty(), equalTo(null));
        assertThat(unmarshalled.getAttributeProperty(), equalTo("attribute"));
        assertThat(unmarshalled.publicField, equalTo(null));
    }

}