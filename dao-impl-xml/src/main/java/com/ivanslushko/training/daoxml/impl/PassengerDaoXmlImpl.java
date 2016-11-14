package com.ivanslushko.training.daoxml.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ivanslushko.training.daoapi.IPassengerDao;
import com.ivanslushko.training.datamodel.Passenger;

@Repository
public class PassengerDaoXmlImpl implements IPassengerDao {


	@Override
	public Passenger get(Long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Long insert(final Passenger entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Long update(final Passenger entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(Long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Passenger> getAll() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void save(Passenger entity) {
		throw new UnsupportedOperationException();
	}

}
