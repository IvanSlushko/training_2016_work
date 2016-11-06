package com.ivanslushko.training.services;

import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ivanslushko.training.datamodel.City;
import com.ivanslushko.training.datamodel.Flight;
import com.ivanslushko.training.datamodel.Passenger;
import com.ivanslushko.training.datamodel.Plane;
import com.ivanslushko.training.datamodel.Ticket;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")

public class ServiceTestGetAll {

	@Inject
	private FlightService flightService;

	@Test
	@Ignore
	public void getAllFlight() {

		List<Flight> flights = flightService.getAll();
		Assert.assertNotNull(flights);
		for (int i = 0; i < flights.size(); i++) {
			System.out.println(flights.get(i));
		}
	}

	@Inject
	private CityService cityService;

	@Test
	@Ignore
	public void getAllCity() {

		List<City> cityes = cityService.getAll();
		Assert.assertNotNull(cityes);
		for (int i = 0; i < cityes.size(); i++) {
			System.out.println(cityes.get(i));
		}
	}

	@Inject
	private PassengerService passengerService;

	@Test
	@Ignore
	public void getAllPassenger() {

		List<Passenger> passengers = passengerService.getAll();
		Assert.assertNotNull(passengers);
		for (int i = 0; i < passengers.size(); i++) {
			System.out.println(passengers.get(i));
		}
	}

	@Inject
	private PlaneService planeService;

	@Test
	@Ignore
	public void getAllPlane() {

		List<Plane> planes = planeService.getAll();
		Assert.assertNotNull(planes);
		for (int i = 0; i < planes.size(); i++) {
			System.out.println(planes.get(i));
		}
	}

	@Inject
	private TicketService ticketService;

	@Test
	@Ignore
	public void getAllTicket() {

		List<Ticket> tickets = ticketService.getAll();
		Assert.assertNotNull(tickets);
		for (int i = 0; i < tickets.size(); i++) {
			System.out.println(tickets.get(i));
		}
	}

}
