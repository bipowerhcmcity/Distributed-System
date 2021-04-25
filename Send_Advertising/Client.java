
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Latiude 7480
 */
import java.util.ArrayList;
public class Client {
    public static void main(String args[]) throws IOException{
        String serverName = "localhost";
        int serverPort = 1999;
        String fileName = System.getProperty("user.dir")+"advertising.csv";

        System.out.println("Establishing connection. Please wait ...");
        Socket socket = new Socket(serverName,serverPort);

//        System.out.println("Connected: "+socket);
        ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
        
        File file = new File(fileName);
        Scanner reader = new Scanner(file);
        
        while (reader.hasNextLine()) {
            
            String data = reader.nextLine();
            StringTokenizer tokens = new StringTokenizer(data, ",");
            
            float tv;
            float radio;
            float newspaper;
            float sales;
            
            tv= Float.parseFloat(tokens.nextToken());
            radio= Float.parseFloat(tokens.nextToken());
            newspaper= Float.parseFloat(tokens.nextToken());
            sales= Float.parseFloat(tokens.nextToken());
            
            Advertising advertise = new Advertising(tv,radio,newspaper,sales);
            advertise.getInfo();
            os.writeObject(advertise);
            os.flush();
            
        }
        os.close();
        reader.close();
         
         
         
    }
    
}
