package com.ivanslushko.training.daodb;

import java.util.List;

import com.ivanslushko.training.datamodel.Ticket;

public interface TicketDao {

	Ticket get(Long id);

	Long insert(Ticket entity);

	void update(Ticket entity);

	Ticket delete(Long id);

	void save(Ticket entity);

	List<Ticket> getAll();
}
