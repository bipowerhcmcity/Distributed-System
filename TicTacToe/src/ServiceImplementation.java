/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Latiude 7480
 */
import java.rmi.RemoteException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ServiceImplementation implements ServiceFromServer{
	private TicTacToe board;
	private char currentPlayer;
	public ServiceImplementation() {
		this.board = new TicTacToe();
		System.out.println(board);
		this.currentPlayer = 'x';
	}
    public String sayHello(){
        return "Hello World";
    }
    public int getNumberNews(){
        int result = 0;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MAS", "root", "123456bnm");
            //Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select COUNT(*) from newspaper;");
            while (rs.next())
            {
            	System.out.println("RS: "+rs.getInt(1));
            	result= rs.getInt(1);
            }
            
            
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(ServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(ServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

	return result;		
    
    }
    
    
    public int getNumberBook(){
        int result = 0;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MAS", "root", "123456bnm");
            //Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select COUNT(*) from book;");
            while (rs.next())
            {
            	System.out.println("RS: "+rs.getInt(1));
            	result= rs.getInt(1);
            }
            
            
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(ServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(ServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

	return result;		
    
    }
    
    public void insertMedia(String type,int id, String author, String book_name) {
    	try {
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MAS", "root", "123456bnm");
            //Class.forName("com.mysql.jdbc.Driver");
            String query = "insert into "+type+"(id,author,book_name)"+"values (?,?,?)";
            
            PreparedStatement preparedStm = con.prepareStatement(query);
            preparedStm.setInt(1,id);
            preparedStm.setString(2,author);
            preparedStm.setString(3,book_name);
            
            preparedStm.execute();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(ServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(ServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    	
    }
    
    public boolean enterMove(char player,int index1,int index2) {
    	if(this.currentPlayer==player && board.enterMove(player, index1, index2)==true) {
    		if(player =='x') {
    			System.out.println("change to o");
    			this.currentPlayer ='o';
    		}
    		else if(player=='o') {
    			System.out.println("change to x");
    			this.currentPlayer ='x';
    		}
    		System.out.println("Current player is : "+this.currentPlayer);
    		return true;
    	}
    	else {
    		return false;
    	}
    	
    	
    	
    }
    public TicTacToe draw() {
    	return board;
    }
    public boolean checkWin(char player) {
    	return board.win(player);
    }
    public char getCurrentPlayer() {
    	return this.currentPlayer;
    }


}
