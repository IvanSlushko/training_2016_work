package com.ivanslushko.training.services;

import java.util.List;

import com.ivanslushko.training.daodb.customentity.FlightFromCity;
import com.ivanslushko.training.datamodel.Flight;

public interface FlightService extends AbstractService<Flight>{

	// @Transactional
	// void saveAll(List<Flight> flights);
	//
	// Long save(Flight flight);
	//
	// Long update(Flight flight);
	//
	// Flight get(Long id);
	//
	// Flight delete(Long id);
	//
	// List<Flight> getAll();

	List<FlightFromCity> getFromCity(Long id);

}