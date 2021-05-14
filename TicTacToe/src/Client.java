
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Latiude 7480
 */
public class Client {
    public static void main(String args[]) throws RemoteException, NotBoundException{
        String host = "localhost";
        
        Registry registry = LocateRegistry.getRegistry(host);
        
        ServiceFromServer stub = (ServiceFromServer) registry.lookup("ServicesFromServer");
         
        
//        while(scanner.hasNext()) {
//        	
//        	System.out.println("Get number of book: numberofBook\nGet number of Newspaper: numberofNewspaper\n"
//        			+ "Insert book: insertBook\nInsert Newspaper: insertNewspaper");
//        	String input = scanner.nextLine();
//        	if(input.equals("numberofBook")) {
//        		System.out.println("Get no of books...");
//        		int response2 = stub.getNumberBook();
//                System.out.println("Number of Books: "+response2);
//        	}
//        	else if(input.equals("numberofNewspaper")) {
//        		System.out.println("Get no of newspaper...");
//        		int response = stub.getNumberNews();
//                System.out.println("Number of Newspaper: "+response);
//        	}
//        	else if(input.equals("insertBook")) {
//        		System.out.println("id: ");
//        		int id= scanner.nextInt();
//        		scanner.nextLine();
//        		System.out.println("Author: ");
//        		String author = scanner.nextLine();
//        		System.out.println("Book name: ");
//        		String book_name = scanner.nextLine();
//        		stub.insertMedia("book", id, author, book_name);
//        	}
//        	else if(input.equals("insertNewspaper")) {
//        		System.out.println("id: ");
//        		int id= scanner.nextInt();
//        		System.out.println("Author: ");
//        		String author = scanner.nextLine();
//        		System.out.println("Newspaper name: ");
//        		String newspaper_name = scanner.nextLine();
//        		stub.insertMedia("newspaper", id, author, newspaper_name);
//        	}
//        	else {
//        		System.out.println("Wrong options, press q to exit");
//        	}
//        }
        
//        
//     	
        Scanner scanner = new Scanner(System.in);
        System.out.println("X or O");
        char player = scanner.next().charAt(0);        
        while(true) {
        	// check lose :
        	if(player=='x') {
        		if(stub.checkWin('o')) {
        			System.out.println("You lose");
        			break;
        		}
        	}
        	
        	if(player=='o') {
        		if(stub.checkWin('x')) {
        			System.out.println("You lose");
        			break;
        		}
        	}
        	if(stub.getCurrentPlayer() == player) {
        		int index1 = scanner.nextInt();
            	int index2 = scanner.nextInt();
            	scanner.nextLine();
            	boolean response = stub.enterMove(player, index1, index2);
            	
            	if(response == true) {
            		stub.draw().draw();
            	}
            	else {
            		System.out.println("Incorrect move");
            	}
            	
        	}
        	else {
        		if(scanner.hasNext()) {
            		scanner.next();
            		System.out.println("wait for your turn");
            	}
        	}
        	
        	if(stub.checkWin(player)) {
        		System.out.println("You win");
        		break;
        	}
        	
        	
        }
        
        scanner.close();
        	
        
    }
}
