package com.meta.sms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchStudent extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Connection con=DataBaseConnection.getConnection();
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		try {
			PreparedStatement pst = con.prepareStatement
					("SELECT father_name, email, class, age from student where first_name = ? AND last_name = ? GROUP BY class");
			pst.setString(1, firstName);
			pst.setString(2, lastName);

			ResultSet rs = pst.executeQuery();

			out.print("<table width=80% cellpadding=10 align='center'>");

			while (rs.next()) {
				out.print("<tr>"
						+ "<td>" + firstName + "</td>"
						+ "<td>" + lastName + "</td>"
						+ "<td>" + rs.getString(1) + "</td>"
						+ "<td>" + rs.getString(2) + "</td>"
						+ "<td>" + rs.getString(3) + "</td>"
						+ "<td>" + rs.getString(4) + "</td>"
						+ "</tr>");
			}
			out.print("</table>");
			out.print("<br><br>");
			out.println("<div align='center'><a href='index.html'>Go Back</a></div>");
	         
		} catch(Exception ex) {
			ex.printStackTrace();
			
		} finally {
			out.close();
		}
			
	}

}
