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
		city.setCity_ru("TestCityDelRu");
		city.setCity_en("TestCityDelEn");
		city.setCity_by("TestCityDelBy");
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
		city.setCity_ru("TestCityRu");
		city.setCity_en("TestCityEn");
		city.setCity_by("TestCityBy");
		Long id = cityService.save(city);
		Assert.assertNotNull(id);// check that ID isn't null
		City cityFromDb = cityService.get(id);
		Assert.assertEquals(city.getCity_ru(), cityFromDb.getCity_ru());
		Assert.assertEquals(city.getCity_en(), cityFromDb.getCity_en());
		Assert.assertEquals(city.getCity_by(), cityFromDb.getCity_by());
		cityService.delete(id);
	}

	/**
	 * insert 3 City in base
	 */
	@Test
	public void saveCityMultiple() {
		List<City> allCityes = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			City city = new City();
			city.setCity_ru("City_ru" + i);
			city.setCity_en("City_en" + i);
			city.setCity_by("City_by" + i);
			allCityes.add(city);
		}
		cityService.saveAll(allCityes);
		Assert.assertNotNull(allCityes);
	}

	/**
	 * get from Base 1 City
	 */
	@Test
	public void getCity() {
		City city = new City();
		city.setCity_ru("TestCityLongRu");
		city.setCity_en("TestCityLongEn");
		city.setCity_by("TestCityLongBy");
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
		city.setCity_ru("TestCityUpdRu");
		city.setCity_en("TestCityUpdEn");
		city.setCity_by("TestCityUpdBy");
		Long id = cityService.save(city);
		Assert.assertNotNull(id);
		city.setCity_ru("TestCityUpdatedRu");
		city.setCity_en("TestCityUpdatedEn");
		city.setCity_by("TestCityUpdatedBy");
		cityService.update(city);
		City cityFromDb = cityService.get(id);
		Assert.assertEquals(city.getCity_ru(), cityFromDb.getCity_ru());
		Assert.assertEquals(city.getCity_en(), cityFromDb.getCity_en());
		Assert.assertEquals(city.getCity_by(), cityFromDb.getCity_by());
		cityService.delete(id);
	}
}
