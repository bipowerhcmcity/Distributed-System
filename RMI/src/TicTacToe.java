import java.io.Serializable;

public class TicTacToe implements Serializable{
	char [][] board;
	
	public TicTacToe() {
		board = new char[3][3];
		for(int i=0;i<3;i++) {
			for (int j=0;j<3;j++) {
				board[i][j] = '-';
			}
		}
	}
	public boolean enterMove(char player, int index1, int index2) {
		if(board[index1-1][index2-1]!='x' && board[index1-1][index2-1]!='o') {
			board[index1-1][index2-1] = player;
			return true;
		}
		return false;
		
	}
	public boolean win(char player) {
		// horizontal and vertical statement: 
		for(int j=0;j<3;j++) {
			int flag = 0;
			for(int i=0;i<3;i++) {
				if(board[i][j]!=player) {
					flag=1;
				}
			}
			if(flag==0) {
				System.out.println("First");
				return true;
			}
		}
		for(int j=0;j<3;j++) {
			int flag = 0;
			for(int i=0;i<3;i++) {
				if(board[j][i]!=player) {
					flag=1;
				}
			}
			if(flag==0) {
				System.out.println("Econd");
				return true;
			}
		}
		
		int flag = 0;
		for(int i=0;i<3;i++) {
			
			if(board[i][i]!=player) {
				flag=1;
			}
			
		}
		if(flag==0) {
			System.out.println("Third");
			return true;
		}
		
		int flag1 = 0;
		for(int i=0;i<3;i++) {
			if(board[2-i][i]!=player) {
				flag1=1;
			}
		}
		if(flag1==0) {
			System.out.println("last");
			return true;
		}
		
		
		return false;
	}
	public void draw() {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(j==0) {
					System.out.print(board[i][j]);
				}
				else {
					System.out.print("|"+board[i][j]);
				}
				
			}
			if(i!=2) {
				System.out.println("\n--------");
			}
			else {
				System.out.println("");
			}
			
		}
	}
	
}
