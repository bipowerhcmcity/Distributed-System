package defaultPackage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main1 {

	public static void main(String args[]) {
		Database database = new Database(new String("jdbc:mysql://localhost:3306/database1"));		
		
		ServerSocket socketServer;
		try {
			System.out.println("Server is running...");
			socketServer = new ServerSocket(9999);
			Socket sock = socketServer.accept();
			System.out.println("Server has received client socket");
			database.synchronization(sock);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("I'm a server. I'm listening on the port 9999.");
		/* now listen for connections */

		
	}
}
