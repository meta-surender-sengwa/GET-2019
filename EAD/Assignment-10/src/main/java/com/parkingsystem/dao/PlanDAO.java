package com.parkingsystem.dao;

import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import com.parkingsystem.factory.DatabaseQuery;
import com.parkingsystem.model.pojo.PlanPOJO;
import com.parkingsystem.service.SingleIntegerMapper;
import com.parkingsystem.factory.ConnectionFactory;

public class PlanDAO {

	private static PlanDAO planDAO = null;
	private static JdbcTemplate jdbcTemplate = null;

	public static PlanDAO getInstance() {

		if (planDAO == null) {
			planDAO = new PlanDAO();
		}

		if (jdbcTemplate == null) {
			try {
				jdbcTemplate = new JdbcTemplate(
						new SingleConnectionDataSource(ConnectionFactory.getConnection(), true));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return planDAO;
	}

	public boolean addPlan(PlanPOJO planPOJO, int empId) throws SQLException, Exception {

		int result = jdbcTemplate.update(DatabaseQuery.ADD_PLAN, planPOJO.getCurrency(), planPOJO.getType(),
				Double.parseDouble(planPOJO.getPrice()), empId);

		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	public int getPlanId(int empId) throws SQLException, Exception {

		return jdbcTemplate.queryForObject(DatabaseQuery.GET_PLAN_ID, new Object[] { empId },
				new SingleIntegerMapper());
	}
}
