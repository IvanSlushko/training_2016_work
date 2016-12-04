package com.ivanslushko.training.services;

import java.util.List;

import com.ivanslushko.training.datamodel.ActualFlights;
import com.ivanslushko.training.datamodel.Flight;
import com.ivanslushko.training.datamodel.FlightFromCity;

public interface FlightService extends AbstractService<Flight>{

	List<FlightFromCity> getFromCity(Long id);
	
	List<ActualFlights> actualFlights();

}