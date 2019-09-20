package com.parkingsystem.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	static final String DRIVER = "com.mysql.jdbc.Driver";
	static final String USER_NAME = "root";
	static final String PASSWORD = "root";
	static final String URL = "jdbc:mysql://localhost:3306/employee";

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
