package com.actimem.test;

import java.util.Iterator;
import java.util.List;

import org.jdom.Content;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import org.jdom.xpath.XPath;


/**
 * Hello world!
 *
 */
public class App 
{
    @SuppressWarnings("rawtypes")
	public static void main( String[] args ) throws Exception
    {
    	SAXBuilder parser = new SAXBuilder();
    	Document doc = parser.build(App.class.getClassLoader().getResourceAsStream("com/actimem/test/test.xml"));
    	Element root = doc.getRootElement();
    	
    	XPath xpath = XPath.newInstance("//a:dependency[2]/a:groupId");
    	xpath.addNamespace("a", "http://maven.apache.org/POM/4.0.0");
    	List paths = xpath.selectNodes(root);
    	for (Iterator iter=paths.iterator(); iter.hasNext(); ) {
    		Content c = (Content)iter.next();
    		print("[" + c.getValue() + "]");
    	}
    	
    	for (Iterator iterator = paths.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			
		}
    	
    	XMLOutputter xmlOutputter = new XMLOutputter();
//    	print(xmlOutputter.outputString(doc.getRootElement()));
    }
    
    public static void print(String s) {
    	System.out.println(s);
    }
    
    
}
