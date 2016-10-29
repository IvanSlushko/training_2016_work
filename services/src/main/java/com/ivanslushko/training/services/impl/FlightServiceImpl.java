package com.ivanslushko.training.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ivanslushko.training.daodb.FlightDao;
import com.ivanslushko.training.daodb.customentity.FlightFromCity;
import com.ivanslushko.training.datamodel.Flight;
import com.ivanslushko.training.services.FlightService;

@Service
public class FlightServiceImpl implements FlightService {

	@Inject
	private FlightDao flightDao;

	@Override
	public Flight get(Long id) {
		return flightDao.get(id);
	}

	@Override
	public void saveAll(List<Flight> flights) {
		for (Flight flight : flights) {
			save(flight);
		}
	}

	@Override
	public Long save(Flight flight) {
		
		if (flight.getId() == null) {
			return flightDao.insert(flight);
		} else {
			flightDao.update(flight);
			 return flight.getId();
		}
	}

	@Inject
	private FlightDao dao;

	@Override
	public FlightFromCity getFromCity(Long id) {
		return dao.getFromCity(id);
	}

}
