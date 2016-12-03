package com.ivanslushko.training.daodb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.ivanslushko.training.datamodel.City;

public final class CityMapper implements RowMapper<City> {
	@Override
	public City mapRow(ResultSet rs, int rowNum) throws SQLException {
		Long id = rs.getLong("id");
		String city_ru = rs.getString("city_ru");
		String city_en = rs.getString("city_en");
		String city_by = rs.getString("city_by");

		City entity = new City();
		entity.setId(id);
		entity.setCity_ru(city_ru);
		entity.setCity_en(city_en);
		entity.setCity_by(city_by);

		return entity;
	}

}
