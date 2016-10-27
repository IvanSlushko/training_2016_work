package com.ivanslushko.training.services;

import java.util.List;
import com.ivanslushko.training.datamodel.Plane;

public interface PlaneService {

	void saveAll(List<Plane> planes);

	void save(Plane plane);

	Plane get(Long id);
}
