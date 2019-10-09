package com.metacube.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 
public class DataBaseConnection {
	
	static Connection con;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException cnf) {
			System.out.println("Driver could not be loaded: " + cnf);
		}
	
		String connectionUrl = "jdbc:mysql://localhost:3306/mps";
		String user = "root";
		String password = "root";
		
		try {
			con = DriverManager.getConnection(connectionUrl, user, password);
			
		} catch (SQLException sqle) {
			System.out.println("Error connecting to the database");
			System.out.println("SQL Exception thrown: " + sqle);
		}
	}
	
	public static Connection getConnection() {
		return con;
	}
}