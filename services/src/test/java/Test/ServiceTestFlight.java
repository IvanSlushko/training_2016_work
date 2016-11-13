package Test;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ivanslushko.training.datamodel.Flight;
import com.ivanslushko.training.services.FlightService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
@FixMethodOrder

public class ServiceTestFlight {

	@Inject
	private FlightService flightService;

	/**
	 * delete Flight from Base
	 * 
	 * @param Flight
	 * @return id
	 */
	@Test
	public void deleteFlight() {
		Flight flight = new Flight();
		flight.setPlane(2);
		flight.setFromm(3);
		flight.setdAndT(Date.valueOf("2016-10-30"));
		flight.setToo(2);
		Long id = flightService.save(flight);
		flightService.delete(id);
		Assert.assertNull(flightService.get(id));
	}

	/**
	 * insert in Flight base new Flight
	 */
	@Test
	public void saveFlight() {
		Flight flight = new Flight();
		flight.setPlane(2);
		flight.setFromm(3);
		flight.setdAndT(Date.valueOf("2016-10-30"));
		flight.setToo(2);
		Long id = flightService.save(flight);
		Assert.assertNotNull(id);
		Flight flightFromDb = flightService.get(id);
		Assert.assertEquals(flight.getPlane(), flightFromDb.getPlane());
		flightService.delete(id);
	}

	/**
	 * get from Base 1 flight
	 */
	@Test
	public void getFlight() {
		Flight flight = new Flight();
		flight.setPlane(2);
		flight.setFromm(3);
		flight.setdAndT(Date.valueOf("2016-10-30"));
		flight.setToo(2);
		Long id = flightService.save(flight);
		Assert.assertNotNull("Flight for id should not be null", flight);
		Assert.assertEquals(new Long(id), flight.getId());
		flightService.delete(id);
	}

	/**
	 * get all from Base
	 */
	@Test
	public void getAllFlight() {
		List<Flight> flights = flightService.getAll();
		Assert.assertNotNull(flights);
	}

	/**
	 * update Flight
	 */
	@Test
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
		flightService.delete(id);
	}
}
