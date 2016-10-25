package com.ivanslushko.training.daodb;

import java.util.List;
import com.ivanslushko.training.datamodel.Flight;

public interface FlightDao {

	Flight get(Long id);

	void insert(Flight entity);

	void update(Flight entity);

	void delete(Long id);

	List<Flight> getAll();

}
