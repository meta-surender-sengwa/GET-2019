package com.metacube.assignment;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.sql.*;

@WebServlet("/VehicleRegisteration")
public class VehicleRegisteration extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Connection con = DataBaseConnection.getConnection();
		
		String vehicleNname = request.getParameter("vehicleName");
		String vehicleType= request.getParameter("vehicle_type");
		String vehicleNumber= request.getParameter("vehicleNumber");
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		String vehicleIdentifiaction = request.getParameter("vehicle_identification");
		
        try {
            PreparedStatement ps = con.prepareStatement
            	("insert into vehicle(vehicle_name, vehicle_type, vehicle_number, employee_id, vehicle_identification) values(?,?,?,?,?)");

            ps.setString(1, vehicleNname);
            ps.setString(2, vehicleType);
            ps.setString(3, vehicleNumber);
            ps.setInt(4, employeeId);
            ps.setString(5, vehicleIdentifiaction);
            
            int rowsEffected = ps.executeUpdate();
            
            if(rowsEffected > 0) {
            	 RequestDispatcher rd = request.getRequestDispatcher("login.html");
                 out.println("<div align='center'>Your vehicle successfully addded. <br> Now login to continue....</div>");
                 rd.include(request, response);
                
            } else {
            	
            }
            
        } catch(Exception ex) {
        	ex.printStackTrace();
        }
	}
}


