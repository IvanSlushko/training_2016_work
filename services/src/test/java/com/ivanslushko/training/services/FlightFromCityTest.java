package com.ivanslushko.training.services;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ivanslushko.training.daodb.customentity.FlightFromCity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class FlightFromCityTest {

	@Inject
	private FlightService flightService;

	@Test
	public void flightFromCityTest() {

//		List flightFromCityes = (List) flightService.getFromCity(2L);
//	//	FlightFromCity flightFromCityes = flightService.getFromCity(2L);
//		Assert.assertNotNull("flight from city 3 should not be null", flightFromCityes);
//	//	Assert.assertEquals(new Long(2l), flightFromCityes.getId());
//
//		//for (int i = 0; i < flightFromCityes.size(); i++) {
//			System.out.println(flightFromCityes.getHeight());
//		//}
		FlightFromCity flightFromCity = (FlightFromCity) flightService.getFromCity(2l);

	   //     Assert.assertNotNull(flightFromCity.getCity());
	     //   Assert.assertNotNull(flightFromCity.getFlight());
	        Assert.assertNotNull(flightFromCity.getFlightFC());
	}

}
