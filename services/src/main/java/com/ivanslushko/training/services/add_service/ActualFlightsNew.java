package com.ivanslushko.training.services.add_service;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ivanslushko.training.datamodel.ActualFlights;
import com.ivanslushko.training.services.FlightService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")

public class ActualFlightsNew {
	@Inject
	private FlightService flightService;

	@Test
	public void ActualTest() {

		List<ActualFlights> actualFlights = flightService.actualFlights();

		for (int i = 0; i < actualFlights.size(); i++) {

			System.out.println("->" + actualFlights.get(i));
		}
	}

}
