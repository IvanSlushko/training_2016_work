package com.ivanslushko.training.daodb.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.ivanslushko.training.datamodel.Passenger;

public final class PassengerMapper implements RowMapper<Passenger> {

	@Override
	public Passenger mapRow(ResultSet rs, int rowNum) throws SQLException {
		Long id = rs.getLong("id");
		String fullName = rs.getString("full_name");
		Date birthday = rs.getDate("birthday");
		String passport = rs.getString("passport");

		Passenger entity = new Passenger();

		entity.setId(id);
		entity.setFullName(fullName);
		entity.setBirthday(birthday);
		entity.setPassport(passport);
		return entity;
	}
}
