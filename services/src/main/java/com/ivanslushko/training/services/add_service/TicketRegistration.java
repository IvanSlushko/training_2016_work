package com.ivanslushko.training.services.add_service;

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
import com.ivanslushko.training.datamodel.Passenger;
import com.ivanslushko.training.datamodel.Plane;
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
		 * insert in Passenger base new Passenger
		 */
		// Start price to flight
		Double price = 2.55;// price
		Double priceBag = 6.40;
		Double priceFirstReg = 1.25;
		Double priceClass = 1.50; // 1 class
		/**
		 * insert in Passenger base new Passenger
		 */
		List<ActualFlights> actualFlights = flightService.actualFlights();
		System.out.println("        ActualFlights:");
		List<Long> ids = new ArrayList<Long>();
		for (int i = 0; i < actualFlights.size(); i++) {
			City cityFr = cityService.get(Integer.toUnsignedLong((Integer) actualFlights.get(i).getFromm()));
			City cityTo = cityService.get(Integer.toUnsignedLong((Integer) actualFlights.get(i).getToo()));
			Plane planePassCount = planeService.get(Integer.toUnsignedLong((Integer) actualFlights.get(i).getPlane()));
			List<TicketOnFlight> ticketOnFlight = ticketService.ticketOnFlight(Integer.toUnsignedLong((Integer) i));

			if (ticketOnFlight.size() < planePassCount.getPassengerCount()) {
				System.out.println("->   ID:" + actualFlights.get(i).getId() + "   From " + cityFr.getCity_en() + " to "
						+ cityTo.getCity_en() + " at " + actualFlights.get(i).getdAndT() + "    passenger on board: "
						+ planePassCount.getPassengerCount() + ",  registered: " + ticketOnFlight.size() + " people.");
				ids.add(actualFlights.get(i).getId());
			} else {
				System.out.println("->   ID:" + actualFlights.get(i).getId() + "   From " + cityFr.getCity_en() + " to "
						+ cityTo.getCity_en() + " at " + actualFlights.get(i).getdAndT() + "    passenger on board: "
						+ planePassCount.getPassengerCount() + ",  registered: " + ticketOnFlight.size()
						+ " people.        NO TICKETS!!! PLANE FULL!!! ");
			}

		}

		/**
		 * insert in Passenger base new Passenger
		 */
		Long b = null;// fl_num
		try {
			scn = new Scanner(System.in);
			System.out.println("Enter ID of flight: ");
			Long a = (long) Double.parseDouble(scn.next());
			b = a;
		} catch (Exception e) {
			System.out.println("Incorrect data entry!");
			return;
		}

		if (ids.contains(b)) {
			System.out.println("Ticket price: " + price + "$");
		} else {
			System.out.println("Incorrect ID!");
			return;
		}
		/**
		 * insert in Passenger base new Passenger
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

		System.out.println("Current ticket price: " + price + "$");
		/**
		 * insert in Passenger base new Passenger
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

		System.out.println("Current ticket price: " + price + "$  ");
		/**
		 * insert in Passenger base new Passenger
		 */
		System.out.println("You want to fly 1 class (price" + priceClass + "$) or 2 class?  (enter 1 or 2) ");
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

		System.out.println("Current ticket price: " + price + "$");
		/**
		 * insert in Passenger base new Passenger
		 */
		System.out.println("Are you registered in LowCostAir?  (yes/no):");
		String reg = (scn.next());
		switch (reg) {
		case "yes":
			System.out.println("Enter you passport number (example KH5632267):");
			String passport1 = (scn.next());

			List<Passenger> passenger = passengerService.findByPassport(passport1);
			if (passenger.size() == 0) {
				System.out.println("This Passport not found!");
				return;
			} else {
				System.out.println("Passenger found: " + passenger);
			}
			break;
		case "no":
			System.out.println("Enter you full name:");
			String fullName = (scn.next());
			System.out.println("Enter you birthday  (example 1982-12-22):");

			System.out.println(" !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ");
			
			String birthday = (scn.next());
			System.out.println("Enter you passport (example KH5632267):");
			String passport = (scn.next());
			Passenger passenger2 = new Passenger();
			passenger2.setFullName(fullName);
			passenger2.setBirthday(Date.valueOf(birthday));
			passenger2.setPassport("KH9087765");
			System.out.println(passenger2);
			break;
		default:
			System.out.println("You can enter only YES or NO!");
			return;
		}
		System.out.println("!!!!!!!!!!");
	}
}
