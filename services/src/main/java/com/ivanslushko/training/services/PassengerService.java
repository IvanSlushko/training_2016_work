package com.ivanslushko.training.services;

import java.util.Date;
import java.util.List;

import com.ivanslushko.training.datamodel.Passenger;

public interface PassengerService extends AbstractService<Passenger> {

	List<Passenger> findByFullName(String fullName);

	List<Passenger> findByBirthday(Date birthday);

	List<Passenger> findByPassport(String passport);

}
