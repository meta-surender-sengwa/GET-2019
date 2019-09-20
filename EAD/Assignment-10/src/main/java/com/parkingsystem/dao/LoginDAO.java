package com.parkingsystem.dao;

import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import com.parkingsystem.factory.DatabaseQuery;
import com.parkingsystem.model.pojo.LoginPOJO;
import com.parkingsystem.service.SingleIntegerMapper;
import com.parkingsystem.factory.ConnectionFactory;

public class LoginDAO {

	private static LoginDAO loginDAO = null;
	private static JdbcTemplate jdbcTemplate = null;

	public static LoginDAO getInstance() {

		if (loginDAO == null) {
			loginDAO = new LoginDAO();
		}

		if (jdbcTemplate == null) {
			
			try {
				jdbcTemplate = new JdbcTemplate(
						new SingleConnectionDataSource(ConnectionFactory.getConnection(), true));

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return loginDAO;
	}

	public boolean login(LoginPOJO loginPOJO) throws SQLException, Exception {

		int result = jdbcTemplate.queryForObject(DatabaseQuery.CHECK_LOGIN, new SingleIntegerMapper(),
				loginPOJO.getEmail(), loginPOJO.getPassword());
		
		return result==1;
	}
}
