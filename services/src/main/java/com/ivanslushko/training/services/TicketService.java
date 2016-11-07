package com.ivanslushko.training.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ivanslushko.training.datamodel.Ticket;

public interface TicketService {

	@Transactional
	void saveAll(List<Ticket> tickets);

	Long save(Ticket ticket);

	Ticket delete(Long id);

	Ticket get(Long id);

	List<Ticket> getAll();
}
