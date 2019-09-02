package com.meta.sms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateStudent extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public UpdateStudent() {
		super();
	}

	protected void doPUT(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Connection con = DataBaseConnection.getConnection();
		
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String fatherName = request.getParameter("fatherName");
		String email = request.getParameter("email");
		String studentClass = request.getParameter("studentClass");
		String age = request.getParameter("age");
		
		try {
			
			PreparedStatement ps = con.prepareStatement
                    ("UPDATE student SET father_name?, email=?, class=?, age=?) WHERE"
                    		+ "first_name=?, last_name=?");

			ps.setString(1, fatherName);
			ps.setString(2, email);
			ps.setString(3, studentClass);
			ps.setString(4, age);
			ps.setString(5, firstName);
			ps.setString(6, lastName);
        
			int rowsEffected = ps.executeUpdate();
        
			if(rowsEffected > 0) {
				out.println("<div align='center'>");
				out.println("Successfully Updated");
				out.println("<br/>");
				out.println("<a href='index.html'>Go Back</a>");
				out.println("</div>");
	        } else {
	        	out.println("Update failed");
	        }
			
		} catch(Exception ex) {
			ex.printStackTrace();
			
		} finally {
			out.close();
		}
		
		
	}
}
