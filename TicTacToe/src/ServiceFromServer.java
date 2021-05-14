
import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Latiude 7480
 */
public interface ServiceFromServer extends Remote{
    String sayHello() throws RemoteException;
    
    int getNumberNews() throws RemoteException;
    int getNumberBook() throws RemoteException;
    public void insertMedia(String type,int id, String author, String book_name) throws RemoteException;
    public boolean enterMove(char player, int index1, int index2) throws RemoteException;
    public TicTacToe draw() throws RemoteException;
    public boolean checkWin(char player) throws RemoteException;
    public char getCurrentPlayer() throws RemoteException;
}
