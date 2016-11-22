package com.ivanslushko.training.daoapi;

import java.util.List;

import com.ivanslushko.training.datamodel.Ticket;
import com.ivanslushko.training.datamodel.TicketOnFlight;

public interface ITicketDao extends IAbstractDao<Ticket> {

	List<TicketOnFlight> ticketOnFlight(Long id);
}
