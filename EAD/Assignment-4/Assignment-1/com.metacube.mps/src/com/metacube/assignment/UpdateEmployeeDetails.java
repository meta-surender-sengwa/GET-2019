package com.metacube.assignment;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateEmployeeDetails")
public class UpdateEmployeeDetails extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Connection con = DataBaseConnection.getConnection();

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String contact = request.getParameter("contact");
		String department = request.getParameter("department");

		try {
			Statement stmt = con.createStatement();
			boolean isUpdated = stmt.execute("UPDATE employee SET emp_name=" +name+ ",emp_gender=" +gender+ ",emp_email=" +email+ ",emp_password=" +password+ ",emp_contact=" +contact+ ",emp_departmen=" +department+ "where emp_id=" +id+ ";"	);													
				
			if (isUpdated == false) {
				 pw.println("alert('update successful !!')"); 
				 RequestDispatcher rd = request.getRequestDispatcher("home.html");
                 rd.forward(request, response);
				
			} else {
				throw new AssertionError("error occured while updating data");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new AssertionError("not able to execute query");
			
		} finally {
			try {
				con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}