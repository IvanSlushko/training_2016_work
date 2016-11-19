package com.ivanslushko.training.daodb.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ivanslushko.training.daoapi.ICityDao;
import com.ivanslushko.training.datamodel.City;

@Repository
public class CityDaoDbImpl implements ICityDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public City get(Long id) {
		try {
			return jdbcTemplate.queryForObject("select * from city where id = ?", new Object[] { id },
					new BeanPropertyRowMapper<City>(City.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public void delete(Long id) {
		jdbcTemplate.update("delete from  city where id =" + id);
		// return null;
	}

	@Override
	public List<City> getAll() {
		List<City> rs = jdbcTemplate.query("select * from city ", new BeanPropertyRowMapper<City>(City.class));
		return rs;
	}

	@Override
	public Long insert(final City entity) {

		final String INSERT_SQL = "insert into city (city) values(?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "id" });
				ps.setString(1, entity.getCity());
				return ps;
			}
		}, keyHolder);
		entity.setId(keyHolder.getKey().longValue());
		return entity.getId();

	}

	@Override
	public Long update(final City entity) {
		jdbcTemplate.update("update city set city = ? where id = ?", entity.getCity(), entity.getId());
		return entity.getId();

	}

	@Override
	public void save(City entity) {
	}
}
