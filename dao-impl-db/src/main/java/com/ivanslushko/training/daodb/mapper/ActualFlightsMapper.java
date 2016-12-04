package com.ivanslushko.training.daodb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;

import com.ivanslushko.training.datamodel.ActualFlights;

public class ActualFlightsMapper implements RowMapper<ActualFlights> {

	@Override
	public ActualFlights mapRow(ResultSet rs, int rowNum) throws SQLException {

		Long id = rs.getLong("id");
		Integer plane = rs.getInt("plane");
		Integer fromm = rs.getInt("fromm");
		Timestamp date = rs.getTimestamp("d_and_t");
		Integer too = rs.getInt("too");

		ActualFlights actualFlights = new ActualFlights();

		actualFlights.setId(id);
		actualFlights.setPlane(plane);
		actualFlights.setFromm(fromm);
		actualFlights.setdAndT(date);
		actualFlights.setToo(too);
		return actualFlights;
	}

}
