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

import com.ivanslushko.training.daodb.PlaneDao;
import com.ivanslushko.training.datamodel.Plane;

@Repository
public class PlaneDaoImpl implements PlaneDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public Plane get(Long id) {
		return jdbcTemplate.queryForObject("select * from plane where id = ?", new Object[] { id },
				new BeanPropertyRowMapper<Plane>(Plane.class));
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
	public void update(Plane entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Plane delete(Long id) {
		jdbcTemplate.update("delete from plane where id = ?", new Object[] { id });
		return null;
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
