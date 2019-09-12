package com.metacube.assignment.factory;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * This is connection factory class This gives the connection object
 * @author Surender
 */
public class ConnectionFactory {

	static final String DRIVER = "com.mysql.jdbc.Driver";
	
	static final String USER_NAME = "root";
	static final String PASSWORD = "root";
	
	static final String URL = "jdbc:mysql://localhost:3306/bookstore";

	/**
	 * This method return the connection object to connect with database
	 * @return object of Connection class
	 * @throws Exception when driver class not found or can't create connection
	 */
	public static Connection getConnection() throws Exception {

		try {
			Connection conn = null;
			Class.forName(DRIVER).newInstance();
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			return conn;
			
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		}
	}
}
