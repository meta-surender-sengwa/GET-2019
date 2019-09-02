package com.meta.sms;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;


public class AddStudent extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Connection con=DataBaseConnection.getConnection();
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String fatherName = request.getParameter("fatherName");
		String email = request.getParameter("email");
		String studentClass = request.getParameter("studentClass");
		String age = request.getParameter("age");
        
        try {
            PreparedStatement ps = con.prepareStatement
                        ("insert into student(first_name, last_name, father_name, email, class, age) values(?,?,?,?,?,?)");

            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, fatherName);
            ps.setString(4, email);
            ps.setString(5, studentClass);
            ps.setString(6, age);
            
            int i = ps.executeUpdate();
            
            if(i > 0) {
            	out.println("<div align='center'>");
                out.println("Student Registeration successful");
                out.println("<br/>");
                out.println("<a href='index.html'>Go Back</a>");
                out.println("</div>");
            } else {
            	out.println("Student Registeration failed");
            }
        } catch(Exception ex) {
        	ex.printStackTrace();
        }
	}
}


