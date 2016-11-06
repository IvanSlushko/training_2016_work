package com.ivanslushko.training.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ivanslushko.training.daodb.customentity.FlightFromCity;
import com.ivanslushko.training.datamodel.City;
import com.ivanslushko.training.datamodel.Flight;

public interface FlightService {

	@Transactional
	void saveAll(List<Flight> flights);

	Long save(Flight flight);

	Flight get(Long id);
	
	Flight delete(Long id);

	List<Flight> getAll();

	List<FlightFromCity> getFromCity(Long id);

}