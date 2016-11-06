package com.ivanslushko.training.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ivanslushko.training.datamodel.City;
import com.ivanslushko.training.datamodel.Plane;

public interface PlaneService {

	@Transactional
	void saveAll(List<Plane> planes);

	Plane delete(Long id);
	
	Long save(Plane plane);

	Plane get(Long id);

	List<Plane> getAll();
}
