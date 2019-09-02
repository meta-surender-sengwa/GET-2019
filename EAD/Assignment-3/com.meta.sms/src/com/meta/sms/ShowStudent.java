package com.meta.sms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ShowAllStudent")
public class ShowStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowStudent() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Connection con = DataBaseConnection.getConnection();
		
		try {
			PreparedStatement pst = con.prepareStatement("select * from student");
			
			out.print("<table width=80% cellpadding=10 align='center'>");
			
			ResultSet rs = pst.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int totalColumns = rsmd.getColumnCount();
			
			out.print("<tr>");
			
			for (int index = 1; index <= totalColumns; index++) {
				out.print("<th>" + rsmd.getColumnName(index) + "</th>");
			}
			
			out.print("</tr>");
			
			while (rs.next()) {
				out.print("<tr>"
						+ "<td>" + rs.getString(1) + "</td>"
						+ "<td>" + rs.getString(2) + "</td>"
						+ "<td>" + rs.getString(3) + "</td>"
						+ "<td>" + rs.getString(4) + "</td>"
						+ "<td>" + rs.getString(5) + "</td>"
						+ "<td>" + rs.getString(6) + "</td>"
						+ "<td><a href='UpdateStudent.html'>Update</a></td>"
						+ "</tr>");
				out.println("<script>");
				out.println("function passValue() {");
				out.println("document.cookie = '+rs.getString(1)+ ',' + rs.getString(2) +'; path=/UpdateStudent.html';");
				out.println("newSummary();	");
				out.println("}");
				out.println("function newSummary() {");
				out.println("	window.open('UpdateStudent.html', '_blank');");
				out.println("}");
				out.println("</script>");
			}
			
			out.print("</table>");
			out.print("<br><br>");
			out.println("<div align='center'><a href='index.html'>Go Back</a></div>");
		}

		catch (SQLException e) {
			out.println(e);
		}

		finally {
			out.close();
		}
	}
}