package com.actimem.test.jaxb.hello;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.actimem.test.jaxb.hello.jaxb.GreetingType;
import com.actimem.test.jaxb.hello.jaxb.ObjectFactory;

public class HelloParser {
	ObjectFactory of = new ObjectFactory();
	
	public void parseXml(String helloXml) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(GreetingType.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			Object object = unmarshaller.unmarshal(new StringReader(helloXml));
			System.out.println(object);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
