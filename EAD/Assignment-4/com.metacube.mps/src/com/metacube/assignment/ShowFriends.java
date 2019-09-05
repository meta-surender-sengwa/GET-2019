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

@WebServlet("/ShowFriends")
public class ShowFriends extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("employee_registeration_id"));
		System.out.println(id);
		
		String department = request.getParameter("employee_department");
		System.out.println(department);

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Connection con = DataBaseConnection.getConnection();

		try {
			Statement stmt = con.createStatement();
			String query = "select emp_id, emp_name from employee where emp_department =" +department+ " AND emp_id <>" +id+ ";";
			ResultSet rs = stmt.executeQuery(query);

			pw.println("<html><body align='center'>");
			pw.println("<form action='ShowFriendProfile' method='post' >");
			pw.println("<h1>Friends List</h1>");

			while (rs.next()) {
				pw.print("<input type='text' name='id' value=" + rs.getString(1) + ">");
				pw.print("<input type='text' name='name' value=" + rs.getString(2) + ">");
				pw.print("<input type='submit' value='View Profile'>");
				pw.print("<br><br>");
			}

			pw.println("</form>");
			pw.println("</table><body></html>");

		} catch (SQLException e) {
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