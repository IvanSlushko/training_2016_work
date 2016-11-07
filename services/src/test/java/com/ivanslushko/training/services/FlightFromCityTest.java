package com.ivanslushko.training.services;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class FlightFromCityTest {

	@Inject
	private FlightService flightService;

	@Test
	public void flightFromCityTest() {

		List<?> flightFromCity = (List<?>) flightService.getFromCity(5L);
		// Assert.assertNotNull(flightFromCity);
		System.out.println();
		System.out.println("From this city flies " + flightFromCity.size() + " Aircraft.");

		for (int i = 0; i < flightFromCity.size(); i++) {
			System.out.println(flightFromCity.get(i));
		}

		System.out.println();
	}

}
