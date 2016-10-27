package com.ivanslushko.training.services.impl;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.ivanslushko.training.daodb.PlaneDao;
import com.ivanslushko.training.datamodel.Plane;
import com.ivanslushko.training.services.PlaneService;

@Service
public class PlaneServiceImpl implements PlaneService {

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
	public void save(Plane plane) {
		if (plane.getId() == null) {
			planeDao.insert(plane);
		} else {
			planeDao.update(plane);
		}
	}
}
