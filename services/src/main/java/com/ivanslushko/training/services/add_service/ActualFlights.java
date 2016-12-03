package com.ivanslushko.training.services.add_service;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ivanslushko.training.datamodel.Flight;
import com.ivanslushko.training.services.FlightService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class ActualFlights {

	@Inject
	private FlightService flightService;

	@Test
	public void actualFlights() {

		List<Flight> flights = flightService.getAll();

		System.out.println("            curreht time-------> " + System.currentTimeMillis());
		System.out.println("            ALL FLIGHTS:");
		for (int i = 0; i < flights.size(); i++) {
			System.out.println("- " + flights.get(i) + "                " + flights.get(i).getdAndT().getTime());
		}
		System.out.println("            ACTUAL FLIGHTS:");
		for (int i = 0; i < flights.size(); i++) {
			if (flights.get(i).getdAndT().getTime() >= (System.currentTimeMillis())) {
				System.out.println(
						"----->  " + flights.get(i) + "                " + flights.get(i).getdAndT().getTime());
			}
		}
	}
}