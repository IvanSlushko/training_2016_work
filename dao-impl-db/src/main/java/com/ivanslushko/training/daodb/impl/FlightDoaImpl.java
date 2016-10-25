package com.ivanslushko.training.daodb.impl;

import java.util.List;

import javax.inject.Inject;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.ivanslushko.training.datamodel.Flight;
import com.ivanslushko.training.daodb.FlightDao;

public class FlightDoaImpl implements FlightDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public Flight get(Long id) {
		return jdbcTemplate.queryForObject("select * from flight where id = ?", new Object[] { id },
				new BeanPropertyRowMapper<Flight>(Flight.class));
	}

	@Override
	public void insert(Flight entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Flight entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Flight> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
