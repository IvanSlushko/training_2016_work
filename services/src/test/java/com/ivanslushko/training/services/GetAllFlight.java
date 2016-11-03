package com.ivanslushko.training.services;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")

public class GetAllFlight {

	@Inject
	private FlightService flightService;

	@Test
	public void get123() {

		Assert.assertNotNull(flightService.get(1l));
		System.out.println(flightService.hashCode());

	}
}
