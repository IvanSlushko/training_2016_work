package com.ivanslushko.training.daodb.impl;
import java.util.List;
import javax.inject.Inject;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.ivanslushko.training.datamodel.Plane;
import com.ivanslushko.training.daodb.PlaneDao;

@Repository
public class PlaneDaoImpl implements PlaneDao{

	@Inject
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Plane get(Long id) {
		return jdbcTemplate.queryForObject("select * from plane where id = ?", new Object[] { id },
				new BeanPropertyRowMapper<Plane>(Plane.class));
	}

	@Override
	public void insert(Plane entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Plane entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Plane> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
