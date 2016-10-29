package com.ivanslushko.training.daodb.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ivanslushko.training.daodb.FlightDao;
import com.ivanslushko.training.daodb.customentity.FlightFromCity;
import com.ivanslushko.training.daodb.mapper.FlightFromCityMapper;
import com.ivanslushko.training.datamodel.Flight;

@Repository
public class FlightDoaImpl implements FlightDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public Flight get(Long id) {
		return jdbcTemplate.queryForObject("select * from flight where id = ?", new Object[] { id },
				new BeanPropertyRowMapper<Flight>(Flight.class));
	}

	@Inject
	private JdbcTemplate jdbcTemplate1;
	
	@Override
	public FlightFromCity getFromCity(Long id) {
		return jdbcTemplate1.queryForObject("select * from flight f left join city c on f.from=c.id where c.id=?",
				new Object[] { id }, new FlightFromCityMapper());
	}

	@Override
	public Long insert(Flight entity) {
		return null;
		// TODO Auto-generated method stub !!!!!!!!!!!!!!!!!!!!!!!!!!!!!

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
