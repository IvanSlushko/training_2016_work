package temp_services;

import java.sql.Date;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ivanslushko.training.datamodel.City;
import com.ivanslushko.training.datamodel.Flight;
import com.ivanslushko.training.datamodel.Passenger;
import com.ivanslushko.training.datamodel.Plane;
import com.ivanslushko.training.datamodel.Ticket;
import com.ivanslushko.training.services.CityService;
import com.ivanslushko.training.services.FlightService;
import com.ivanslushko.training.services.PassengerService;
import com.ivanslushko.training.services.PlaneService;
import com.ivanslushko.training.services.TicketService;
import com.ivanslushko.training.services.impl.CityServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
@FixMethodOrder
public class ServiceUpdate {
	private static final Logger LOGGER = LoggerFactory.getLogger(CityServiceImpl.class);

	@Inject
	private CityService cityService;

	@Test
	@Ignore
	public void UpdateCity() {
		City city = new City();
		city.setCity("TestCityUpd");
		Long id = cityService.save(city);
		Assert.assertNotNull(id);
		city.setCity("TestCityUpdated");
		cityService.update(city);
		City cityFromDb = cityService.get(id);
		Assert.assertEquals(city.getCity(), cityFromDb.getCity());
		LOGGER.info("City updated. id={}, city={}", city.getId(), city.getCity());
		cityService.delete(id);
	}

	@Inject
	private FlightService flightService;

	@Test
	@Ignore
	public void UpdateFlight() {
		Flight flight = new Flight();
		flight.setPlane(1);
		flight.setFromm(1);
		flight.setdAndT(Date.valueOf("2222-02-02"));
		flight.setToo(2);
		Long id = flightService.save(flight);
		Assert.assertNotNull(id);
		flight.setPlane(2);
		flight.setFromm(2);
		flight.setdAndT(Date.valueOf("3333-03-03"));
		flight.setToo(3);
		flightService.update(flight);
		Flight flightFromDb = flightService.get(id);
		Assert.assertEquals(flight.getPlane(), flightFromDb.getPlane());
		Assert.assertEquals(flight.getFromm(), flightFromDb.getFromm());
		Assert.assertEquals(flight.getdAndT(), flightFromDb.getdAndT());
		Assert.assertEquals(flight.getToo(), flightFromDb.getToo());
		LOGGER.info("Flight updated. id={}, plane={}", flight.getId(), flight.getPlane());
		flightService.delete(id);
	}

	@Inject
	private TicketService ticketService;

	@Test
	@Ignore
	public void UpdateTicket() {
		Ticket ticket = new Ticket();
		ticket.setFlNum(1);
		ticket.setPassenger(1);
		ticket.setClas(1);
		ticket.setPrice(3);
		ticket.setBag(true);
		Long id = ticketService.save(ticket);
		Assert.assertNotNull(id);
		ticket.setFlNum(2);
		ticket.setPassenger(2);
		ticket.setClas(2);
		ticket.setPrice(2);
		ticket.setBag(false);
		ticketService.update(ticket);
		Ticket ticketFromDb = ticketService.get(id);
		Assert.assertEquals(ticket.getFlNum(), ticketFromDb.getFlNum());
		Assert.assertEquals(ticket.getPassenger(), ticketFromDb.getPassenger());
		Assert.assertEquals(ticket.getClas(), ticketFromDb.getClas());
		Assert.assertEquals(ticket.getPrice(), ticketFromDb.getPrice());
		Assert.assertEquals(ticket.getBag(), ticketFromDb.getBag());
		LOGGER.info("Ticket updated. id={}, passenger={}", ticket.getId(), ticket.getPassenger());
		ticketService.delete(id);
	}

	@Inject
	private PassengerService passengerService;

	@Test
	@Ignore
	public void UpdatePassenger() {
		Passenger passenger = new Passenger();
		passenger.setFullName("Test Name");
		passenger.setBirthday(Date.valueOf("2222-02-02"));
		passenger.setPassport("KH1111111");
		Long id = passengerService.save(passenger);
		Assert.assertNotNull(id);
		passenger.setFullName("NEW Name");
		passenger.setBirthday(Date.valueOf("3333-03-03"));
		passenger.setPassport("KH2222222");
		passengerService.update(passenger);
		Passenger passengerFromDb = passengerService.get(id);
		Assert.assertEquals(passenger.getFullName(), passengerFromDb.getFullName());
		Assert.assertEquals(passenger.getBirthday(), passengerFromDb.getBirthday());
		Assert.assertEquals(passenger.getPassport(), passengerFromDb.getPassport());
		LOGGER.info("Passenger updated. id={}, full_name={}", passenger.getId(), passenger.getFullName());
		passengerService.delete(id);
	}

	@Inject
	private PlaneService planeService;

	@Test
	@Ignore
	public void UpdatePlane() {
		Plane plane = new Plane();
		plane.setBortNumber("1111");
		plane.setModel("Boeing 1");
		plane.setPassengerCount(55);
		Long id = planeService.save(plane);
		Assert.assertNotNull(id);
		plane.setBortNumber("2222");
		plane.setModel("Boeing 2");
		plane.setPassengerCount(66);
		planeService.update(plane);
		Plane planeFromDb = planeService.get(id);
		Assert.assertEquals(plane.getBortNumber(), planeFromDb.getBortNumber());
		Assert.assertEquals(plane.getModel(), planeFromDb.getModel());
		Assert.assertEquals(plane.getPassengerCount(), planeFromDb.getPassengerCount());
		LOGGER.info("Plane updated. id={}, model={}", plane.getId(), plane.getModel());
		planeService.delete(id);
	}
}
