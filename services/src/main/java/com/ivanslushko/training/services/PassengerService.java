package com.ivanslushko.training.services;

import java.util.List;
import com.ivanslushko.training.datamodel.Passenger;

public interface PassengerService {

	void saveAll(List<Passenger> passengers);

	void save(Passenger passenger);

	Passenger get(Long id);	

}
