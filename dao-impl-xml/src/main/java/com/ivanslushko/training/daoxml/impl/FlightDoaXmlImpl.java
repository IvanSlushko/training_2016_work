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

import com.ivanslushko.training.daoapi.IFlightDao;
import com.ivanslushko.training.datamodel.ActualFlights;
import com.ivanslushko.training.datamodel.Flight;
import com.ivanslushko.training.datamodel.FlightFromCity;
import com.thoughtworks.xstream.XStream;

@Repository
public class FlightDoaXmlImpl implements IFlightDao {

	private XStream xstream;
	private File file;

	@Value("${basePath}")
	private String basePath;

	@PostConstruct
	private void intialize() throws IOException {
		// TODO move to the parent class
		// TODO refactoring: use classname instead of hardcoded filename
		xstream = new XStream();
		xstream.alias("flight", Flight.class);

		file = new File(basePath + "/flights.xml");
		if (!file.exists()) {
			file.createNewFile();
			xstream.toXML(new ArrayList<>(), new FileOutputStream(file));
		}
	}

	@Override
	public Flight get(Long id) {
		List<Flight> allFlight = readCollection();
		for (Flight flight : allFlight) {
			if (flight.getId().equals(id)) {
				return flight;
			}
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		List<Flight> allFlight = readCollection();
		List<Flight> newList = new ArrayList<>();
		// don't iterate whole collection
		for (Flight flight : allFlight) {
			if (!flight.getId().equals(id)) {
				newList.add(flight);
			}
		}
		writeCollection(newList);
	}

	@Override
	public List<Flight> getAll() {
		return readCollection();
	}

	@Override
	public Long insert(final Flight entity) {
		List<Flight> allFlight = readCollection();
		Long id = getNextId(allFlight);
		allFlight.add(entity);
		entity.setId(new Long(id));
		writeCollection(allFlight);
		return id;
	}

	@Override
	public Long update(final Flight entity) {
		List<Flight> allFlight = readCollection();
		for (Flight flight : allFlight) {
			if (flight.getId().equals(entity.getId())) {
				flight.setPlane(entity.getPlane());
				flight.setFromm(entity.getFromm());
				flight.setdAndT(entity.getdAndT());
				flight.setToo(entity.getToo());
				flight.setStartPrice(entity.getStartPrice());
			}
		}
		writeCollection(allFlight);
		return null;
	}

	@SuppressWarnings("unchecked")
	private List<Flight> readCollection() {
		return (List<Flight>) xstream.fromXML(file);
	}

	private void writeCollection(List<Flight> newList) {
		try {
			xstream.toXML(newList, new FileOutputStream(file));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);// TODO custom exception
		}
	}

	private long getNextId(List<Flight> allFlight) {
		return allFlight.isEmpty() ? 1l : allFlight.get(allFlight.size() - 1).getId() + 1;
	}

	@Override
	public void save(Flight entity) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<FlightFromCity> getFromCity(Long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<ActualFlights> actualFlights() {
		throw new UnsupportedOperationException();
	}
}
