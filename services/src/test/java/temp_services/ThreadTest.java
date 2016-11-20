package temp_services;

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
public class ThreadTest {

	@Inject
	private CityService cityService;
	
	@Test
	public void getByIdCity() throws InterruptedException{
		
        Thread.sleep(1000);
		
		City city = cityService.get(1L);
		
		Assert.assertNotNull("city 3 should not be null", city);
		Assert.assertEquals(new Long(1), city.getId());
	}

}
