package com.ivanslushko.training.daodb.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ivanslushko.training.datamodel.Flight;

public final class FlightMapper implements RowMapper<Flight> {

	@Override
	public Flight mapRow(ResultSet rs, int rowNum) throws SQLException {

		Long id = rs.getLong("id");
		Integer plane = rs.getInt("plane");
		Integer fromm = rs.getInt("fromm");
		Date date = rs.getDate("d_and_t");
		Integer too = rs.getInt("too");

		Flight entity = new Flight();

		entity.setId(id);
		entity.setPlane(plane);
		entity.setFromm(fromm);
		entity.setdAndT(date);
		entity.setToo(too);
		return entity;
	}
}
