package com.ivanslushko.training.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ivanslushko.training.datamodel.Passenger;

public interface PassengerService {

	@Transactional
	void saveAll(List<Passenger> passengers);

	Long save(Passenger passenger);
	
	Passenger delete(Long id);

	Passenger get(Long id);

	List<Passenger> getAll();
}
