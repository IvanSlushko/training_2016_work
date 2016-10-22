package services;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.ivanslushko.training.datamodel.City;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class ServiceTest {

    @Inject
    private CityService cityService;

    @Test
    public void getByIdtest() {
        City city = cityService.get(7l);

        Assert.assertNotNull("city for id=7 should not be null", city);
        Assert.assertEquals(new Long(1), city.getId());
    }

}
