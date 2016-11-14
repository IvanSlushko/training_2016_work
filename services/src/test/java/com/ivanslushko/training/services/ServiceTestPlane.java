package com.ivanslushko.training.services;

import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ivanslushko.training.datamodel.Plane;
import com.ivanslushko.training.services.PlaneService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
@FixMethodOrder

public class ServiceTestPlane {

	@Inject
	private PlaneService planeService;

	/**
	 * delete Plane from Base
	 * 
	 * @param Plane
	 * @return id
	 */
	@Test
	public void deletePlane() {
		Plane plane = new Plane();
		plane.setBortNumber("9086723");// unic
		plane.setModel("Boeing 707");
		plane.setPassengerCount(88);
		Long id = planeService.save(plane);
		planeService.delete(id);
		Assert.assertNull(planeService.get(id));
	}

	/**
	 * insert in Plane base new Plane
	 */
	@Test
	public void savePlaneTest() {
		Plane plane = new Plane();
		plane.setBortNumber("9086723");// unic
		plane.setModel("Boeing 707");
		plane.setPassengerCount(88);
		Long id = planeService.save(plane);
		Assert.assertNotNull(id);
		Plane planeFromDb = planeService.get(id);
		Assert.assertEquals(plane.getBortNumber(), planeFromDb.getBortNumber());
		planeService.delete(id);
	}

	/**
	 * get from Base 1 plane
	 */
	@Test
	public void getPlane() {
		Plane plane = new Plane();
		plane.setBortNumber("9086723");// unic
		plane.setModel("Boeing 707");
		plane.setPassengerCount(88);
		Long id = planeService.save(plane);
		Assert.assertNotNull("Plane for id should not be null", plane);
		Assert.assertEquals(new Long(id), plane.getId());
		planeService.delete(id);
	}

	/**
	 * get all from Base
	 */
	@Test
	public void getAllPlane() {
		List<Plane> planes = planeService.getAll();
		Assert.assertNotNull(planes);
	}

	/**
	 * update Plane
	 */
	@Test
	public void UpdatePlane() {
		Plane plane = new Plane();
		plane.setBortNumber("1111");
		plane.setModel("Boeing 1");
		plane.setPassengerCount(55);
		Long id = planeService.save(plane);
		Assert.assertNotNull(id);
		plane.setBortNumber("2222");
		plane.setModel("Boeing 2");
		plane.setPassengerCount(66);
		planeService.update(plane);
		Plane planeFromDb = planeService.get(id);
		Assert.assertEquals(plane.getBortNumber(), planeFromDb.getBortNumber());
		Assert.assertEquals(plane.getModel(), planeFromDb.getModel());
		Assert.assertEquals(plane.getPassengerCount(), planeFromDb.getPassengerCount());
		planeService.delete(id);
	}
}
