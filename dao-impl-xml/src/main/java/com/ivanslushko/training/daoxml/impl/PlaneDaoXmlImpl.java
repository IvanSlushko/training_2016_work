package com.ivanslushko.training.daoxml.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ivanslushko.training.daoapi.IPlaneDao;
import com.ivanslushko.training.datamodel.Plane;

@Repository
public class PlaneDaoXmlImpl implements IPlaneDao {

	@Override
	public Plane get(Long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Long insert(final Plane entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Long update(final Plane entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(Long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Plane> getAll() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void save(Plane entity) {
		throw new UnsupportedOperationException();

	}

}
