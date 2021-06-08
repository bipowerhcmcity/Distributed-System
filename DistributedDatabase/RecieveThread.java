package defaultPackage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class RecieveThread extends Thread{
	ObjectInputStream dis;
	Database database;
	
	public RecieveThread(ObjectInputStream dis , Database database) {
		this.dis = dis;
		this.database=database;
	}
	
	public void run() {
		while(true) {
			System.out.println("1");
			try {
				Student student = (Student) dis.readObject();
				System.out.println(student.toString());
				if(!database.sendToDatabase(student)) {
					System.out.println("Cannot send student sucessfully: "+student.toString());
				}
				else {
					System.out.println("Sending sucessfully: "+student.toString());

				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
