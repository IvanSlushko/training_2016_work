package com.ivanslushko.training.daoxml.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.ivanslushko.training.daoapi.IPlaneDao;
import com.ivanslushko.training.datamodel.Plane;
import com.thoughtworks.xstream.XStream;

@Repository
public class PlaneDaoXmlImpl implements IPlaneDao {

	private XStream xstream;
	private File file;

	@Value("${basePath}")
	private String basePath;

	@PostConstruct
	private void intialize() throws IOException {
		// TODO move to the parent class
		// TODO refactoring: use classname instead of hardcoded filename
		xstream = new XStream();
		xstream.alias("plane", Plane.class);

		file = new File(basePath + "/planes.xml");
		if (!file.exists()) {
			file.createNewFile();
			xstream.toXML(new ArrayList<>(), new FileOutputStream(file));
		}
	}

	@Override
	public Plane get(Long id) {
		List<Plane> allPlane = readCollection();
		for (Plane plane : allPlane) {
			if (plane.getId().equals(id)) {
				return plane;
			}
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		List<Plane> allPlane = readCollection();
		List<Plane> newList = new ArrayList<>();
		// don't iterate whole collection
		for (Plane plane : allPlane) {
			if (!plane.getId().equals(id)) {
				newList.add(plane);
			}
		}
		writeCollection(newList);
	}

	@Override
	public List<Plane> getAll() {
		return readCollection();
	}

	@Override
	public Long insert(final Plane entity) {
		List<Plane> allPlane = readCollection();
		Long id = getNextId(allPlane);
		allPlane.add(entity);
		entity.setId(new Long(id));
		writeCollection(allPlane);
		return id;
	}

	@Override
	public Long update(final Plane entity) {
		List<Plane> allPlane = readCollection();
		for (Plane plane : allPlane) {
			if (plane.getId().equals(entity.getId())) {
				plane.setBortNumber(entity.getBortNumber());
				plane.setModel(entity.getModel());
				plane.setPassengerCount(entity.getPassengerCount());
			}
		}
		writeCollection(allPlane);
		return null;
	}

	@SuppressWarnings("unchecked")
	private List<Plane> readCollection() {
		return (List<Plane>) xstream.fromXML(file);
	}

	private void writeCollection(List<Plane> newList) {
		try {
			xstream.toXML(newList, new FileOutputStream(file));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);// TODO custom exception
		}
	}

	private long getNextId(List<Plane> allPlane) {
		return allPlane.isEmpty() ? 1l : allPlane.get(allPlane.size() - 1).getId() + 1;
	}

	@Override
	public void save(Plane entity) {
		// TODO Auto-generated method stub
	}

}
