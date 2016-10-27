package com.ivanslushko.training.daodb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.ivanslushko.training.datamodel.Ticket;

public class TicketMapper implements RowMapper<Ticket> {

	@Override
	public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
		Long id = rs.getLong("id");
		Integer flNum = rs.getInt("fl_num");
		Integer passenger = rs.getInt("passenger");
		Integer clas = rs.getInt("class");
		Integer price = rs.getInt("price");
		Boolean bag = rs.getBoolean("bag");

		Ticket entity = new Ticket();

		entity.setId(id);
		entity.setFlNum(flNum);
		entity.setPassenger(passenger);
		entity.setClas(clas);
		entity.setPrice(price);
		entity.setBag(bag);
		return entity;
	}

}
