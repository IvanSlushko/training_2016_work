package com.ivanslushko.training.services;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;

import com.ivanslushko.training.daodb.customentity.FlightFromCity;

public class FlightFromCityTest {

	@Inject
	private FlightService flightService;

	@Test
	public void getByIdTest() {
		FlightFromCity flightFromCity = flightService.getFromCity(1l);

		Assert.assertNotNull(flightFromCity.getCity());
		Assert.assertNotNull(flightFromCity.getFlight());

		
	}

}
