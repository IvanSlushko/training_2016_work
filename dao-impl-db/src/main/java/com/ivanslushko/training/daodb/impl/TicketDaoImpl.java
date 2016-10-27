package com.ivanslushko.training.daodb.impl;
import java.util.List;
import javax.inject.Inject;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.ivanslushko.training.datamodel.Ticket;
import com.ivanslushko.training.daodb.TicketDao;

@Repository
public class TicketDaoImpl implements TicketDao{

	@Inject
	private JdbcTemplate jdbcTemplate;	
	
	@Override
	public Ticket get(Long id) {
		return jdbcTemplate.queryForObject("select * from ticket where id = ?", new Object[] { id },
				new BeanPropertyRowMapper<Ticket>(Ticket.class));
	}

	@Override
	public void insert(Ticket entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Ticket entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Ticket> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
