package assignment;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlConnector {
	
	private String dataBaseType;
	private String dataBaseName;

	public String getDataBaseType() {
		return dataBaseType;
	}

	public void setDataBaseType(String dataBaseType) {
		this.dataBaseType = dataBaseType;
	}

	public String getDataBaseName() {
		return dataBaseName;
	}

	public void setDataBaseName(String dataBaseName) {
		this.dataBaseName = dataBaseName;
	}

	SqlConnector(String dataBaseType, String dataBaseName) {
		this.setDataBaseType(dataBaseType);
		this.setDataBaseName(dataBaseName);
	}

	public Connection connect() {
		
		try {
			Class.forName(this.getDataBaseType());
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + this.dataBaseName, "root", "root");
			return con;
			
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
	}

	public ResultSet executeQuery(String query) throws SQLException {
		
		Connection con = null;
		Statement stmt = null;
		
		try {
			con = this.connect();
			con.setAutoCommit(false);
			
			stmt = con.createStatement();
			ResultSet queryResult = stmt.executeQuery(query);
			con.commit();
			
			return queryResult;
			
		} catch (SQLException ex) {
			System.out.println(ex);
			con.rollback();
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		return null;
	}

	int executeUpdate(String query) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		
		try {
			con = this.connect();
			con.setAutoCommit(false);
			
			stmt = con.createStatement();
			stmt.executeUpdate("SET FOREIGN_KEY_CHECKS = 0");
			int queryResult = stmt.executeUpdate(query);
			
			con.commit();
			stmt.executeUpdate("SET FOREIGN_KEY_CHECKS = 1");
			
			return queryResult;
			
		} catch (Exception ex) {
			System.out.println(ex);
			con.rollback();
		}
		
		return 0;
	}

	int insertBatch(String Query[]) throws SQLException {
		
		Connection con = null;
		Statement stmt = null;
		
		try {
			con = this.connect();
			con.setAutoCommit(false);
			
			stmt = con.createStatement();
			for (int index = 0; index < Query.length; index++) {
				stmt.addBatch(Query[index]);
			}
			stmt.executeUpdate("SET FOREIGN_KEY_CHECKS = 0");
			
			int[] result = stmt.executeBatch();
			con.commit();
			stmt.executeUpdate("SET FOREIGN_KEY_CHECKS = 1");
			
			int indexJ = 0;
			for (int indexI = 0; indexI < result.length; indexI++) {
				if (result[indexI] == 1) {
					indexJ++;
				}
			}
			
			if (indexJ != result.length) {
				return 0;
				
			} else {
				return 1;
			}
			
		} catch (Exception ex) {
			
			System.out.println(ex);
			con.rollback();
			return 0;
		}
	}

}
