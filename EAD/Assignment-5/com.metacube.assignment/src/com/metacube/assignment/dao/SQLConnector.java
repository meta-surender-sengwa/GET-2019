package com.metacube.assignment.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class to connect to the Database
 * @author Surender
 */
public class SQLConnector {

	private static final String databaseName = "ShoppingSite";
	private static final String username = "root";
	private static final String password = "root";
	private static final String url = "jdbc:mysql://localhost:3306/";
	private static final String connectionClass = "com.mysql.jdbc.Driver";
	
	/**
	 * Method to make the connection
	 * @return The connection object
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	static Connection makeConnection() throws SQLException, ClassNotFoundException
	{
		Connection connection = null;
		try {
            Class.forName(connectionClass);  
            connection = DriverManager.getConnection((url + databaseName), username, password);
            
        } catch (Exception sqlException) {
            sqlException.printStackTrace();
        }
		return connection;
	}
}
