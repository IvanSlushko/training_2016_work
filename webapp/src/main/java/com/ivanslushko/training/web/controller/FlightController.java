package com.ivanslushko.training.web.controller;

import java.sql.Timestamp;
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

import com.ivanslushko.training.datamodel.ActualFlights;
import com.ivanslushko.training.datamodel.Flight;
import com.ivanslushko.training.datamodel.FlightFromCity;
import com.ivanslushko.training.services.FlightService;
import com.ivanslushko.training.web.model.ActualFlightsModel;
import com.ivanslushko.training.web.model.FlightFromCityModel;
import com.ivanslushko.training.web.model.FlightModel;

@RestController
@RequestMapping("/flight")
public class FlightController {

	@Inject
	private FlightService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<FlightModel>> getAll() {
		List<Flight> all = service.getAll();

		List<FlightModel> converted = new ArrayList<>();
		for (Flight flight : all) {
			converted.add(entity2model(flight));
		}
		return new ResponseEntity<List<FlightModel>>(converted, HttpStatus.OK);
	}

	@RequestMapping(value = "/ffc/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<FlightFromCityModel>> getFromCity(@PathVariable Long id) {
		List<FlightFromCity> all = service.getFromCity(id);

		List<FlightFromCityModel> converted = new ArrayList<>();
		for (FlightFromCity flightFromCity : all) {
			converted.add(entity2model(flightFromCity));
		}
		return new ResponseEntity<List<FlightFromCityModel>>(converted, HttpStatus.OK);
	}

	@RequestMapping(value = "/af", method = RequestMethod.GET)
	public ResponseEntity<List<ActualFlightsModel>> getActualFlifhts() {
		List<ActualFlights> all = service.actualFlights();

		List<ActualFlightsModel> converted = new ArrayList<>();
		for (ActualFlights actualFlightsModel : all) {
			converted.add(entity2model(actualFlightsModel));
		}
		return new ResponseEntity<List<ActualFlightsModel>>(converted, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<FlightModel> getById(@PathVariable Long id) {
		Flight flight = service.get(id);
		return new ResponseEntity<FlightModel>(entity2model(flight), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createNewFlight(@RequestBody FlightModel flightModel) {
		service.save(model2entity(flightModel));
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public ResponseEntity<Void> updateFlight(@RequestBody FlightModel flightModel, @PathVariable Long id) {
		Flight flight = model2entity(flightModel);
		flight.setId(id);
		service.update(flight);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	private FlightFromCityModel entity2model(FlightFromCity flightFromCity) {
		FlightFromCityModel e = new FlightFromCityModel();
		e.setId(flightFromCity.getFlight().getId());
		e.setPlane(flightFromCity.getFlight().getPlane());
		e.setFromm(flightFromCity.getFlight().getFromm());
		e.setFr_city((String) flightFromCity.getFrCity());
		e.setD_and_t(flightFromCity.getFlight().getdAndT().toString());
		e.setToo(flightFromCity.getFlight().getToo());
		e.setStart_price((double)(flightFromCity.getFlight().getStartPrice())/100);
		return e;
	}

	private ActualFlightsModel entity2model(ActualFlights actualFlights) {
		ActualFlightsModel e = new ActualFlightsModel();
		e.setId(actualFlights.getId());
		e.setPlane(actualFlights.getPlane());
		e.setFromm(actualFlights.getFromm());
		e.setD_and_t(actualFlights.getdAndT().toString());
		e.setToo(actualFlights.getToo());
		e.setStart_price((double)(actualFlights.getStartPrice())/100);
		return e;
	}

	private FlightModel entity2model(Flight flight) {
		FlightModel e = new FlightModel();
		e.setId(flight.getId());
		e.setPlane(flight.getPlane());
		e.setFromm(flight.getFromm());
		e.setD_and_t(flight.getdAndT().toString());
		e.setToo(flight.getToo());
		e.setStart_price((double)(flight.getStartPrice())/100);
		return e;
	}

	private Flight model2entity(FlightModel flightModel) {
		Flight e = new Flight();
		e.setId(flightModel.getId());
		e.setPlane(flightModel.getPlane());
		e.setFromm(flightModel.getFromm());
		e.setdAndT(Timestamp.valueOf(flightModel.getD_and_t()));
		e.setToo(flightModel.getToo());
		e.setStartPrice((int) (flightModel.getStart_price().doubleValue() * 100+0.01));
		return e;
	}
}
