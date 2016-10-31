package com.ivanslushko.training.services;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ivanslushko.training.daodb.customentity.FlightFromCity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class FlightFromCityTest {

	@Inject
	private FlightService flightService;

	@Test
	public void getByIdTest() {

		FlightFromCity flightFromCity = flightService.getFromCity(4l);

		Assert.assertNotNull(flightFromCity.getCity());
		Assert.assertNotNull(flightFromCity.getFlight());

		System.out.println(flightFromCity.getFlight());
		System.out.println(flightFromCity.getCity());
	}

	
	
/*	@Test(expected = IllegalArgumentException.class)
	public void getByInvalidIdTest() {
		flightService.get(-1l);
	}*/
}
