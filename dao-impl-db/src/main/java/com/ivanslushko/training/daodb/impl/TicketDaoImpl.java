package com.ivanslushko.training.daodb.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ivanslushko.training.daodb.TicketDao;
import com.ivanslushko.training.datamodel.Ticket;

@Repository
public class TicketDaoImpl implements TicketDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public Ticket get(Long id) {
		return jdbcTemplate.queryForObject("select * from ticket where id = ?", new Object[] { id },
				new BeanPropertyRowMapper<Ticket>(Ticket.class));
	}

	@Override
	public Long insert(final Ticket entity) {

		final String INSERT_SQL = "insert into ticket (fl_num,passenger,clas,price,bag) values(?,?,?,?,?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "id" });
				ps.setInt(1, entity.getFlNum());
				ps.setInt(2, entity.getPassenger());
				ps.setInt(3, entity.getClas());
				ps.setInt(4, entity.getPrice());
				ps.setBoolean(5, entity.getBag());

				return ps;
			}
		}, keyHolder);
		entity.setId(keyHolder.getKey().longValue());
		return entity.getId();

	}

	@Override
	public void update(Ticket entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Ticket delete(Long id) {
		jdbcTemplate.update("delete from ticket where id = ?", new Object[] { id });
		return null;
	}

	@Override
	public List<Ticket> getAll() {
		List<Ticket> rs = jdbcTemplate.query("select * from ticket ", new BeanPropertyRowMapper<Ticket>(Ticket.class));
		return rs;
	}

	@Override
	public void save(Ticket entity) {
	}

}
