package com.ivanslushko.training.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ivanslushko.training.daoapi.IFlightDao;
import com.ivanslushko.training.datamodel.Flight;
import com.ivanslushko.training.datamodel.FlightFromCity;
import com.ivanslushko.training.services.FlightService;

@Service
public class FlightServiceImpl implements FlightService {

	private static final Logger LOGGER = LoggerFactory.getLogger(FlightServiceImpl.class);

	@Inject
	private IFlightDao flightDao;

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
			Long id = flightDao.insert(flight);
			LOGGER.info("Flight created. id={}, plane={}, from={}, dateAndTime={}, to={}", flight.getId(),
					flight.getPlane(), flight.getFromm(), flight.getdAndT(), flight.getToo());
			return id;
		} else {
			flightDao.update(flight);
			return flight.getId();
		}
	}


	@Override
	public List<FlightFromCity> getFromCity(Long id) {
		return flightDao.getFromCity(id);
	}

	@Override
	public List<Flight> getAll() {
		return flightDao.getAll();
	}

	@Override
	public void delete(Long id) {
		LOGGER.info("Flight deleted! id={}", id);
		 flightDao.delete(id);
		
	}

	@Override
	public Long update(Flight flight) {
		if (flight.getId() == null) {
			Long id = flightDao.update(flight);
			LOGGER.info("Flight updated. id={}, plane={}", flight.getId(), flight.getPlane());
			System.out.println("!!!!!!!!!!!!");
			return id;
		} else {
			flightDao.update(flight);
			return flight.getId();
		}
	}
}
