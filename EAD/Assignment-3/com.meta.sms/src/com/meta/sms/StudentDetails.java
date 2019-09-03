package com.meta.sms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StudentDetails")
public class StudentDetails extends HttpServlet {
       
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Connection con = DataBaseConnection.getConnection();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Student where student = " + id);

			pw.println("<html><body align=\"center\">");
			pw.println("<form action=\"UpdateStudent\" method=\"post\" >" );
			while (rs.next()) {
				pw.println("student ID: <input type=\"hidden\" name=\"id\" value=" + rs.getInt(1) + "> <br><br>");
				pw.println("first Name: <input type=\"text\" name=\"firstName\" value=" + rs.getString(2) + "> <br><br>");
				pw.println("last Name: <input type=\"text\" name=\"lastName\" value=" + rs.getString(3) + "> <br><br>");
				pw.println("father Name: <input type=\"text\" name=\"fatherName\" value=" + rs.getString(4) + "> <br><br>");
				pw.println("email: <input type=\"text\" name=\"email\" value=" + rs.getString(5) + "> <br><br>");
				pw.println("class: <input type=\"number\" name=\"class\" min=\"1\" max=\"12\"value=" + rs.getInt(6) + "> <br><br>");
				pw.println("age: <input type=\"number\" name=\"age\" value=" + rs.getInt(7) + "> <br><br>");
			}
			pw.print("<input type=\"submit\" value=\"UPDATE\">");
			pw.println("</form>");
			pw.println("</table><body></html>");
			
		} catch (SQLException e){
			System.out.println(e.getMessage());
			throw new AssertionError("not able to execute query");
			
		} finally {
			 try {
				con.close();
			} catch (SQLException e) {
				System.out.println();
			}
		}	
	}
}