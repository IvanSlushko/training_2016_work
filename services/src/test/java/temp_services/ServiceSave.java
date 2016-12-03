package temp_services;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
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
		city.setCity_ru("TestCITY_ru");
		city.setCity_en("TestCITY_en");
		city.setCity_by("TestCITY_by");
		Long id = cityService.save(city);
		Assert.assertNotNull(id);
		City cityFromDb = cityService.get(id);
		System.out.println(id);
		Assert.assertEquals(city.getCity_ru(), cityFromDb.getCity_ru());
		Assert.assertEquals(city.getCity_en(), cityFromDb.getCity_en());
		Assert.assertEquals(city.getCity_by(), cityFromDb.getCity_by());
	}

	public void saveCityMultipleTest() {
		List<City> allCityes = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			City city = new City();
			city.setCity_ru("City_ru" + i);
			city.setCity_en("City_en" + i);
			city.setCity_by("City_by" + i);
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
		ticket.setPrice((int) (3.13 * 100));
		ticket.setBag(false);
		ticket.setFirst_reg(false);

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
		flight.setdAndT(Timestamp.valueOf("2016-10-30 12:58:20"));
		flight.setToo(2);

		Long id = flightService.save(flight);

		Assert.assertNotNull(id);
		Flight flightFromDb = flightService.get(id);
		Assert.assertEquals(flight.getPlane(), flightFromDb.getPlane());

	}
}
