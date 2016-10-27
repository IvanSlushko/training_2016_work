package com.ivanslushko.training.services.impl;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.ivanslushko.training.daodb.PassengerDao;
import com.ivanslushko.training.datamodel.Passenger;
import com.ivanslushko.training.services.PassengerService;

@Service
public class PassengerServiceImpl implements PassengerService{

	@Inject
	private PassengerDao passengerDao;	
	
	@Override
	public Passenger get(Long id) {
		return passengerDao.get(id);
	}
	
	@Override
	public void saveAll(List<Passenger> passengers) {
		for (Passenger passenger : passengers) {
			save(passenger);
		}
	
	}

	@Override
	public void save(Passenger passenger) {
		if (passenger.getId() == null) {
			passengerDao.insert(passenger);
		} else {
			passengerDao.update(passenger);
		}
	}
}
