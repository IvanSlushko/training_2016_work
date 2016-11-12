package com.ivanslushko.training.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.FixMethodOrder;
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
@FixMethodOrder
public class ServiceSave {

	@Inject
	private CityService cityService;

	// @After
	// @Before
	// @AfterClass
	// @BeforeClass


	public void saveCityTest() {
		City city = new City();
		city.setCity("TestCITY");
		Long id = cityService.save(city);
		Assert.assertNotNull(id);
		City cityFromDb = cityService.get(id);
		System.out.println(id);
		Assert.assertEquals(city.getCity(), cityFromDb.getCity());
	}


	public void saveCityMultipleTest() {
		List<City> allCityes = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			City city = new City();
			city.setCity("City" + i);
			allCityes.add(city);
		}
		cityService.saveAll(allCityes);
	}

	@Inject
	private PlaneService planeService;


	public void savePlaneTest() {
		Plane plane = new Plane();

		plane.setBortNumber("9086723");// unic
		plane.setModel("Boeing 707");
		plane.setPassengerCount(88);

		Long id = planeService.save(plane);

		Assert.assertNotNull(id);
		Plane planeFromDb = planeService.get(id);
		Assert.assertEquals(plane.getBortNumber(), planeFromDb.getBortNumber());

	}

	@Inject
	private PassengerService passengerService;


	public void savePassengerTest() {
		Passenger passenger = new Passenger();

		passenger.setFullName("Igor Malikov");
		passenger.setBirthday(Date.valueOf("1972-04-01"));
		passenger.setPassport("KH9087765"); // unic

		Long id = passengerService.save(passenger);

		Assert.assertNotNull(id);
		Passenger passengerFromDb = passengerService.get(id);
		Assert.assertEquals(passenger.getFullName(), passengerFromDb.getFullName());

	}

	@Inject
	private TicketService ticketService;

	
	public void saveTicketTest() {
		Ticket ticket = new Ticket();

		ticket.setFlNum(1);
		ticket.setPassenger(5);//
		ticket.setClas(2);
		ticket.setPrice(3);
		ticket.setBag(false);

		Long id = ticketService.save(ticket);
		Assert.assertNotNull(id);
		Ticket ticketFromDb = ticketService.get(id);
		Assert.assertEquals(ticket.getFlNum(), ticketFromDb.getFlNum());
	}

	@Inject
	private FlightService flightService;

	
	public void saveFlightTest() {
		Flight flight = new Flight();

		flight.setPlane(2);
		flight.setFromm(3);
		flight.setdAndT(Date.valueOf("2016-10-30"));
		flight.setToo(2);

		Long id = flightService.save(flight);

		Assert.assertNotNull(id);
		Flight flightFromDb = flightService.get(id);
		Assert.assertEquals(flight.getPlane(), flightFromDb.getPlane());

	}
}
