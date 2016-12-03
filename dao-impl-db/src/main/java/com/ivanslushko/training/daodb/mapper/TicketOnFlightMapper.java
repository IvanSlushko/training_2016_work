package com.ivanslushko.training.daodb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ivanslushko.training.datamodel.Flight;
import com.ivanslushko.training.datamodel.Ticket;
import com.ivanslushko.training.datamodel.TicketOnFlight;

public class TicketOnFlightMapper implements RowMapper<TicketOnFlight> {

	@Override
	public TicketOnFlight mapRow(ResultSet rs, int rowNum) throws SQLException {

		int flNum = rs.getInt("fl_num");

		Ticket ticket = new Ticket();
		ticket.setId(rs.getLong("id"));
		ticket.setPassenger(rs.getInt("passenger"));
		ticket.setPrice(rs.getInt("price"));
		ticket.setClas(rs.getInt("clas"));
		ticket.setBag(rs.getBoolean("bag"));
		ticket.setFirst_reg(rs.getBoolean("first_reg"));

		Flight flight = new Flight();
		flight.setId(rs.getLong("id"));
		flight.setPlane(rs.getInt("plane"));
		flight.setFromm(rs.getInt("fromm"));
		flight.setdAndT(rs.getTimestamp("d_and_t"));
		flight.setToo(rs.getInt("too"));

		TicketOnFlight ticketOnFlight = new TicketOnFlight();

		ticketOnFlight.setFlight(flight);
		ticketOnFlight.setTicket(ticket);
		ticketOnFlight.setFlNum(flNum);

		return ticketOnFlight;
	}
}
