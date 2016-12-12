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

	@RequestMapping(value = "/tfi/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<TicketFullModel>> ticketFullModel(@PathVariable Long id) {

		Ticket ticket = service.get(id);
		Passenger passenger = passengerService.get(Integer.toUnsignedLong(ticket.getPassenger()));
		Flight flight = flightService.get(Integer.toUnsignedLong(ticket.getFlNum()));
		City cityFrom = cityService.get(Integer.toUnsignedLong(flight.getFromm()));
		City cityTo = cityService.get(Integer.toUnsignedLong(flight.getToo()));
		Plane plane = planeService.get(Integer.toUnsignedLong(flight.getPlane()));

		ArrayList<Object> passenger1 = new ArrayList<>();

		passenger1.add(passenger.getFullName() + ", birthday: " + passenger.getBirthday() + ", passport: "
				+ passenger.getPassport());
		passenger1.add("Class: " + ticket.getClas() + ", price: " + (double) ticket.getPrice() / 100 + "$, baggage: "
				+ ticket.getBag() + ", priority boarding and registration: " + ticket.getFirst_reg());
		passenger1.add("Departs from: " + cityFrom.getCity_en() + " to " + cityTo.getCity_en() + " at "
				+ flight.getdAndT() + "   (start ticket price: " + (double) flight.getStartPrice() / 100 + "$)");
		passenger1.add(plane.getModel() + ", bort number: " + plane.getBortNumber() + ", capacity of persons on board: "
				+ plane.getPassengerCount());

		List<TicketFullModel> converted = new ArrayList<>();
		converted.add(entity2model(passenger1));

		return new ResponseEntity<List<TicketFullModel>>(converted, HttpStatus.OK);

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

	private TicketFullModel entity2model(ArrayList<Object> passenger1) {
		TicketFullModel e = new TicketFullModel();
		e.setPassenger(passenger1.get(0).toString());
		e.setTicket(passenger1.get(1).toString());
		e.setFlight(passenger1.get(2).toString());
		e.setPlane(passenger1.get(3).toString());
		return e;
	}

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
