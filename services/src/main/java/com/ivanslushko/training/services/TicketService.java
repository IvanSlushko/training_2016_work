package com.ivanslushko.training.services;

import java.util.List;
import com.ivanslushko.training.datamodel.Ticket;

public interface TicketService {

	void saveAll(List<Ticket> tickets);

	void save(Ticket ticket);

	Ticket get(Long id);
}
