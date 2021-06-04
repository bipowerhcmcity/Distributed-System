package XMLSendThroughSocket;
import org.w3c.dom.*;

public class StudentFactory {
	public Student getStudent(String type, Element currentNode) {
		if(type=="#text") {
			return null;
		}
		if(type=="student") {
			int id = Integer.parseInt(currentNode.getElementsByTagName("id").item(0).getTextContent());
			String name =currentNode.getElementsByTagName("name").item(0).getTextContent() ;
			int grade = Integer.parseInt(currentNode.getElementsByTagName("grade").item(0).getTextContent());
			
			return new Student(id,name,grade);
		}
//		if(type =="employee") {
//			return new Employee();
//		}
		else {
			return null;
		}
		
	}
}
