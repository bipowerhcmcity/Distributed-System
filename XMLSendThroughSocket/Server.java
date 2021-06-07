package XMLSendThroughSocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.w3c.dom.Document;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket socketServer = new ServerSocket(9999);
			System.out.println("I'm a server. I'm listening on the port 9999.");
			/* now listen for connections */

			Socket sock = socketServer.accept();

			// receive data from client
			DataInputStream dis = new DataInputStream(sock.getInputStream());

			// send to client
			DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
			
			boolean SAVING_SUCESS = true;
			while(true) {
				try {
					String dataFromClient = dis.readUTF();
					
					Document doc = Doc2Object.convertXmlString2Document(dataFromClient);
					Student user = Doc2Object.convertDoc2User(doc);
					if(GradeManagement.saveStudent(user) != SAVING_SUCESS) {
						System.out.println("Unable to import this student: "+user.toString());
						continue;
					};
					
				}catch (IOException ioe){
					break;
				}
				
				
				

			}

			
//			GradeManagement.getStudentById(14321);

			
			// close
			dis.close();
			dos.close();
			socketServer.close();
		} catch (IOException ioe) {
			System.err.println(ioe);
		}
	}
}
