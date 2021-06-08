package defaultPackage;

import java.io.*;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Database {
	private Connection con=null;
	public boolean sendToDatabase(Student student) {
		try {
			Statement stmt = con.createStatement();
			int signal = stmt.executeUpdate("INSERT INTO student values(" + student.getId() + ",'" + student.getName()
					+ "'," + student.getGrade() + ")");
			System.out.println(signal);
			return true;
			
		} catch (SQLException e) {
			return false;
		}
	}
	private List<Student> getStudents() {
		List<Student> students = new ArrayList<Student>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM student");

			while (rs.next()) {
				students.add(new Student(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return students;
	}
	
	public Database(String url) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.con = DriverManager.getConnection(url,"root","123456bnm");;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void synchronization(Socket recipentSocket) {
			try {
				// output before input.
				ObjectOutputStream dos = new ObjectOutputStream(recipentSocket.getOutputStream());
				ObjectInputStream dis = new ObjectInputStream(recipentSocket.getInputStream());
				List<Student> students = getStudents();

				RecieveThread receiver = new RecieveThread(dis,this);
				
				for(int i=0;i<students.size();i++) {
					dos.writeObject(students.get(i));
					
				}
				receiver.start();

				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		
	}

}
