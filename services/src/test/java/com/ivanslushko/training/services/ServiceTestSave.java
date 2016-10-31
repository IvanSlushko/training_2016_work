package com.ivanslushko.training.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ivanslushko.training.datamodel.City;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")

public class ServiceTestSave {

	@Inject
	private CityService cityService;

//	@After
//	@Before
//	@AfterClass
//	@BeforeClass	
	
	@Test
	//@Ignore
	public void saveCityTest() {
		City city = new City();
		city.setCity("Test55CITY");
		Long id = cityService.save(city);
		Assert.assertNotNull(id);
		City cityFromDb = cityService.get(id);
		Assert.assertEquals(city.getCity(), cityFromDb.getCity());
	}

	@Test
	@Ignore
	public void saveCityMultipleTest() {
		List<City> allCityes = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			City city = new City();
			city.setCity("test33" + i);
			allCityes.add(city);
		}
		cityService.saveAll(allCityes);
	}

}
