package com.ivanslushko.training.services;

import java.util.List;
import com.ivanslushko.training.datamodel.Flight;

public interface FlightService {
	
	void saveAll(List<Flight> flights);

	void save(Flight flight);

	Flight get(Long id);
}