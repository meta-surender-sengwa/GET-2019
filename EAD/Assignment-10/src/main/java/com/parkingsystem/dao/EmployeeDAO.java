package com.parkingsystem.dao;

import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import com.parkingsystem.factory.DatabaseQuery;
import com.parkingsystem.model.dto.EmployeeDTO;
import com.parkingsystem.model.dto.FriendDTO;
import com.parkingsystem.model.pojo.EmployeePOJO;
import com.parkingsystem.service.EmployeeMapper;
import com.parkingsystem.service.FriendListMapper;
import com.parkingsystem.service.FriendMapper;
import com.parkingsystem.service.SingleStringMapper;
import com.parkingsystem.factory.ConnectionFactory;

public class EmployeeDAO {

	private static EmployeeDAO employeeDAO = null;

	private static JdbcTemplate jdbcTemplate = null;

	public static EmployeeDAO getInstance() {

		if (employeeDAO == null) {
			employeeDAO = new EmployeeDAO();
		}

		if (jdbcTemplate == null) {

			try {
				jdbcTemplate = new JdbcTemplate(
						new SingleConnectionDataSource(ConnectionFactory.getConnection(), true));

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return employeeDAO;
	}

	public int addEmployee(EmployeePOJO employeePOJO) {

		int result = jdbcTemplate.update(DatabaseQuery.ADD_EMPLOYEE, employeePOJO.getName(), employeePOJO.getGender(),
				employeePOJO.getEmail(), employeePOJO.getPassword(), employeePOJO.getPhoneNumber(),
				Integer.parseInt(employeePOJO.getCompany()));

		if (result > 0) {
			return result;
		} else {
			return -1;
		}
	}

	public EmployeeDTO getEmployeeDetail(String email) throws SQLException, Exception {
		return jdbcTemplate.queryForObject(DatabaseQuery.GET_EMPLOYEE_DETAIL, new EmployeeMapper(), email);
	}

	public FriendDTO getFriendDetail(String email) throws SQLException, Exception {
		return jdbcTemplate.queryForObject(DatabaseQuery.GET_FRIEND_DETAIL, new FriendMapper(), email);
	}

	public boolean updateEmployeeDetail(EmployeePOJO employeePOJO, String email) throws SQLException, Exception {

		int result = jdbcTemplate.update(DatabaseQuery.UPDATE_EMPLOYEE_DETAIL, employeePOJO.getEmail(),
				employeePOJO.getPassword(), employeePOJO.getPhoneNumber(), email);
		
		return result > 0;
			
	}

	public List<FriendDTO> getFriendList(String email) throws SQLException, Exception {
		return jdbcTemplate.queryForObject(DatabaseQuery.GET_FRIENDS_LIST, new FriendListMapper(), email);
	}

	public int getEmployeeId(String email) throws SQLException, Exception {
		return jdbcTemplate.queryForObject(DatabaseQuery.GET_EMPLOYEE_ID, Integer.class, email);
	}

	public boolean updatePhotoUrl(String email, String url) throws SQLException, Exception {

		int result = 0;
	
		try {
			result = jdbcTemplate.update(DatabaseQuery.UPDATE_PHOTO_URL, email, url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result > 0;
	}

	public String getPhotoUrl(String email) throws SQLException, Exception {
		return jdbcTemplate.queryForObject(DatabaseQuery.GET_PHOTO_URL, new SingleStringMapper(), email);
	}
}
