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

import com.ivanslushko.training.daodb.CityDao;
import com.ivanslushko.training.datamodel.City;

@Repository
public class CityDaoImpl implements CityDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public City get(Long id) {
		return jdbcTemplate.queryForObject("select * from city where id = ?", new Object[] { id },
				new BeanPropertyRowMapper<City>(City.class));
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<City> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long insert(final City entity) {

		final String INSERT_SQL = "insert into city (city) values(?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(
						INSERT_SQL, new String[] { "id" });
				ps.setString(1, entity.getCity());
				return ps;
			}
		}, keyHolder);

		entity.setId(keyHolder.getKey().longValue());

		return entity.getId();

	}

	@Override
	public void update(City entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(City entity) {
		// TODO Auto-generated method stub

	}

}
