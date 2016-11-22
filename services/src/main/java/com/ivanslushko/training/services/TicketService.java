package com.ivanslushko.training.services;

import java.util.List;

import com.ivanslushko.training.datamodel.Ticket;
import com.ivanslushko.training.datamodel.TicketOnFlight;

public interface TicketService extends AbstractService<Ticket> {

	List<TicketOnFlight> ticketOnFlight(Long id);
}
