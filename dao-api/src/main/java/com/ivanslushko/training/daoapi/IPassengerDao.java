package com.ivanslushko.training.daoapi;

import java.util.Date;
import java.util.List;

import com.ivanslushko.training.datamodel.Passenger;

public interface IPassengerDao extends IAbstractDao<Passenger> {

	List<Passenger> findByFullName(String fullName);

	List<Passenger> findByBirthday(Date birthday);

	List<Passenger> findByPassport(String passport);
}
