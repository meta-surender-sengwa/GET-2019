package com.meta.sms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

	static Connection con;
	static {
		String host = "jdbc:mysql://localhost:3306/";
		String dbName = "sms";
		String mySqlURL = host + dbName;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error loding driver :" + cnfe);
		}
		
		try {
			con = DriverManager.getConnection(mySqlURL, "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static Connection getConnection() {
		return con;
	}
}