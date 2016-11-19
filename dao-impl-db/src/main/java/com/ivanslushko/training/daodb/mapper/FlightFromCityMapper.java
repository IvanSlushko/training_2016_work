package com.ivanslushko.training.daodb.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ivanslushko.training.datamodel.City;
import com.ivanslushko.training.datamodel.Flight;
import com.ivanslushko.training.datamodel.FlightFromCity;

public final class FlightFromCityMapper implements RowMapper<FlightFromCity> {

	@Override
	public FlightFromCity mapRow(ResultSet rs, int rowNum) throws SQLException {

		int too = rs.getInt("too");
		Date date = rs.getDate("d_and_t");
		String fr_city = rs.getString("city");
//		String to_city = rs.getString("city");
//		int plane = rs.getInt("too");
		
		
		Flight flight = new Flight();
		flight.setId(rs.getLong("id"));
		flight.setPlane(rs.getInt("plane"));
		flight.setFromm(rs.getInt("fromm"));

		City city = new City();
		// city.setId = (rs.get("id"));
		city.setCity((rs.getString("city")));

		FlightFromCity flightFromCity = new FlightFromCity();
		flightFromCity.setFlight(flight);
		flightFromCity.setCity(city);
		flightFromCity.setFrCity(fr_city);	
//		flightFromCity.setToCity(to_city);	
		
		flightFromCity.setToo(too);
		flightFromCity.setDate(date);
		flightFromCity.setPlane(rs.getInt("plane"));
		
		return flightFromCity;
	}
}
