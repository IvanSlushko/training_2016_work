package com.ivanslushko.training.daodb;

import java.util.List;

import com.ivanslushko.training.datamodel.Passenger;

public interface PassengerDao {

	Passenger get(Long id);

	Long insert(Passenger entity);

	void update(Passenger entity);

	void save(Passenger entity);

	void delete(Long id);

	List<Passenger> getAll();
}
