package com.ivanslushko.training.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ivanslushko.training.daodb.customentity.FlightFromCity;
import com.ivanslushko.training.datamodel.Flight;

public interface FlightService {
	
	FlightFromCity getFromCity(Long id);

	@Transactional
	void saveAll(List<Flight> flights);

	// void save(Flight flight);

	Long save(Flight flight);

	Flight get(Long id);

}