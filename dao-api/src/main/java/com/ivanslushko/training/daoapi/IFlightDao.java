package com.ivanslushko.training.daoapi;

import java.util.List;

import com.ivanslushko.training.datamodel.FlightFromCity;
import com.ivanslushko.training.datamodel.Flight;

public interface IFlightDao extends IAbstractDao<Flight> {

	// Flight get(Long id);
	//
	// Long insert(Flight entity);
	//
	// void update(Flight entity);
	//
	// void save(Flight entity);
	//
	// Flight delete(Long id);
	//
	// List<Flight> getAll();

	List<FlightFromCity> getFromCity(Long id);

}
