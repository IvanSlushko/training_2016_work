package com.ivanslushko.training.daodb;

import java.util.List;

import com.ivanslushko.training.datamodel.Passenger2;

public interface PassengerDao2 {

	void insert(Passenger2 passenger2);

	void update(Passenger2 passenger2);

	void delete(Passenger2 passenger2);

	Passenger2 getById(Integer id);

	List<Passenger2> getAll();

	List<Passenger2> findByCriteria(PassengerSearchCriteria criteria);

}