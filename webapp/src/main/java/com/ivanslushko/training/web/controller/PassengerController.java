package com.ivanslushko.training.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ivanslushko.training.datamodel.Passenger;
import com.ivanslushko.training.datamodel.Ticket;
import com.ivanslushko.training.services.PassengerService;
import com.ivanslushko.training.web.model.PassengerModel;
import com.ivanslushko.training.web.model.TicketModel;

@RestController
@RequestMapping("/passenger")
public class PassengerController {
	
	@Inject
	private PassengerService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PassengerModel>> getAll() {
		List<Passenger> all = service.getAll();

		List<PassengerModel> converted = new ArrayList<>();
		for (Passenger passenger : all) {
			converted.add(entity2model(passenger));
		}
		return new ResponseEntity<List<TicketModel>>(converted, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<TicketModel> getById(@PathVariable Long id) {
		Ticket ticket = service.get(id);
		return new ResponseEntity<TicketModel>(entity2model(ticket), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createNewTicket(@RequestBody TicketModel ticketModel) {
		service.save(model2entity(ticketModel));
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public ResponseEntity<Void> updatePlane(@RequestBody TicketModel ticketModel, @PathVariable Long id) {
		Ticket ticket = model2entity(ticketModel);
		ticket.setId(id);

		service.update(ticket);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	private TicketModel entity2model(Ticket ticket) {
		TicketModel e = new TicketModel();
		e.setId(ticket.getId());
		e.setFl_num(ticket.getFlNum());
		e.setPassenger(ticket.getPassenger());
		e.setClas(ticket.getClas());
		e.setPrice(ticket.getPrice());
		e.setBag(ticket.getBag());
		return e;
	}

	private Ticket model2entity(TicketModel ticketModel) {
		Ticket e = new Ticket();
		e.setId(ticketModel.getId());
		e.setFlNum(ticketModel.getFl_num());
		e.setPassenger(ticketModel.getPassenger());
		e.setClas(ticketModel.getClas());
		e.setPrice(ticketModel.getPrice());
		e.setBag(ticketModel.getBag());
		return e;
	}

	
	
	

}
