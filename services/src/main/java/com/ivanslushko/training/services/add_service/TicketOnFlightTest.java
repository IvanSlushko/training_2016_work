package com.ivanslushko.training.services.add_service;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ivanslushko.training.datamodel.TicketOnFlight;
import com.ivanslushko.training.services.TicketService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")

public class TicketOnFlightTest {
	@Inject
	private TicketService ticketService;

	@Test
	public void ticketOnFlightTest() {

		List<TicketOnFlight> ticketOnFlight = ticketService.ticketOnFlight(5l);

		System.out.println();
		System.out.println("Flight " + ticketOnFlight.get(0).getFlNum() + " contains " + ticketOnFlight.size()
				+ " passenger(s) on board:");

		for (int i = 0; i < ticketOnFlight.size(); i++) {

			System.out.println("-> Passenger № " + ticketOnFlight.get(i).getTicket().getPassenger() + ", class: "
					+ ticketOnFlight.get(i).getTicket().getClas() + ", ticket price: "
					+ ((double) (ticketOnFlight.get(i).getTicket().getPrice()) / 100) + "$, bag: "
					+ ticketOnFlight.get(i).getTicket().getBag() + ".");
		}
		System.out.println();
	}

}
