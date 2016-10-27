package com.ivanslushko.training.daodb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.ivanslushko.training.datamodel.Plane;

public class PlaneMapper implements RowMapper<Plane>{
	
	@Override
	public Plane mapRow(ResultSet rs, int rowNum) throws SQLException {
		Long id = rs.getLong("id");
		String bortNumber = rs.getString("bort_number");
		String model = rs.getString("model");
		Integer passengerCount = rs.getInt("passenger_count");	
		Plane entity = new Plane();
		entity.setId(id);
		entity.setBortNumber(bortNumber);
		entity.setModel(model);
		entity.setPassengerCount(passengerCount);
		return entity;
	}
}
