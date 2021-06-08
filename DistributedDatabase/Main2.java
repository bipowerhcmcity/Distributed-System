package defaultPackage;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main2 {
	public static void main(String args[]) {
		Database database = new Database(new String("jdbc:mysql://localhost:3306/database2"));
		
		
		try {
			Socket sock = new Socket("127.0.0.1", 9999);
			System.out.println("Has connected sucessfully");
			database.synchronization(sock);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
