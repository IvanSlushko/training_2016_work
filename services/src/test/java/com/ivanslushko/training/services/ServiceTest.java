package com.ivanslushko.training.services;

import javax.inject.Inject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.ivanslushko.training.datamodel.City;
//import com.ivanslushko.training.datamodel.Flight;
import com.ivanslushko.training.services.CityService;
//import com.ivanslushko.training.services.FlightService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class ServiceTest {

	@Inject
	private CityService cityService;
	
	@Test
	public void getByIdtestCity() {
		City city = cityService.get(2L);
		Assert.assertNotNull("city 2 should not be null", city);
		Assert.assertEquals(new Long(2), city.getId());
		System.out.println(city.getCity() + " have ID " + city.getId());
	}
	
	
	/*@Inject
	private FlightService flightService;
	@Test
	public void getByIdtestFlight() {
		Flight flight = flightService.get(1L);
		Assert.assertNotNull("flight 1 should not be null", flight);
		Assert.assertEquals(new Long(1), flight.getId());
	}*/
	



}
