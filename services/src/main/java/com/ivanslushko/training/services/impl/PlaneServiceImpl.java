package com.ivanslushko.training.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ivanslushko.training.daodb.PlaneDao;
import com.ivanslushko.training.datamodel.Plane;
import com.ivanslushko.training.services.PlaneService;

@Service
public class PlaneServiceImpl implements PlaneService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PlaneServiceImpl.class);

	@Inject
	private PlaneDao planeDao;

	@Override
	public Plane get(Long id) {
		return planeDao.get(id);
	}

	@Override
	public void saveAll(List<Plane> planes) {
		for (Plane plane : planes) {
			save(plane);
		}
	}

	// @Override
	// public void save(Plane plane) {
	// if (plane.getId() == null) {
	// planeDao.insert(plane);
	// } else {
	// planeDao.update(plane);
	// }
	// }

	@Override
	public Long save(Plane plane) {
		if (plane.getId() == null) {
			Long id = planeDao.insert(plane);
			LOGGER.info("Plane created. id={}, bortNUM={}, model={}, passCount={}", plane.getId(),
					plane.getBortNumber(), plane.getModel(), plane.getPassengerCount());
			return id;
		} else {
			planeDao.update(plane);
			return plane.getId();
		}
	}
}
