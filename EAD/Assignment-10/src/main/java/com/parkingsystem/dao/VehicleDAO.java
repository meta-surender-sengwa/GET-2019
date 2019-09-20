package com.parkingsystem.dao;

import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import com.parkingsystem.factory.DatabaseQuery;
import com.parkingsystem.model.pojo.VehiclePOJO;
import com.parkingsystem.service.SingleIntegerMapper;
import com.parkingsystem.service.SingleStringMapper;
import com.parkingsystem.factory.ConnectionFactory;

public class VehicleDAO {

	private static VehicleDAO vehicleDAO = null;
	private static JdbcTemplate jdbcTemplate = null;

	public static VehicleDAO getInstance() {

		if (vehicleDAO == null) {
			vehicleDAO = new VehicleDAO();
		}

		if (jdbcTemplate == null) {

			try {
				jdbcTemplate = new JdbcTemplate(
						new SingleConnectionDataSource(ConnectionFactory.getConnection(), true));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return vehicleDAO;
	}

	public boolean addVehicle(VehiclePOJO vehiclePOJO) throws SQLException, Exception {

		int result = jdbcTemplate.update(DatabaseQuery.ADD_VEHICLE, vehiclePOJO.getName(), vehiclePOJO.getType(),
				vehiclePOJO.getNumber(), vehiclePOJO.getIdentification(), vehiclePOJO.getEmpId());

		return result > 0;
	}

	public int getVehicleId(int empId) throws SQLException, Exception {
		return jdbcTemplate.queryForObject(DatabaseQuery.GET_VEHICLE_ID, new Object[] { empId },
				new SingleIntegerMapper());
	}

	public String getVehicleType(int empId) throws Exception {
		return jdbcTemplate.queryForObject(DatabaseQuery.GET_VEHICLE_TYPE, new Object[] { empId },
				new SingleStringMapper());
	}
}
