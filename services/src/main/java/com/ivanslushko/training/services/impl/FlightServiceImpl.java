package com.ivanslushko.training.services.impl;

import java.util.List;
import javax.inject.Inject;
import com.ivanslushko.training.datamodel.Flight;
import com.ivanslushko.training.services.FlightService;
import com.ivanslushko.training.daodb.FlightDao;

public class FlightServiceImpl implements FlightService {

	@Inject
	private FlightDao flightDao;

	@Override
	public Flight get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveAll(List<Flight> flights) {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(Flight flight) {
		if (flight.getId() == null) {
			flightDao.insert(flight);
		} else {
			flightDao.update(flight);
		}

	}

}
