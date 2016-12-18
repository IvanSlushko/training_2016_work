package add;

import java.util.List;
import java.util.Scanner;

import javax.inject.Inject;

import org.junit.Test;
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
public class TicketFullInfo {

	@Inject
	private TicketService ticketService;
	@Inject
	private FlightService flightService;
	@Inject
	private PassengerService passengerService;
	@Inject
	private CityService cityService;
	@Inject
	private PlaneService planeService;

	static Scanner scn;

	@Test
	public void FullInfo() {

		List<Ticket> tickets = ticketService.getAll();
		System.out.println("             All tickets:");
		for (int i = 0; i < tickets.size(); i++) {
			System.out.println(tickets.get(i).getId() + "    " + tickets.get(i));
		}
		try {
			scn = new Scanner(System.in);
			System.out.println("Enter ID of ticket:");
			Long a = (long) Double.parseDouble(scn.next());
			Ticket ticket = ticketService.get(a);
			Passenger passenger = passengerService.get(Integer.toUnsignedLong(ticket.getPassenger()));

			System.out.println("Passenger: " + passenger.getFullName() + ", birthday: " + passenger.getBirthday()
					+ ", passport: " + passenger.getPassport());

			System.out.println("           Ticket class: " + ticket.getClas() + ", price: "
					+ (double) (ticket.getPrice()) / 100 + "$, baggage: " + ticket.getBag()
					+ ", priority boarding and registration: " + ticket.getFirst_reg());

			Flight flight = flightService.get(Integer.toUnsignedLong(ticket.getFlNum()));

			City cityFrom = cityService.get(Integer.toUnsignedLong(flight.getFromm()));

			City cityTo = cityService.get(Integer.toUnsignedLong(flight.getToo()));

			System.out.println("           Departs from: " + cityFrom.getCity_en() + " to " + cityTo.getCity_en()
					+ " at " + flight.getdAndT());

			Plane plane = planeService.get(Integer.toUnsignedLong(flight.getPlane()));

			System.out.println("           Plane : " + plane.getModel() + ", bort number: " + plane.getBortNumber()
					+ ", capacity of persons on board: " + plane.getPassengerCount());

		} catch (Exception e) {
			System.out.println("Incorrect ID!!!");
		}

	}
}
