package com.meta.sms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Connection con = DataBaseConnection.getConnection();

		int id = Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String fatherName = request.getParameter("fatherName");
		String email = request.getParameter("email");
		String studentClass = request.getParameter("class");
		String age = request.getParameter("age");

		try {
			Statement stmt = con.createStatement();
			boolean isUpdated = stmt.execute("UPDATE student_details SET "
					+ "student_fname = '" + firstName 
					+ "',student_lname='" + lastName
					+ "', father_name = '" + fatherName
					+ "',student_email_id='" + email
					+ " ' ,student_class = ' " + studentClass
					+ "', student_age='" + age
					+ "' where student_id = " + id);

			if (isUpdated == false) {
				pw.println("<html> <body><h1> Successfully updated Student data!!!</h1></body></html>");
				
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