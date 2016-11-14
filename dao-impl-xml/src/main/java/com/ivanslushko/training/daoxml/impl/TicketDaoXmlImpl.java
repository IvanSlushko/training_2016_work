package com.ivanslushko.training.daoxml.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ivanslushko.training.daoapi.ITicketDao;
import com.ivanslushko.training.datamodel.Ticket;

@Repository
public class TicketDaoXmlImpl implements ITicketDao {

	@Override
	public Ticket get(Long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Long insert(final Ticket entity) {
		throw new UnsupportedOperationException();

	}

	@Override
	public Long update(final Ticket entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(Long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Ticket> getAll() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void save(Ticket entity) {
		throw new UnsupportedOperationException();
	}

}
