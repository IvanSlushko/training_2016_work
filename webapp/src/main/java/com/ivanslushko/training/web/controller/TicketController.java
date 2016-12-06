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

import com.ivanslushko.training.datamodel.City;
import com.ivanslushko.training.datamodel.Flight;
import com.ivanslushko.training.datamodel.Passenger;
import com.ivanslushko.training.datamodel.Plane;
import com.ivanslushko.training.datamodel.Ticket;
import com.ivanslushko.training.datamodel.TicketOnFlight;
import com.ivanslushko.training.services.CityService;
import com.ivanslushko.training.services.FlightService;
import com.ivanslushko.training.services.PassengerService;
import com.ivanslushko.training.services.PlaneService;
import com.ivanslushko.training.services.TicketService;
import com.ivanslushko.training.web.model.TicketFullModel;
import com.ivanslushko.training.web.model.TicketModel;
import com.ivanslushko.training.web.model.TicketOnFlightModel;

@RestController
@RequestMapping("/ticket")
public class TicketController {

	@Inject
	private TicketService service;
	@Inject
	private FlightService flightService;
	@Inject
	private PassengerService passengerService;
	@Inject
	private CityService cityService;
	@Inject
	private PlaneService planeService;


	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<TicketModel>> getAll() {
		List<Ticket> all = service.getAll();

		List<TicketModel> converted = new ArrayList<>();
		for (Ticket ticket : all) {
			converted.add(entity2model(ticket));
		}
		return new ResponseEntity<List<TicketModel>>(converted, HttpStatus.OK);
	}

	@RequestMapping(value = "/tof/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<TicketOnFlightModel>> ticketOnFlight(@PathVariable Long id) {
		List<TicketOnFlight> all = service.ticketOnFlight(id);

		List<TicketOnFlightModel> converted = new ArrayList<>();
		for (TicketOnFlight ticketOnFlight : all) {
			converted.add(entity2model(ticketOnFlight));
		}
		return new ResponseEntity<List<TicketOnFlightModel>>(converted, HttpStatus.OK);
	}
	
	//1111111111111111111111111111111111111   TFI
	@RequestMapping(value = "/tfi/{id}", method = RequestMethod.GET)
	public ResponseEntity<TicketFullModel> ticketFullModel (@PathVariable Long id) {
		Ticket ticket = service.get(id);
		Passenger passenger = passengerService.get(Integer.toUnsignedLong(ticket.getPassenger()));
		Flight flight = flightService.get(Integer.toUnsignedLong(ticket.getFlNum()));
		City cityFrom = cityService.get(Integer.toUnsignedLong(flight.getFromm()));
		City cityTo = cityService.get(Integer.toUnsignedLong(flight.getToo()));
		Plane plane = planeService.get(Integer.toUnsignedLong(flight.getPlane()));

		ArrayList<String> info= new ArrayList<>();
		info.add(passenger.getFullName());
		info.add(passenger.getBirthday().toString());
		info.add(passenger.getPassport());
		info.add(ticket.getClas().toString());
		info.add(ticket.getPrice().toString());
		info.add(ticket.getBag().toString());	
		info.add(ticket.getFirst_reg().toString());
		info.add(flight.getdAndT().toString());		
		info.add(cityFrom.getCity_en().toString());		
		info.add(cityTo.getCity_en().toString());	
		info.add(plane.getBortNumber().toString());		
		info.add(plane.getModel().toString());	
		info.add(plane.getPassengerCount().toString());	
		
		System.out.println(info);
		
		return new ResponseEntity<TicketFullModel>(HttpStatus.OK);
		
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
	public ResponseEntity<Void> updateTicket(@RequestBody TicketModel ticketModel, @PathVariable Long id) {
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

//	private TicketFullModel entity2model (Ticket ticket) {
//		TicketModel e = new TicketModel();
//		e.setId(ticket.getId());
//		e.setFl_num(ticket.getFlNum());
//		e.setPassenger(ticket.getPassenger());
//		e.setClas(ticket.getClas());
//		e.setPrice((double) (ticket.getPrice()) / 100);
//		e.setBag(ticket.getBag());
//		e.setFirst_reg(ticket.getFirst_reg());
//		return e;
//	}
	
	
	private TicketModel entity2model(Ticket ticket) {
		TicketModel e = new TicketModel();
		e.setId(ticket.getId());
		e.setFl_num(ticket.getFlNum());
		e.setPassenger(ticket.getPassenger());
		e.setClas(ticket.getClas());
		e.setPrice((double) (ticket.getPrice()) / 100);
		e.setBag(ticket.getBag());
		e.setFirst_reg(ticket.getFirst_reg());
		return e;
	}

	private Ticket model2entity(TicketModel ticketModel) {
		Ticket e = new Ticket();
		e.setId(ticketModel.getId());
		e.setFlNum(ticketModel.getFl_num());
		e.setPassenger(ticketModel.getPassenger());
		e.setClas(ticketModel.getClas());
		e.setPrice((int) (ticketModel.getPrice().doubleValue() * 100));
		e.setBag(ticketModel.getBag());
		e.setFirst_reg(ticketModel.getFirst_reg());
		return e;
	}

	private TicketOnFlightModel entity2model(TicketOnFlight ticketOnFlight) {
		TicketOnFlightModel e = new TicketOnFlightModel();
		e.setBag((Boolean) ticketOnFlight.getTicket().getBag());
		e.setFirst_reg((Boolean) ticketOnFlight.getTicket().getFirst_reg());
		e.setClas((Integer) ticketOnFlight.getTicket().getClas());
		e.setDate(ticketOnFlight.getFlight().getdAndT().toString());
		e.setFlNum((Integer) ticketOnFlight.getFlNum());
		e.setFrCity((Integer) ticketOnFlight.getFlight().getFromm());
		e.setPassenger((Integer) ticketOnFlight.getTicket().getPassenger());
		e.setPlane((Integer) ticketOnFlight.getFlight().getPlane());
		e.setToo((Integer) ticketOnFlight.getFlight().getToo());
		e.setPrice((double) (ticketOnFlight.getTicket().getPrice()) / 100);
		return e;
	}

}
