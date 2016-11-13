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

	@Override
	public List<Plane> getAll() {
		return planeDao.getAll();
	}

	@Override
	public Plane delete(Long id) {
		LOGGER.info("Plane deleted! id={}", id);
		return planeDao.delete(id);
	}

	@Override
	public Long update(Plane plane) {
		if (plane.getId() == null) {
			Long id = planeDao.update(plane);
			LOGGER.info("Plane updated. id={}, model={}", plane.getId(), plane.getModel());
			return id;
		} else {
			planeDao.update(plane);
			return plane.getId();
		}
	}

}
