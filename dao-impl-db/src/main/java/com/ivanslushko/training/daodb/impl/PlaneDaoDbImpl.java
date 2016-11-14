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

import com.ivanslushko.training.daoapi.IPlaneDao;
import com.ivanslushko.training.datamodel.Plane;

@Repository
public class PlaneDaoDbImpl implements IPlaneDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public Plane get(Long id) {
		// return jdbcTemplate.queryForObject("select * from plane where id =
		// ?", new Object[] { id },
		// new BeanPropertyRowMapper<Plane>(Plane.class));

		try {
			return jdbcTemplate.queryForObject("select * from plane where id = ?", new Object[] { id },
					new BeanPropertyRowMapper<Plane>(Plane.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

	@Override
	public Long insert(final Plane entity) {

		final String INSERT_SQL = "insert into plane (bort_number,model,passenger_count) values(?,?,?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "id" });
				ps.setString(1, entity.getBortNumber());
				ps.setString(2, entity.getModel());
				ps.setInt(3, entity.getPassengerCount());
				return ps;
			}
		}, keyHolder);
		entity.setId(keyHolder.getKey().longValue());
		return entity.getId();

	}

	@Override
	public Long update(final Plane entity) {
		jdbcTemplate.update("update plane set bort_number = ?, model= ? , passenger_count= ? where id = ?",
				entity.getBortNumber(), entity.getModel(), entity.getPassengerCount(), entity.getId());
		return entity.getId();
	}

	@Override
	public void delete(Long id) {
		jdbcTemplate.update("delete from plane where id = ?", new Object[] { id });
		// return null;
	}

	@Override
	public List<Plane> getAll() {
		List<Plane> rs = jdbcTemplate.query("select * from plane ", new BeanPropertyRowMapper<Plane>(Plane.class));
		return rs;
	}

	@Override
	public void save(Plane entity) {
		// TODO Auto-generated method stub

	}

}
