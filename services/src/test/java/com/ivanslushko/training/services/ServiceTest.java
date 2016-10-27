package com.ivanslushko.training.services;

import javax.inject.Inject;

import org.junit.Assert;
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

	@Inject
	private FlightService flightService;

	@Test
	public void getByIdtestFlight() {
		Flight flight = flightService.get(1L);
		Assert.assertNotNull("flight 1 should not be null", flight);
		Assert.assertEquals(new Long(1l), flight.getId());
		System.out.println("samolet " + flight.getPlane() + " letit   " + flight.getdAndT());
	}

	@Inject
	private PassengerService passengerService;

	@Test
	public void getByIdtestPassenger() {
		Passenger passenger = passengerService.get(1L);
		Assert.assertNotNull(" 1 should not be null", passenger);
		Assert.assertEquals(new Long(1l), passenger.getId());
		System.out.println(
				"Passenger with passport " + passenger.getPassport() + " have name " + passenger.getFullName());
	}

	@Inject
	private PlaneService planeService;

	@Test
	public void getByIdtestPlane() {
		Plane plane = planeService.get(1L);
		Assert.assertNotNull("plane 1 should not be null", plane);
		Assert.assertEquals(new Long(1l), plane.getId());
		System.out.println("Plane bort № :" + plane.getBortNumber() + " have model " + plane.getModel() + " capacity : "
				+ plane.getPassengerCount());
	}

	@Inject
	private TicketService ticketService;

	@Test
	public void getByIdtestTicket() {
		Ticket ticket = ticketService.get(2L);
		Assert.assertNotNull("ticket 2 should not be null", ticket);
		Assert.assertEquals(new Long(2l), ticket.getId());
		System.out.println("Ticket  № :" + ticket.getId() + " with passenger " + ticket.getPassenger()
				+ ", have class: " + ticket.getClas() + ", cost: " + ticket.getPrice() + ", bag: " + ticket.getBag());

	}

}