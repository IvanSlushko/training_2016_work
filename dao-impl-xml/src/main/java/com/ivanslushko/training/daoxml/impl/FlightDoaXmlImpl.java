package com.ivanslushko.training.daoxml.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ivanslushko.training.daoapi.IFlightDao;
import com.ivanslushko.training.datamodel.Flight;
import com.ivanslushko.training.datamodel.FlightFromCity;

@Repository
public class FlightDoaXmlImpl implements IFlightDao {

	@Override
	public Flight get(Long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Long insert(final Flight entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Long update(final Flight entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(Long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Flight> getAll() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void save(Flight entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<FlightFromCity> getFromCity(Long id) {
		throw new UnsupportedOperationException();

	}
}
