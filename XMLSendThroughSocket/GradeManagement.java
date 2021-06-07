package XMLSendThroughSocket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GradeManagement {
	// save a student to student table
	public static boolean saveStudent(Student student) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root",
					"123456bnm");

			Statement stmt = con.createStatement();
			int signal = stmt.executeUpdate("INSERT INTO student values(" + student.getId() + ",'" + student.getName()
					+ "'," + student.getGrade() + ")");
			System.out.println(signal);
			return true;

			// version 2: prepareStatement
		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
			return false;
		}
	}

	// get all the students from the student table
	// connection pool
	public static List<Student> getStudents() {
		List<Student> students = new ArrayList<Student>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root",
					"123456bnm");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM student");

			while (rs.next()) {
				students.add(new Student(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return students;
	}

	// get a student by id
	//  make sure student(id) ... exist in this table
	public static Student getStudentById(int id) {
		Student result = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root",
					"123456bnm");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM student WHERE id=" + id);
			while (rs.next()) {
				result = new Student(rs.getInt(1), rs.getString(2), rs.getInt(3));
				System.out.println("Get student: "+result+"from id "+id);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public static void main(String[] args) {
		getStudentById(999);
	}
}
