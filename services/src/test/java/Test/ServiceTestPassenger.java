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

import com.ivanslushko.training.datamodel.Passenger;
import com.ivanslushko.training.services.PassengerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
@FixMethodOrder

public class ServiceTestPassenger {

	@Inject
	private PassengerService passengerService;

	/**
	 * delete Passenger from Base
	 * 
	 * @param Passenger
	 * @return id
	 */
	@Test
	public void deletePassenger() {
		Passenger passenger = new Passenger();
		passenger.setFullName("Igor Malikov");
		passenger.setBirthday(Date.valueOf("1972-04-01"));
		passenger.setPassport("KH9087765"); // unic
		Long id = passengerService.save(passenger);
		passengerService.delete(id);
		Assert.assertNull(passengerService.get(id));
	}

	/**
	 * insert in Passenger base new Passenger
	 */
	@Test
	public void savePassenger() {
		Passenger passenger = new Passenger();
		passenger.setFullName("Igor Malikov");
		passenger.setBirthday(Date.valueOf("1972-04-01"));
		passenger.setPassport("KH9087765"); // unic
		Long id = passengerService.save(passenger);
		Assert.assertNotNull(id);
		Passenger passengerFromDb = passengerService.get(id);
		Assert.assertEquals(passenger.getFullName(), passengerFromDb.getFullName());
		passengerService.delete(id);
	}

	/**
	 * get from Base 1 Passenger
	 */
	@Test
	public void getPassenger() {
		Passenger passenger = new Passenger();
		passenger.setFullName("Igor Malikov");
		passenger.setBirthday(Date.valueOf("1972-04-01"));
		passenger.setPassport("KH9087765"); // unic
		Long id = passengerService.save(passenger);
		Assert.assertNotNull("Passenger for id should not be null", passenger);
		Assert.assertEquals(new Long(id), passenger.getId());
		passengerService.delete(id);
	}

	/**
	 * get all from Base
	 */
	@Test
	public void getAllPassengers() {
		List<Passenger> passengers = passengerService.getAll();
		Assert.assertNotNull(passengers);
	}

	/**
	 * update Passenger
	 */
	@Test
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
		passengerService.delete(id);
	}
}
