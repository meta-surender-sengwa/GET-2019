package com.metacube.assignment;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.sql.*;

@WebServlet("/EmployeeRegisteration")
public class EmployeeRegisteration extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Connection con = DataBaseConnection.getConnection();
		
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String contact = request.getParameter("contact");
		String department = request.getParameter("department");
		
        try {
            PreparedStatement ps = con.prepareStatement
            		("insert into employee(emp_name, emp_gender, emp_email, emp_password,"
                    + "emp_contact, emp_department) values(?,?,?,?,?,?)");

            ps.setString(1, name);
            ps.setString(2, gender);
            ps.setString(3, email);
            ps.setString(4, password);
            ps.setString(5, contact);
            ps.setString(6, department);
            
            int rowsEffected = ps.executeUpdate();
            
            if(rowsEffected > 0) {
            	 RequestDispatcher rd = request.getRequestDispatcher("login.html");
                 out.println("Employee registeration successful. Now login to get into your account");
                 rd.include(request, response);
                
            } else {
            }
            
        } catch(Exception ex) {
        	ex.printStackTrace();
        }
	}
}


