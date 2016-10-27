package com.ivanslushko.training.daodb.impl;

import java.util.List;
import javax.inject.Inject;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.ivanslushko.training.datamodel.Passenger;
import com.ivanslushko.training.daodb.PassengerDao;

@Repository
public class PassengerDaoImpl implements PassengerDao{

	@Inject
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Passenger get(Long id) {
		return jdbcTemplate.queryForObject("select * from passenger where id = ?", new Object[] { id },
				new BeanPropertyRowMapper<Passenger>(Passenger.class));
	}

	@Override
	public void insert(Passenger entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Passenger entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Passenger> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
}
