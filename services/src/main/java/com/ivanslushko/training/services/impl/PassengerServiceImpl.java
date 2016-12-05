package com.ivanslushko.training.services.impl;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ivanslushko.training.daoapi.IPassengerDao;
import com.ivanslushko.training.datamodel.Passenger;
import com.ivanslushko.training.services.PassengerService;

@Service
public class PassengerServiceImpl implements PassengerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PlaneServiceImpl.class);

	@Inject
	private IPassengerDao passengerDao;

	@Override
	public Passenger get(Long id) {
		return passengerDao.get(id);
	}

	@Override
	public List<Passenger> getAll() {
		return passengerDao.getAll();
	}

	@Override
	public void saveAll(List<Passenger> passengers) {
		for (Passenger passenger : passengers) {
			save(passenger);
		}
	}

	@Override
	public Long save(Passenger passenger) {
		if (passenger.getId() == null) {
			Long id = passengerDao.insert(passenger);
			LOGGER.info("Passenger created. id={}, full_name={}, birthday={}, passport={}", passenger.getId(),
					passenger.getFullName(), passenger.getBirthday(), passenger.getPassport());
			return id;
		} else {
			passengerDao.update(passenger);
			return passenger.getId();
		}
	}

	@Override
	public void delete(Long id) {
		LOGGER.info("Passenger deleted! id={}", id);
		passengerDao.delete(id);
	}

	@Override
	public Long update(Passenger passenger) {
		if (passenger.getId() == null) {
			Long id = passengerDao.update(passenger);
			LOGGER.info("passenger updated. id={}, full_name={}", passenger.getId(), passenger.getFullName());
			return id;
		} else {
			passengerDao.update(passenger);
			return passenger.getId();
		}
	}

	@Override
	public List<Passenger> findByFullName(String fullName) {
		return passengerDao.findByFullName(fullName);
	}

	@Override
	public List<Passenger> findByBirthday(Date birthday) {
		return passengerDao.findByBirthday(birthday);
	}

	@Override
	public List<Passenger> findByPassport(String passport) {
		return passengerDao.findByPassport(passport);
	}
}
