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

import com.ivanslushko.training.daoapi.ITicketDao;
import com.ivanslushko.training.datamodel.Ticket;
import com.ivanslushko.training.datamodel.TicketOnFlight;
import com.thoughtworks.xstream.XStream;

@Repository
public class TicketDaoXmlImpl implements ITicketDao {

	private XStream xstream;
	private File file;

	@Value("${basePath}")
	private String basePath;

	@PostConstruct
	private void intialize() throws IOException {
		// TODO move to the parent class
		// TODO refactoring: use classname instead of hardcoded filename
		xstream = new XStream();
		xstream.alias("ticket", Ticket.class);

		file = new File(basePath + "/tickets.xml");
		if (!file.exists()) {
			file.createNewFile();
			xstream.toXML(new ArrayList<>(), new FileOutputStream(file));
		}
	}

	@Override
	public Ticket get(Long id) {
		List<Ticket> allTicket = readCollection();
		for (Ticket ticket : allTicket) {
			if (ticket.getId().equals(id)) {
				return ticket;
			}
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		List<Ticket> allTicket = readCollection();
		List<Ticket> newList = new ArrayList<>();
		// don't iterate whole collection
		for (Ticket ticket : allTicket) {
			if (!ticket.getId().equals(id)) {
				newList.add(ticket);
			}
		}
		writeCollection(newList);
	}

	@Override
	public List<Ticket> getAll() {
		return readCollection();
	}

	@Override
	public Long insert(final Ticket entity) {
		List<Ticket> allTicket = readCollection();
		Long id = getNextId(allTicket);
		allTicket.add(entity);
		entity.setId(new Long(id));
		writeCollection(allTicket);
		return id;
	}

	@Override
	public Long update(final Ticket entity) {
		List<Ticket> allTicket = readCollection();
		for (Ticket ticket : allTicket) {
			if (ticket.getId().equals(entity.getId())) {
				ticket.setFlNum(entity.getFlNum());
				ticket.setPassenger(entity.getPassenger());
				ticket.setClas(entity.getClas());
				ticket.setPrice(entity.getPrice());
				ticket.setBag(entity.getBag());
			}
		}
		writeCollection(allTicket);
		return null;
	}

	private List<Ticket> readCollection() {
		return (List<Ticket>) xstream.fromXML(file);
	}

	private void writeCollection(List<Ticket> newList) {
		try {
			xstream.toXML(newList, new FileOutputStream(file));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);// TODO custom exception
		}
	}

	private long getNextId(List<Ticket> allTicket) {
		return allTicket.isEmpty() ? 1l : allTicket.get(allTicket.size() - 1).getId() + 1;
	}

	@Override
	public void save(Ticket entity) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<TicketOnFlight> ticketOnFlight(Long id) {
		throw new UnsupportedOperationException();
	}

}
