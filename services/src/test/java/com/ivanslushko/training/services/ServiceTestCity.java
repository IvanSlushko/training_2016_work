package com.ivanslushko.training.services;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ivanslushko.training.datamodel.City;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
@FixMethodOrder

public class ServiceTestCity {

	
	
	@Inject
	private CityService cityService;
	
//	@Inject
//	private CityDao cityDao;
	/**
	 * insert in City base new City
	 */
	@Test
	public void insertCity() {
		City city = new City();
		city.setCity("TestCITY");
		Long id = cityService.save(city);
		Assert.assertNotNull(id);//check that ID isn't null
		City cityFromDb = cityService.get(id); 
		Assert.assertEquals(city.getCity(), cityFromDb.getCity()); //check cities are equals
		cityService.delete(id);
	}
	
	/**
	 * get from Base
	 */

	@Test
	public void getCity() {
		
		

	//	City cityFromDb = cityService.get();
//		System.out.println(id);
//		Assert.assertEquals(city.getCity(), cityFromDb.getCity());
//		System.out.println(id + city.getCity() + cityFromDb.getCity());
	


	}
	//private static final Logger LOGGER = LoggerFactory.getLogger(CityServiceImpl.class);
	//LOGGER.info("City get: id={}, title={}");
	// cityService.delete(id);
}
