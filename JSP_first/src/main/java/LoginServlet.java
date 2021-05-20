import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// Add connector to WEB-INF/lib to run in TOMCAT
			// To minimize code : redirect to JSP .
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MAS", "root", "123456bnm");
			PreparedStatement  statement = con.prepareCall("Call check_user(?,?)");
			statement.setString(1,request.getParameter("username"));
			statement.setString(2,request.getParameter("password"));
			
			ResultSet resultSet = statement.executeQuery();
			
			 PrintWriter out = response.getWriter();
			
			 boolean success = false;
			 while (resultSet.next())
	            {
	            	if(resultSet.getString("username")!=null) {
	            		response.sendRedirect(request.getContextPath()+"/sucessfully.jsp");
	            	}
	            }
			if(!success) {
				response.sendRedirect(request.getContextPath()+"/fail.jsp");
			}
			 
            statement.close();
            
            System.out.println("Stored procedure called successfully!");
            
            
            con.close();
			
		} catch (SQLException e) {
			PrintWriter out = response.getWriter();
	        String title = "Problem";
	        String docType =
	           "<!doctype html public \"-//w3c//dtd html 4.0 " + 
	           "transitional//en\">\n";
	            
	        out.println(docType +
	           "<html>\n" +
	              "<head><meta charset=\"UTF-8\">\n" +
	              "<title>" + title + "</title></head>\n" +
	              "<body bgcolor = \"#f0f0f0\">\n" +
	              e.getMessage()+ 
	              "</body>" + 
	           "</html>"
	        );
		
			e.printStackTrace();
		}

//                }
 catch (ClassNotFoundException e) {
	 PrintWriter out = response.getWriter();
     String title = "Problem";
     String docType =
        "<!doctype html public \"-//w3c//dtd html 4.0 " + 
        "transitional//en\">\n";
         
     out.println(docType +
        "<html>\n" +
           "<head><meta charset=\"UTF-8\">\n" +
           "<title>" + title + "</title></head>\n" +
           "<body bgcolor = \"#f0f0f0\">\n" + "Class not found: "+
           e.getMessage()+ 
           "</body>" + 
        "</html>");
		}
	}

}