package com.metacube.assignment;

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

@WebServlet("/ShowEmployeeDetails")
public class ShowEmployeeDetails extends HttpServlet {
       
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("employee_registeration_id"));
		System.out.println(id);
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Connection con = DataBaseConnection.getConnection();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employee where emp_id = " + id);

			pw.println("<html><body align='center'>");
			pw.println("<form action='UpdateEmployeeDetails' method='post' >" );
			
			while (rs.next()) {
				pw.println("Employee ID: <input type=\"hidden\" name=\"id\" value=" + rs.getInt(1) + "> <br><br>");
				pw.println("Employee Name: <input type=\"text\" name=\"name\" value=" + rs.getString(2) + "> <br><br>");
				pw.println("Employee Gender: <input type=\"text\" name=\"gender\" value=" + rs.getString(3) + "> <br><br>");
				pw.println("Employee email: <input type=\"text\" name=\"email\" value=" + rs.getString(4) + "> <br><br>");
				pw.println("Employee Password: <input type=\"text\" name=\"password\" value=" + rs.getString(5) + "> <br><br>");
				pw.println("Employee Contact: <input type=\"text\" name=\"contact\" value=" + rs.getString(6) + "> <br><br>");
				pw.println("Employee Department: <input type=\"text\" name=\"department\" value=" + rs.getString(7) + "> <br><br>");
			}
			
			pw.print("<input type=\"submit\" value=\"EDIT\">");
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