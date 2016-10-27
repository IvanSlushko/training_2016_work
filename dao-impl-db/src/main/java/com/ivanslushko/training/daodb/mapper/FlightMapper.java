package com.ivanslushko.training.daodb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import org.springframework.jdbc.core.RowMapper;
import com.ivanslushko.training.datamodel.Flight;

public final class FlightMapper implements RowMapper<Flight> {

	@Override
	public Flight mapRow(ResultSet rs, int rowNum) throws SQLException {
		Long id = rs.getLong("id");
		String plane = rs.getString("plane");
		Integer from = rs.getInt("from");
		Date date = rs.getDate("d_and_t");
		Integer to = rs.getInt("to");
		Flight entity = new Flight();
		entity.setId(id);
		entity.setPlane(plane);
		entity.setFrom(from);
		entity.setdAndT(date);
		entity.setdAndT(date);
		entity.setTo(to);
		return entity;
	}
}
