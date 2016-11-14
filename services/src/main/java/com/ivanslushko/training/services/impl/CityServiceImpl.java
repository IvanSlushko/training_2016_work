package com.ivanslushko.training.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ivanslushko.training.daoapi.ICityDao;
import com.ivanslushko.training.datamodel.City;
import com.ivanslushko.training.datamodel.FlightFromCity;
import com.ivanslushko.training.services.CityService;

@Service
public class CityServiceImpl implements CityService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CityServiceImpl.class);

	@Inject
	private ICityDao cityDao;

	@Override
	public City get(Long id) {
		return cityDao.get(id);
	}

	@Override
	public void saveAll(List<City> cities) {
		for (City city : cities) {
			save(city);
		}
	}

	@Override
	public Long save(City city) {
		if (city.getId() == null) {
			Long id = cityDao.insert(city);
			LOGGER.info("City created. id={}, city={}", city.getId(), city.getCity());
			return id;
		} else {
			cityDao.update(city);
			return city.getId();
		}
	}

	@Override
	public Long update(City city) {
		if (city.getId() == null) {
			Long id = cityDao.update(city);
			LOGGER.info("City updated. id={}, city={}", city.getId(), city.getCity());
			return id;
		} else {
			cityDao.update(city);
			return city.getId();
		}
	}

	@Override
	public List<City> getAll() {
		return cityDao.getAll();
	}

	@Override
	public List<FlightFromCity> getFromCity(Long id) {
		return null;
	}

	@Override
	public void delete(Long id) {
		LOGGER.info("City deleted!!! id={}", id);
		cityDao.delete(id);
	}
}
