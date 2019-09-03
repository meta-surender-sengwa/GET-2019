package com.meta.sms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchStudentByName extends HttpServlet {
	
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
					("SELECT * student where first_name = ? AND last_name = ? GROUP BY class");
			
			pst.setString(1, firstName);
			pst.setString(2, lastName);

			out.print("<table width=50% border=1>");
			out.print("<caption>Result:</caption>");

			ResultSet rs = pst.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			
			out.print("<tr>");
			
			for (int index = 1; index <= columnCount; index++) {
				out.print("<th>" + rsmd.getColumnName(index) + "</th>");
			}

			out.print("</tr>");

			while (rs.next()) {
				out.print("<tr>"
						+ "<td>" + rs.getInt(1) + "</td>"
						+ "<td>" + rs.getString(2) + "</td>"
						+ "<td>" + rs.getString(3) + "</td>"
						+ "<td>" + rs.getString(4) + "</td>"
						+ "<td>" + rs.getString(5) + "</td>"
						+ "<td>" + rs.getInt(6) + "</td>"
						+ "<td>" + rs.getInt(7) + "</td>"
						+ "</tr>");
			}

			out.print("</table>");
			out.println("<div align='center'><a href='index.html'>Go Back</a></div>");
	         
		} catch(Exception ex) {
			ex.printStackTrace();
			
		} finally {
			out.close();
		}		
	}
}
