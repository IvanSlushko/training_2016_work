package com.ivanslushko.training.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ivanslushko.training.daodb.TicketDao;
import com.ivanslushko.training.datamodel.Ticket;
import com.ivanslushko.training.services.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TicketServiceImpl.class);

	@Inject
	private TicketDao ticketDao;

	@Override
	public Ticket get(Long id) {
		return ticketDao.get(id);
	}

	@Override
	public void saveAll(List<Ticket> tickets) {
		for (Ticket ticket : tickets) {
			save(ticket);
		}
	}

	@Override
	public Long save(Ticket ticket) {
		if (ticket.getId() == null) {
			Long id = ticketDao.insert(ticket);
			LOGGER.info("Ticket created. id={}, flight_num={}, passenger={}, clas={}, price={}, bag={}", ticket.getId(),
					ticket.getFlNum(), ticket.getPassenger(), ticket.getClas(), ticket.getPrice(), ticket.getBag());
			return id;
		} else {
			ticketDao.update(ticket);
			return ticket.getId();
		}
	}

	@Override
	public List<Ticket> getAll() {
		return ticketDao.getAll();
	}

	@Override
	public Ticket delete(Long id) {
		LOGGER.info("Ticket deleted! id={}", id);
		return ticketDao.delete(id);
	}

	@Override
	public Long update(Ticket ticket) {
		if (ticket.getId() == null) {
			Long id = ticketDao.update(ticket);
			LOGGER.info("Ticket updated. id={}, fl_mumber={}, passenger={}", ticket.getId(), ticket.getFlNum(),
					ticket.getPassenger());
			return id;
		} else {
			ticketDao.update(ticket);
			return ticket.getId();
		}
	}
}
