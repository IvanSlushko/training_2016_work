package com.ivanslushko.training.daoxml.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.ivanslushko.training.daoapi.IPassengerDao;
import com.ivanslushko.training.datamodel.Passenger;
import com.thoughtworks.xstream.XStream;

@Repository
public class PassengerDaoXmlImpl implements IPassengerDao {

	private XStream xstream;
	private File file;

	@Value("${basePath}")
	private String basePath;

	@PostConstruct
	private void intialize() throws IOException {
		// TODO move to the parent class
		// TODO refactoring: use classname instead of hardcoded filename
		xstream = new XStream();
		xstream.alias("passenger", Passenger.class);

		file = new File(basePath + "/passengers.xml");
		if (!file.exists()) {
			file.createNewFile();
			xstream.toXML(new ArrayList<>(), new FileOutputStream(file));
		}
	}

	@Override
	public Passenger get(Long id) {
		List<Passenger> allPassenger = readCollection();
		for (Passenger passenger : allPassenger) {
			if (passenger.getId().equals(id)) {
				return passenger;
			}
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		List<Passenger> allPassenger = readCollection();
		List<Passenger> newList = new ArrayList<>();
		// don't iterate whole collection
		for (Passenger passenger : allPassenger) {
			if (!passenger.getId().equals(id)) {
				newList.add(passenger);
			}
		}
		writeCollection(newList);
	}

	@Override
	public List<Passenger> getAll() {
		return readCollection();
	}

	@Override
	public Long insert(final Passenger entity) {
		List<Passenger> allPassenger = readCollection();
		Long id = getNextId(allPassenger);
		allPassenger.add(entity);
		entity.setId(new Long(id));
		writeCollection(allPassenger);
		return id;
	}

	@Override
	public Long update(final Passenger entity) {
		List<Passenger> allPassenger = readCollection();
		for (Passenger passenger : allPassenger) {
			if (passenger.getId().equals(entity.getId())) {
				passenger.setFullName(entity.getFullName());
				passenger.setBirthday(entity.getBirthday());
				passenger.setPassport(entity.getPassport());
			}
		}
		writeCollection(allPassenger);
		return null;
	}

	private List<Passenger> readCollection() {
		return (List<Passenger>) xstream.fromXML(file);
	}

	private void writeCollection(List<Passenger> newList) {
		try {
			xstream.toXML(newList, new FileOutputStream(file));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);// TODO custom exception
		}
	}

	private long getNextId(List<Passenger> allPassenger) {
		return allPassenger.isEmpty() ? 1l : allPassenger.get(allPassenger.size() - 1).getId() + 1;
	}

	@Override
	public void save(Passenger entity) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Passenger> findByFullName(String fullName) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Passenger> findByBirthday(Date birthday) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Passenger> findByPassport(String passport) {
		throw new UnsupportedOperationException();
	}
}
