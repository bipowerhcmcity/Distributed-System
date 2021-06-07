package XMLSendThroughSocket;



import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import SendXMLThroughRMI.Person;

public class Client {
	private static ArrayList<Student> getStudentsfromXML(File XMLFile){
		ArrayList<Student> students = new ArrayList<Student>();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			
			db = dbf.newDocumentBuilder();
			Document doc = db.parse(XMLFile);
			
			NodeList peoplesNodeList = doc.getChildNodes();
			Element peoples = (Element) peoplesNodeList.item(0);
			
			NodeList peopleNode = peoples.getChildNodes();
			
			for (int j=0;j<peopleNode.getLength();j++) {
				Node personNode = peopleNode.item(j);
				if(personNode.getNodeType()==Node.ELEMENT_NODE) {
					Student person = createPersonFromNode(personNode);
					students.add(person);
				}
			}
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
		
	}
	private static Student createPersonFromNode(Node personNode) {
		StudentFactory factory = new StudentFactory();

		String nodeName = personNode.getNodeName();
		Element personElement = (Element) personNode;
		Student person = factory.getStudent(nodeName, personElement);
		System.out.println("children: "+ personNode.getNodeName());
		return person;
	
}
	public static void main(String[] args) {
		try {
			/* make connection to server socket */
			Socket sock = new Socket("127.0.0.1", 9999);

			// send data to server
			DataOutputStream dos = new DataOutputStream(sock.getOutputStream());

			// receive data from server
			DataInputStream dis = new DataInputStream(sock.getInputStream());
			
			System.out.println("Input your file name: ");
			Scanner input = new Scanner(System.in);
			String fileName = input.nextLine();
			input.close();
			
			File xmlFile = new File("src/XMLSendThroughSocket/"+fileName+".xml");
			
			
			ArrayList<Student> students = getStudentsfromXML(xmlFile);
			System.out.println(students);
			
			for(int i=0;i<students.size();i++) {
				Student student = students.get(i);
				System.out.println(student.toString());
				Document doc = Object2Doc.convertObject2Doc(student);
				String xmlString = Object2Doc.convertDoc2XmlString(doc);
				
				dos.writeUTF(xmlString);
				dos.flush();
			}
			

			/* close the socket connection */
			dis.close();
			dos.close();
			sock.close();
		} catch (IOException ioe) {
			System.err.println(ioe);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
