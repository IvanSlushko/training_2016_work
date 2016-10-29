package com.ivanslushko.training.daodb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ivanslushko.training.daodb.customentity.FlightFromCity;
import com.ivanslushko.training.datamodel.City;
import com.ivanslushko.training.datamodel.Flight;

public final class FlightFromCityMapper implements RowMapper<FlightFromCity> {

	@Override
	public FlightFromCity mapRow(ResultSet rs, int rowNum) throws SQLException {

		Flight flight = new Flight();
		flight.setId(rs.getLong("id"));
		flight.setPlane(rs.getString("plane"));
		flight.setFrom(rs.getInt("from"));

		City city = new City();
		// city.setId = (rs.getLong("id"));
		city.setCity((rs.getString("city")));

		FlightFromCity flightFromCity = new FlightFromCity();
		flightFromCity.setFlight(flight);
		flightFromCity.setCity(city);

		return flightFromCity;
	}

}
