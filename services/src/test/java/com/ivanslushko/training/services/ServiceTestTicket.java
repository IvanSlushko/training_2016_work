package com.ivanslushko.training.services;

import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ivanslushko.training.datamodel.Ticket;
import com.ivanslushko.training.services.TicketService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
@FixMethodOrder

public class ServiceTestTicket {

	@Inject
	private TicketService ticketService;

	/**
	 * delete Ticket from Base
	 * 
	 * @param Ticket
	 * @return id
	 */
	@Test
	public void deleteTicket() {
		Ticket ticket = new Ticket();
		ticket.setFlNum(1);
		ticket.setPassenger(5);//
		ticket.setClas(2);
		ticket.setPrice(3);
		ticket.setBag(false);
		Long id = ticketService.save(ticket);
		ticketService.delete(id);
		Assert.assertNull(ticketService.get(id));
	}

	/**
	 * insert in Ticket base new Ticket
	 */
	@Test
	public void saveTicket() {
		Ticket ticket = new Ticket();
		ticket.setFlNum(1);
		ticket.setPassenger(5);//
		ticket.setClas(2);
		ticket.setPrice(3);
		ticket.setBag(false);
		Long id = ticketService.save(ticket);
		Assert.assertNotNull(id);
		Ticket ticketFromDb = ticketService.get(id);
		Assert.assertEquals(ticket.getFlNum(), ticketFromDb.getFlNum());
		ticketService.delete(id);
	}

	/**
	 * get from Base 1 ticket
	 */
	@Test
	public void getTicket() {
		Ticket ticket = new Ticket();
		ticket.setFlNum(1);
		ticket.setPassenger(5);//
		ticket.setClas(2);
		ticket.setPrice(3);
		ticket.setBag(false);
		Long id = ticketService.save(ticket);
		Assert.assertNotNull("Ticket for id should not be null", ticket);
		Assert.assertEquals(new Long(id), ticket.getId());
		ticketService.delete(id);
	}

	/**
	 * get all from Base
	 */
	@Test
	public void getAllTickets() {
		List<Ticket> tickets = ticketService.getAll();
		Assert.assertNotNull(tickets);
	}

	/**
	 * update Flight
	 */
	@Test
	public void UpdateTicket() {
		Ticket ticket = new Ticket();
		ticket.setFlNum(1);
		ticket.setPassenger(1);
		ticket.setClas(1);
		ticket.setPrice(3);
		ticket.setBag(true);
		Long id = ticketService.save(ticket);
		Assert.assertNotNull(id);
		ticket.setFlNum(2);
		ticket.setPassenger(2);
		ticket.setClas(2);
		ticket.setPrice(2);
		ticket.setBag(false);
		ticketService.update(ticket);
		Ticket ticketFromDb = ticketService.get(id);
		Assert.assertEquals(ticket.getFlNum(), ticketFromDb.getFlNum());
		Assert.assertEquals(ticket.getPassenger(), ticketFromDb.getPassenger());
		Assert.assertEquals(ticket.getClas(), ticketFromDb.getClas());
		Assert.assertEquals(ticket.getPrice(), ticketFromDb.getPrice());
		Assert.assertEquals(ticket.getBag(), ticketFromDb.getBag());
		ticketService.delete(id);
	}
}
