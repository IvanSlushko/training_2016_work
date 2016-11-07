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

	@Override
	public Long insert(final Flight entity) {
		final String INSERT_SQL = "insert into flight (plane, fromm, d_and_t, too) values(?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "id" });

				ps.setInt(1, entity.getPlane());
				ps.setInt(2, entity.getFromm());
				ps.setDate(3, entity.getdAndT());
				ps.setInt(4, entity.getToo());
				return ps;
			}
		}, keyHolder);
		entity.setId(keyHolder.getKey().longValue());
		return entity.getId();

	}

	@Override
	public void update(Flight entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Flight delete(Long id) {
		jdbcTemplate.update("delete from flight where id = ?", new Object[] { id });
		return null;
	}

	@Override
	public List<Flight> getAll() {
		List<Flight> rs = jdbcTemplate.query("select * from flight ", new BeanPropertyRowMapper<Flight>(Flight.class));
		return rs;
	}

	@Override
	public void save(Flight entity) {
	}

	@Override
	public List<FlightFromCity> getFromCity(Long id) {

		List<FlightFromCity> rs = jdbcTemplate.query(
				"select * from flight f left join city c on f.fromm=c.id where c.id=?", 
				new Object[] { id },
				new FlightFromCityMapper());
		return rs;

	}
}
