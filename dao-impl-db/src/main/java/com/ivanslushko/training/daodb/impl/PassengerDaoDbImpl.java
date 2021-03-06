package com.ivanslushko.training.daodb.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ivanslushko.training.daoapi.IPassengerDao;
import com.ivanslushko.training.datamodel.Passenger;

@Repository
public class PassengerDaoDbImpl implements IPassengerDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public Passenger get(Long id) {
		try {
			return jdbcTemplate.queryForObject("select * from passenger where id = ?", new Object[] { id },
					new BeanPropertyRowMapper<Passenger>(Passenger.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
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
	public Long update(final Passenger entity) {
		jdbcTemplate.update("update passenger set full_name = ?, birthday = ? , passport = ? where id = ?",
				entity.getFullName(), entity.getBirthday(), entity.getPassport(), entity.getId());
		return entity.getId();
	}

	@Override
	public void delete(Long id) {
		jdbcTemplate.update("delete from passenger where id = ?", new Object[] { id });
		// return null;
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

	@Override
	public List<Passenger> findByFullName(String fullName) {
		try {
			List<Passenger> rs = jdbcTemplate.query("select * from passenger where full_name = ?",
					new Object[] { fullName }, new BeanPropertyRowMapper<Passenger>(Passenger.class));
			return rs;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Passenger> findByBirthday(Date birthday) {
		try {
			List<Passenger> rs = jdbcTemplate.query("select * from passenger where birthday = ?",
					new Object[] { birthday }, new BeanPropertyRowMapper<Passenger>(Passenger.class));
			return rs;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Passenger> findByPassport(String passport) {
		try {
			List<Passenger> rs = jdbcTemplate.query("select * from passenger where passport = ?",
					new Object[] { passport }, new BeanPropertyRowMapper<Passenger>(Passenger.class));
			return rs;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
