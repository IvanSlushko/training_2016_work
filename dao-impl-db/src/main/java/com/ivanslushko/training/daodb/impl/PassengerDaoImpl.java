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

import com.ivanslushko.training.daodb.PassengerDao;
import com.ivanslushko.training.datamodel.Passenger;

@Repository
public class PassengerDaoImpl implements PassengerDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public Passenger get(Long id) {
		return jdbcTemplate.queryForObject("select * from passenger where id = ?", new Object[] { id },
				new BeanPropertyRowMapper<Passenger>(Passenger.class));
	}

	@Override
	public Long insert(final Passenger entity) {

		final String INSERT_SQL = "insert into passenger (full_name,birthday,passport) values(?,?,?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "id" });
				ps.setString(1, entity.getFullName());
				ps.setDate(2, entity.getBirthday());
				ps.setString(3, entity.getPassport());
				return ps;
			}
		}, keyHolder);
		entity.setId(keyHolder.getKey().longValue());
		return entity.getId();
	}

	@Override
	public void update(Passenger entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Passenger delete(Long id) {
		jdbcTemplate.update("delete from passenger where id = ?", new Object[] { id });
		return null;
	}

	@Override
	public List<Passenger> getAll() {
		List<Passenger> rs = jdbcTemplate.query("select * from passenger ",
				new BeanPropertyRowMapper<Passenger>(Passenger.class));
		return rs;
	}

	@Override
	public void save(Passenger entity) {

	}

}
