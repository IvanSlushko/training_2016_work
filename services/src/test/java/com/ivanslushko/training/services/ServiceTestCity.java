package com.ivanslushko.training.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ivanslushko.training.datamodel.City;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
@FixMethodOrder

public class ServiceTestCity {

	@Inject
	private CityService cityService;

	/**
	 * delete City from Base
	 * 
	 * @param City
	 * @return id
	 */
	@Test
	public void deleteCity() {
		City city = new City();
		city.setCity("TestCityDel");
		Long id = cityService.save(city);
		cityService.delete(id);
		Assert.assertNull(cityService.get(id));
	}

	/**
	 * insert in City base new City
	 */
	@Test
	
	public void saveCity() {
		City city = new City();
		city.setCity("TestCitySave");
		Long id = cityService.save(city);
		Assert.assertNotNull(id);// check that ID isn't null
		City cityFromDb = cityService.get(id);
		Assert.assertEquals(city.getCity(), cityFromDb.getCity());
		cityService.delete(id);
	}

	/**
	 * insert 3 City in base
	 */
	@Test
	public void saveCityMultiple() {
		List<City> allCityes = new ArrayList<>();
		// List<Long> ids = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			City city = new City();
			city.setCity("City" + i);
			allCityes.add(city);
		}
		cityService.saveAll(allCityes);
		Assert.assertNotNull(allCityes);
		// if (allCityes.size() > 0) {
		// for (Long id: allCityes) {
		// cityService.delete(id);
		// }
		// }

	}

	/**
	 * get from Base 1 City
	 */
	@Test
	public void getCity() {
		City city = new City();
		city.setCity("TestCityLong");
		Long id = cityService.save(city);
		Assert.assertNotNull("City for id should not be null", city);
		Assert.assertEquals(new Long(id), city.getId());
		cityService.delete(id);
	}

	/**
	 * get all from Base
	 */
	@Test
	public void getAllCity() {
		List<City> cities = cityService.getAll();
		Assert.assertNotNull(cities);
	}

	/**
	 * update City
	 */
	@Test
	public void UpdateCity() {
		City city = new City();
		city.setCity("TestCityUpd");
		Long id = cityService.save(city);
		Assert.assertNotNull(id);
		city.setCity("TestCityUpdated");
		cityService.update(city);
		City cityFromDb = cityService.get(id);
		Assert.assertEquals(city.getCity(), cityFromDb.getCity());
		cityService.delete(id);
	}
}
