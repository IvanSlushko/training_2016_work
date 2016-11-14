package temp_services;

import javax.inject.Inject;

import org.junit.Assert;
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

public class ServiceGetById {

	private static final Logger LOGGER = LoggerFactory.getLogger(CityServiceImpl.class);

	@Inject
	private CityService cityService;

	public void getByIdtestCity() {
		City city = cityService.get(3L);
		Assert.assertNotNull("city 3 should not be null", city);
		Assert.assertEquals(new Long(3), city.getId());
		LOGGER.info("City get: id={}, title={}", city.getId(), city.getCity());
	}

	@Inject
	private FlightService flightService;

	public void getByIdtestFlight() {
		Flight flight = flightService.get(3L);
		Assert.assertNotNull("flight 1 should not be null", flight);
		Assert.assertEquals(new Long(3l), flight.getId());
		LOGGER.info("Flight get: . id={}, plane={}, from={}, date={},to={}", flight.getId(), flight.getPlane(),
				flight.getFromm(), flight.getdAndT(), flight.getToo());

	}

	@Inject
	private PassengerService passengerService;

	public void getByIdtestPassenger() {
		Passenger passenger = passengerService.get(1L);
		Assert.assertNotNull(" 1 should not be null", passenger);
		Assert.assertEquals(new Long(1l), passenger.getId());
		LOGGER.info("Passenger get: id={}, fullName={}, birthday={}, passport={}", passenger.getId(),
				passenger.getFullName(), passenger.getBirthday(), passenger.getPassport());
	}

	@Inject
	private PlaneService planeService;

	public void getByIdtestPlane() {
		Plane plane = planeService.get(1L);
		Assert.assertNotNull("plane 1 should not be null", plane);
		Assert.assertEquals(new Long(1l), plane.getId());
		LOGGER.info("Plane get: id={}, bortNumber={}, model={}, passengerCount={}", plane.getId(),
				plane.getBortNumber(), plane.getModel(), plane.getPassengerCount());
	}

	@Inject
	private TicketService ticketService;

	public void getByIdtestTicket() {
		Ticket ticket = ticketService.get(4L);
		Assert.assertNotNull("ticket 1 should not be null", ticket);
		Assert.assertEquals(new Long(4l), ticket.getId());
		LOGGER.info("Ticket get: id={}, flightNumber={}, passenger={}, clas={},price={}, bag={}", ticket.getId(),
				ticket.getFlNum(), ticket.getPassenger(), ticket.getClas(), ticket.getPrice(), ticket.getBag());

	}

}
