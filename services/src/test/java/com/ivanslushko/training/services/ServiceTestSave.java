package com.ivanslushko.training.services;

import java.sql.Date;
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
import com.ivanslushko.training.datamodel.Passenger;
import com.ivanslushko.training.datamodel.Plane;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")

public class ServiceTestSave {

	@Inject
	private CityService cityService;

	// @After
	// @Before
	// @AfterClass
	// @BeforeClass

	@Test
	@Ignore
	public void saveCityTest() {
		City city = new City();
		city.setCity("Test5CITY");
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

	@Inject
	private PlaneService planeService;

	@Test
	@Ignore
	public void savePlaneTest() {
		Plane plane = new Plane();

		plane.setBortNumber("8439720");// unic
		plane.setModel("Boeing 737");
		plane.setPassengerCount(59);

		Long id = planeService.save(plane);

		Assert.assertNotNull(id);
		Plane planeFromDb = planeService.get(id);
		Assert.assertEquals(plane.getBortNumber(), planeFromDb.getBortNumber());

	}

	@Inject
	private PassengerService passengerService;

	@Test
	// @Ignore
	public void savePassengerTest() {
		Passenger passenger = new Passenger();

		passenger.setFullName("Igor Malcev");
		passenger.setBirthday(Date.valueOf("1990-10-30"));
		passenger.setPassport("KH3477361"); //unik

		Long id = passengerService.save(passenger);

		Assert.assertNotNull(id);
		Passenger passengerFromDb = passengerService.get(id);
		Assert.assertEquals(passenger.getFullName(), passengerFromDb.getFullName());

	}

}
