package XMLSendThroughSocket;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class Doc2Object {
	public static Document convertXmlString2Document(String xmlStr) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new InputSource(new StringReader(xmlStr)));
			return doc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static Student convertDoc2User(Document doc) {
//		Document doc = convertXmlString2Document(xmlStr);

		int id = Integer.parseInt(doc.getElementsByTagName("id").item(0).getTextContent());
		String name = doc.getElementsByTagName("name").item(0).getTextContent();
		int grade = Integer.parseInt(doc.getElementsByTagName("grade").item(0).getTextContent());

		Student user = new Student(id, name, grade);
		return user;
		
	}

//	public static void main(String[] args) {
//		final String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>"
//				+ "<users><user><id>123</id><name>John</name><age>30</age></user></users>";
//		Document doc = convertXmlString2Document(xmlStr);
//
//		int id = Integer.parseInt(doc.getElementsByTagName("id").item(0).getTextContent());
//		String name = doc.getElementsByTagName("name").item(0).getTextContent();
//		int age = Integer.parseInt(doc.getElementsByTagName("age").item(0).getTextContent());
//
//		User user = new User(id, name, age);
//		System.out.println(user);
//	}
}
