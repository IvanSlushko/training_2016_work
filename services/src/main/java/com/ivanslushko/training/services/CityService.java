package com.ivanslushko.training.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ivanslushko.training.daodb.customentity.FlightFromCity;
import com.ivanslushko.training.datamodel.City;

public interface CityService {

	@Transactional
	void saveAll(List<City> cities);

	Long save(City city);

	City get(Long id);

	FlightFromCity getFromCity(Long id);
}
