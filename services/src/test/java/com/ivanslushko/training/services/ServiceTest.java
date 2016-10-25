package com.ivanslushko.training.services;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ivanslushko.training.datamodel.City;
import com.ivanslushko.training.services.CityService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class ServiceTest {

	@Inject
	private CityService cityService;

	@Test
	public void getByIdtest() {
		City city = cityService.get(2L);
		Assert.assertNotNull("city 1 should not be null", city);
		Assert.assertEquals(new Long(2), city.getId());
		System.out.println(city.getCity()+ " have ID " +city.getId());
	}
	
	
	
}
