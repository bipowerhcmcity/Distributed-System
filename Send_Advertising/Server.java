
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Latiude 7480
 */
public class Server {
    public static void main(String args[]) throws IOException, ClassNotFoundException{
        int serverPort = 1999;
        
        ServerSocket ss = new ServerSocket(serverPort);
        
        
        
        while(true){
            Socket socket = ss.accept();
            FileWriter out = new FileWriter("C:\\Users\\Latiude 7480\\Documents\\NetBeansProjects\\Test\\src\\main\\java/server_advertising.csv");

            try{
                
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            while(true){
                Advertising advertise = (Advertising) in.readObject();
                advertise.getInfo();
                out.write(advertise.writeInfo());
            }
            }
            catch(Exception ex){
                socket.close();
                out.close();

                System.out.println(ex);
            }
        }
        
    }
}
