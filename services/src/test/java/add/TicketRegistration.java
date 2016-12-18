package add;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ivanslushko.training.datamodel.ActualFlights;
import com.ivanslushko.training.datamodel.City;
import com.ivanslushko.training.datamodel.Flight;
import com.ivanslushko.training.datamodel.Passenger;
import com.ivanslushko.training.datamodel.Plane;
import com.ivanslushko.training.datamodel.Ticket;
import com.ivanslushko.training.datamodel.TicketOnFlight;
import com.ivanslushko.training.services.CityService;
import com.ivanslushko.training.services.FlightService;
import com.ivanslushko.training.services.PassengerService;
import com.ivanslushko.training.services.PlaneService;
import com.ivanslushko.training.services.TicketService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class TicketRegistration {

	@Inject
	private TicketService ticketService;
	@Inject
	private FlightService flightService;
	@Inject
	private CityService cityService;
	@Inject
	private PlaneService planeService;
	@Inject
	private PassengerService passengerService;

	static Scanner scn;

	@Test
	public void Registration() {

		/**
		 * starting price parameters to flight
		 */

		Double price = null;// start price
		Double priceBag = 6.40;// baggage
		Double priceFirstReg = 1.25;// first registration
		Double priceClass = 1.50; // 1 class

		/**
		 * show all actual flights
		 */
		List<ActualFlights> actualFlights = flightService.actualFlights();
		System.out.println("        ActualFlights:");
		List<Long> ids = new ArrayList<Long>();

		for (int i = 0; i < actualFlights.size(); i++) {
			City cityFr = cityService.get(Integer.toUnsignedLong((Integer) actualFlights.get(i).getFromm()));
			City cityTo = cityService.get(Integer.toUnsignedLong((Integer) actualFlights.get(i).getToo()));
			Plane planePassCount = planeService.get(Integer.toUnsignedLong((Integer) actualFlights.get(i).getPlane()));
			List<TicketOnFlight> ticketOnFlight = ticketService.ticketOnFlight(actualFlights.get(i).getId());

			if (ticketOnFlight.size() < planePassCount.getPassengerCount()) {
				System.out.println("->   ID:" + actualFlights.get(i).getId() + "   From " + cityFr.getCity_en() + " to "
						+ cityTo.getCity_en() + " at " + actualFlights.get(i).getdAndT() + "    passenger on board: "
						+ planePassCount.getPassengerCount() + ",  registered: " + ticketOnFlight.size()
						+ " people, start price: " + ((double) (actualFlights.get(i).getStartPrice()) / 100) + "$");
				ids.add(actualFlights.get(i).getId());
			} else {
				System.out.println("->   ID:" + actualFlights.get(i).getId() + "   From " + cityFr.getCity_en() + " to "
						+ cityTo.getCity_en() + " at " + actualFlights.get(i).getdAndT() + "    passenger on board: "
						+ planePassCount.getPassengerCount() + ",  registered: " + ticketOnFlight.size()
						+ " people.        NO TICKETS!!! PLANE FULL!!! ");
			}
		}

		/**
		 * flight selection
		 */
		Long b = null;// fl_num
		try {
			System.out.println("Enter ID of flight: ");
			scn = new Scanner(System.in);
			Long a = (long) Double.parseDouble(scn.next());
			b = a;
		} catch (Exception e) {
			System.out.println("Incorrect data entry!");
			return;
		}
		Flight flight = flightService.get(b);
		if (ids.contains(b)) {
			price = (double) (flight.getStartPrice()) / 100;
			System.out.println("Ticket price: " + price + "$");
		} else {
			System.out.println("Incorrect ID!");
			return;
		}
		/**
		 * price correction
		 */

		Integer remTime = (int) ((flight.getdAndT().getTime() - System.currentTimeMillis()) / 1000 / 60 / 60 / 24);// days

		if (remTime > 150 && remTime <= 180)// 5-6 month
			price *= 1.11;
		else if (remTime > 120 && remTime <= 150)// 4-5 month
			price *= 1.12;
		else if (remTime > 90 && remTime <= 120) // 3-4 month
			price *= 1.13;
		else if (remTime > 60 && remTime <= 90) // 2-3 month
			price *= 1.14;
		else if (remTime > 30 && remTime <= 60) // 1-2 month
			price *= 1.15;
		else if (remTime <= 30) // < 1 month
			price = price * 1.16;

		System.out.println(
				"After time correction: " + new BigDecimal(price).setScale(2, RoundingMode.UP).doubleValue() + "$");
		/**
		 * plane filling correction (%)
		 */
		Plane plane = planeService.get(Integer.toUnsignedLong(flight.getPlane()));
		List<TicketOnFlight> tof = ticketService.ticketOnFlight(b);
		Double percent = (double) (100 / (plane.getPassengerCount()) * tof.size());

		if (percent > 90 && percent <= 100)// 90-100%
			price *= 1.18;
		else if (percent > 80 && percent <= 90)// 80-90%
			price *= 1.18;
		else if (percent > 70 && percent <= 80)// 70-80%
			price *= 1.17;
		else if (percent > 60 && percent <= 70)// 60-70%
			price *= 1.16;
		else if (percent > 50 && percent <= 60)// 50-60%
			price *= 1.15;
		else if (percent > 40 && percent <= 50)// 40-50%
			price *= 1.14;
		else if (percent > 30 && percent <= 40)// 30-40%
			price *= 1.13;
		else if (percent > 20 && percent <= 30)// 20-30%
			price *= 1.12;
		else if (percent > 10 && percent <= 20)// 10-20%
			price *= 1.11;

		System.out.println("After plane filling correction: "
				+ new BigDecimal(price).setScale(2, RoundingMode.UP).doubleValue() + "$");

		/**
		 * baggage selection
		 */
		System.out.println("Are you register baggage?  (yes/no)    Price: " + priceBag + "$");
		String bag = (scn.next());

		boolean baggage; // bag
		switch (bag) {
		case "yes":
			baggage = true;
			price += priceBag;
			break;
		case "no":
			baggage = false;
			break;
		default:
			System.out.println("You can enter only YES or NO!");
			return;
		}

		System.out.println(
				"Current ticket price: " + new BigDecimal(price).setScale(2, RoundingMode.UP).doubleValue() + "$");
		/**
		 * primary landing and registration selection
		 */
		System.out
				.println("Are you want the primary landing and registration?  (yes/no) Price: " + priceFirstReg + "$");
		String first = (scn.next());
		boolean firstReg; // first_reg
		switch (first) {
		case "yes":
			firstReg = true;
			price += priceFirstReg;
			break;
		case "no":
			firstReg = false;
			break;
		default:
			System.out.println("You can enter only YES or NO!");
			return;
		}

		System.out.println(
				"Current ticket price: " + new BigDecimal(price).setScale(2, RoundingMode.UP).doubleValue() + "$  ");

		/**
		 * class selection
		 */
		System.out.println("You want to fly 1 class (price " + priceClass + "$) or 2 class?  (enter 1 or 2) ");
		String cla = (scn.next());
		Integer clas; // clas
		switch (cla) {
		case "1":
			clas = 1;
			price += priceClass;
			break;
		case "2":
			clas = 2;
			break;
		default:
			System.out.println("You can enter only 1 or 2!");
			return;
		}

		System.out.println(
				"Current ticket price: " + new BigDecimal(price).setScale(2, RoundingMode.UP).doubleValue() + "$");
		/**
		 * registered Passenger or search passenger in base by passport
		 */
		System.out.println("Are you registered in LowCostAir?  (yes/no):");
		String reg = (scn.next());
		String fullName;
		Long passId = null;
		switch (reg) {
		case "yes":
			System.out.println("Enter you passport number (example KH5630095):");
			String passport1 = (scn.next());
			List<Passenger> passenger = passengerService.findByPassport(passport1);
			if (passenger.size() == 0) {
				System.out.println("This Passport not found!");
				return;
			} else {
				System.out.println("Passenger found: " + passenger);
				passId = passenger.get(0).getId();
			}
			break;
		case "no":
			try {
				System.out.println("Enter you first name:");
				String firstName = (scn.next());
				System.out.println("Enter you last name:");
				String lastName = (scn.next());
				fullName = (firstName + " " + lastName).toString();
				System.out.println("Enter you birthday  (example 1982-12-22):");
				String birthday = (scn.next());
				System.out.println("Enter you passport (example KH5632267):");
				String passport = (scn.next());
				Passenger passenger2 = new Passenger();
				passenger2.setFullName(fullName);
				passenger2.setBirthday(Date.valueOf(birthday));
				passenger2.setPassport(passport);
				Long id = passengerService.save(passenger2);
				passId = id;
				break;
			} catch (Exception e) {
				System.out.println("INCORRECT BIRTHDAY OR THIS PASSPORT IS ALREADY REGISTERED!!!");
				return;
			}
		default:
			System.out.println("You can enter only YES or NO!");
			return;
		}

		/**
		 * insert in Ticket base new Ticket
		 */
		Ticket ticket = new Ticket();

		ticket.setFlNum(((Number) b).intValue());
		ticket.setPassenger(((Number) passId).intValue());
		ticket.setClas(clas);
		ticket.setPrice((int) Math.round((price * 100)));
		ticket.setBag(baggage);
		ticket.setFirst_reg(firstReg);
		@SuppressWarnings("unused")
		Long id = ticketService.save(ticket);

		/**
		 * full info of ticket
		 */
		System.out.println();
		System.out.println("           Congratulations, you registered on flight!");

		Passenger passenger = passengerService.get(passId);

		System.out.println("Passenger: " + passenger.getFullName() + ", birthday: " + passenger.getBirthday()
				+ ", passport: " + passenger.getPassport());

		System.out.println("           Ticket class: " + clas + ", price: "
				+ new BigDecimal(price).setScale(2, RoundingMode.UP).doubleValue() + "$, baggage: " + baggage
				+ ", priority boarding and registration: " + firstReg);

		City cityFrom = cityService.get(Integer.toUnsignedLong(flight.getFromm()));
		City cityTo = cityService.get(Integer.toUnsignedLong(flight.getToo()));

		System.out.println("           Departs from: " + cityFrom.getCity_en() + " to " + cityTo.getCity_en() + " at "
				+ flight.getdAndT());

		System.out.println("           Plane : " + plane.getModel() + ", bort number: " + plane.getBortNumber()
				+ ", capacity of persons on board: " + plane.getPassengerCount());
		System.out.println();
	}
}
