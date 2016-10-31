package com.ivanslushko.training.daodb;

import java.util.List;

import com.ivanslushko.training.daodb.customentity.FlightFromCity;
import com.ivanslushko.training.datamodel.Flight;

public interface FlightDao {

	Flight get(Long id);

	FlightFromCity getFromCity(Long id);

	Long insert(Flight entity);

	void update(Flight entity);

	void delete(Long id);

	List<Flight> getAll();

}
