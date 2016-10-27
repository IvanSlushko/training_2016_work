package com.ivanslushko.training.services.impl;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.ivanslushko.training.daodb.TicketDao;
import com.ivanslushko.training.datamodel.Ticket;
import com.ivanslushko.training.services.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

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
	public void save(Ticket ticket) {
		if (ticket.getId() == null) {
			ticketDao.insert(ticket);
		} else {
			ticketDao.update(ticket);
		}
	}
}
