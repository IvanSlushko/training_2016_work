package com.ivanslushko.training.daodb.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.ivanslushko.training.daodb.PassengerDao2;
import com.ivanslushko.training.daodb.PassengerSearchCriteria;
import com.ivanslushko.training.datamodel.Passenger2;

public class PassengerDaoImpl2 implements PassengerDao2 {

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	private RowMapper<Passenger2> rowMapper = new RowMapper<Passenger2>() {
		@Override
		public Passenger2 mapRow(ResultSet rs, int rowNum) throws SQLException {
			Passenger2 passenger2 = new Passenger2();
			passenger2.setId(rs.getInt("id"));
			passenger2.setPassport(rs.getString("passport"));
			passenger2.setBirthday(rs.getDate("birthday"));
			passenger2.setFullName(rs.getString("full_name"));
			return passenger2;
		}
	};

	@Override
	public void insert(Passenger2 passenger2) {
		String sql = "INSERT INTO passenger(id, full_name, birthday, passport) VALUES(?,?,?,?)";
		jdbcTemplate.update(sql, getPreparedStatementSetter(passenger2));
	}

	@Override
	public void update(Passenger2 passenger2) {
		String sql = "UPDATE passenger SET full_name=?, passport=?, birthday=? WHERE id=?";
		jdbcTemplate.update(sql, getPreparedStatementSetter(passenger2));
	}

	@Override
	public void delete(Passenger2 passenger2) {
		jdbcTemplate.update("DELETE FROM passenger WHERE id=?", passenger2.getId());
	}

	@Override
	public Passenger2 getById(Integer id) {
		return jdbcTemplate.queryForObject("SELECT * FROM passenger WHERE id=?", rowMapper, id);
	}

	@Override
	public List<Passenger2> getAll() {
		return jdbcTemplate.query("SELECT * FROM passenger", rowMapper);
	}

	@Override
	public List<Passenger2> findByCriteria(PassengerSearchCriteria criteria) {
		if (criteria.isEmpty()) {
			return getAll();
		}
		String sql = "SELECT * FROM passenger WHERE true";
		if (criteria.getPassport() != null) {
			sql += " AND passport=:passport";
		}
		if (criteria.getFullName() != null) {
			sql += " AND full_name=:full_name";
		}
		if (criteria.getMaxDateRelease() != null) {
			sql += " AND birthday<:birthday";
		}
		if (criteria.getMinDateRelease() != null) {
			sql += " AND birthday>:birthday";
		}
		if (criteria.getPassengerId() != null) {
			sql += " AND id=:id";
		}
		BeanPropertySqlParameterSource namedParameters = new BeanPropertySqlParameterSource(criteria);
		return namedTemplate.query(sql, namedParameters, rowMapper);
	}

	private PreparedStatementSetter getPreparedStatementSetter(final Passenger2 passenger2) {
		return new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				int i = 0;
				ps.setString(++i, passenger2.getFullName());
				ps.setString(++i, passenger2.getPassport());
				ps.setDate(++i, new java.sql.Date(passenger2.getBirthday().getTime()));
				ps.setInt(++i, passenger2.getId());
			}
		};
	}

}