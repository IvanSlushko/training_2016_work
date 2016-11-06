package com.ivanslushko.training.daodb;

import java.util.List;

import com.ivanslushko.training.datamodel.Plane;

public interface PlaneDao {

	Plane get(Long id);

	Long insert(Plane entity);

	void update(Plane entity);

	void save(Plane entity);

	Plane delete(Long id);

	List<Plane> getAll();
}
