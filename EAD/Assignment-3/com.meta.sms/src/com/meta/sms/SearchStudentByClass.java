package com.meta.sms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchStudentByClass extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public SearchStudentByClass() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Connection con = DataBaseConnection.getConnection();

		
		int studentClass = Integer.parseInt(request.getParameter("class"));

		try {
			PreparedStatement pst = con.prepareStatement
					("select * from student_details where student_class = ? ");
			
			pst.setInt(1, studentClass);

			pw.print("<table width=50% border=1>");
			pw.print("<caption>Result:</caption>");

			ResultSet rs = pst.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			int columnCount = rsmd.getColumnCount();
			pw.print("<tr>");
			
			for (int index = 1; index <= columnCount; index++) {
				pw.print("<th>" + rsmd.getColumnName(index) + "</th>");
			}

			pw.print("</tr>");

			while (rs.next()) {
				pw.print("<tr>"
						+ "<td>" + rs.getInt(1) + "</td>"
						+ "<td>" + rs.getString(2) + "</td>"
						+ "<td>" + rs.getString(3) + "</td>"
						+ "<td>" + rs.getString(4) + "</td>"
						+ "<td>" + rs.getString(5) + "</td>"
						+ "<td>" + rs.getInt(6) + "</td>"
						+ "<td>" + rs.getInt(7) + "</td>"
						+ "</tr>");
			}

			pw.print("</table>");
		}

		catch (SQLException e) {
			pw.println(e);
		}

		finally {
			pw.close();
		}

	}

}
