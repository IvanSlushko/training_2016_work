package com.ivanslushko.training.services.add_service;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ivanslushko.training.datamodel.City;
import com.ivanslushko.training.datamodel.FlightFromCity;
import com.ivanslushko.training.datamodel.Plane;
import com.ivanslushko.training.services.CityService;
import com.ivanslushko.training.services.FlightService;
import com.ivanslushko.training.services.PlaneService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")

public class FlightFromCityTest {

	@Inject
	private FlightService flightService;
	@Inject
	private CityService cityService;
	@Inject
	private PlaneService planeService;

	@Test
	public void flightFromCityTest() {

		List<FlightFromCity> flightFromCity = flightService.getFromCity(5l);

		System.out.println();
		System.out.println(
				"From " + flightFromCity.get(0).getFrCity() + " flies " + flightFromCity.size() + " Aircraft:");
		System.out.println();

		for (int i = 0; i < flightFromCity.size(); i++) {
			City city = cityService.get(Integer.toUnsignedLong((Integer) flightFromCity.get(i).getToo()));
			Plane plane = planeService.get(Integer.toUnsignedLong((Integer) flightFromCity.get(i).getPlane()));

			System.out.println("-> at " + flightFromCity.get(i).getDate() + " to " + city.getCity_en() + " city on plane "
					+ plane.getModel() + " bort number: " + plane.getBortNumber());
		}
	}
}
