package com.ivanslushko.training.daodb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.ivanslushko.training.datamodel.City;

public final class CityMapper implements RowMapper<City> {
	@Override
	public City mapRow(ResultSet rs, int rowNum) throws SQLException {
		Long id = rs.getLong("id");
		String city = rs.getString("city");
		City entity = new City();
		entity.setId(id);
		entity.setCity(city);
		return entity;
	}

}
