package com.ivanslushko.training.services;

import javax.inject.Inject;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")

public class ServiceDelById {

	@Inject
	private CityService cityService;

	public void delCityTest() {
		cityService.delete(8L);
	}

	@Inject
	private FlightService flightService;

	public void delFlightTest() {
		flightService.delete(5L);
	}

	@Inject
	private PassengerService passengerService;

	public void delPassengerTest() {
		passengerService.delete(6L);
	}

	@Inject
	private PlaneService planeService;

	public void delPlaneTest() {
		planeService.delete(4L);
	}

	@Inject
	private TicketService ticketService;

	public void delTicketTest() {
		ticketService.delete(9L);
	}
}
