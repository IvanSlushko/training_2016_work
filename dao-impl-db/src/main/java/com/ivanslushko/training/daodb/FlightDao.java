package com.ivanslushko.training.daodb;

import java.util.List;

import com.ivanslushko.training.daodb.customentity.FlightFromCity;
import com.ivanslushko.training.datamodel.Flight;

public interface FlightDao extends AbstractDao<Flight>{

//	Flight get(Long id);
//
//	Long insert(Flight entity);
//
//	void update(Flight entity);
//
//	void save(Flight entity);
//
//	Flight delete(Long id);
//
//	List<Flight> getAll();

	List<FlightFromCity> getFromCity(Long id);

}
