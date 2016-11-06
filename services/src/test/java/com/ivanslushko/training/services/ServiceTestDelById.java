package com.ivanslushko.training.services;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")

public class ServiceTestDelById {

	@Inject
	private CityService cityService;

	@Test
	@Ignore
	public void delCityTest() {
		cityService.delete(8L);
	}

	@Inject
	private FlightService flightService;

	@Test
	@Ignore
	public void delFlightTest() {
		flightService.delete(5L);
	}

	@Inject
	private PassengerService passengerService;

	@Test
	@Ignore
	public void delPassengerTest() {
		passengerService.delete(6L);
	}

	@Inject
	private PlaneService planeService;

	@Test
	@Ignore
	public void delPlaneTest() {
		planeService.delete(4L);
	}

	@Inject
	private TicketService ticketService;

	@Test
	@Ignore
	public void delTicketTest() {
		ticketService.delete(10L);
	}

}
