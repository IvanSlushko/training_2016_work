package com.ivanslushko.training.services;

import java.util.List;

import com.ivanslushko.training.daodb.customentity.FlightFromCity;
import com.ivanslushko.training.datamodel.City;

public interface CityService extends AbstractService<City>{

//	@Transactional
//	void saveAll(List<City> cities);
//
//	Long save(City city);
//
//	Long update(City city);
//
//	City get(Long id);
//
//	City delete(Long id);
//
//	List<City> getAll();

	List<FlightFromCity> getFromCity(Long id);

}
