package com.ivanslushko.training.web.controller;

import java.sql.Date;
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
import com.ivanslushko.training.services.PassengerService;
import com.ivanslushko.training.web.model.PassengerModel;

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
		return new ResponseEntity<List<PassengerModel>>(converted, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<PassengerModel> getById(@PathVariable Long id) {
		Passenger passenger = service.get(id);
		return new ResponseEntity<PassengerModel>(entity2model(passenger), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createNewPassenger(@RequestBody PassengerModel passengerModel) {
		service.save(model2entity(passengerModel));
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public ResponseEntity<Void> updatePassenger(@RequestBody PassengerModel passengerModel, @PathVariable Long id) {
		Passenger passenger = model2entity(passengerModel);
		passenger.setId(id);
		service.update(passenger);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
	@RequestMapping(value = "/fbf/{full_name}", method = RequestMethod.GET)
	public ResponseEntity<List<PassengerModel>> getByFullName(@PathVariable String full_name) {
		List<Passenger> all = service.findByFullName(full_name);
		List<PassengerModel> converted = new ArrayList<>();
			
		if (null != all) {
			for (Passenger passenger : all) {
				converted.add(entity2model(passenger));
			}
			return new ResponseEntity<List<PassengerModel>>(converted, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	

	@RequestMapping(value = "/fbb/{birthday}", method = RequestMethod.GET)
	public ResponseEntity<List<PassengerModel>> getByBirthday(@PathVariable Date birthday) {
		List<Passenger> all = service.findByBirthday(birthday);
		List<PassengerModel> converted = new ArrayList<>();
		for (Passenger passenger : all) {
			converted.add(entity2model(passenger));
		}
		return new ResponseEntity<List<PassengerModel>>(converted, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/fbp/{passport}", method = RequestMethod.GET)
	public ResponseEntity<List<PassengerModel>> getByPassport(@PathVariable String passport) {
		List<Passenger> all = service.findByPassport(passport);
		List<PassengerModel> converted = new ArrayList<>();
		for (Passenger passenger : all) {
			converted.add(entity2model(passenger));
		}
		return new ResponseEntity<List<PassengerModel>>(converted, HttpStatus.OK);
	}
	
	
//	@RequestMapping(value = "/fbp/{passport}", method = RequestMethod.GET)
//	public ResponseEntity<List<PassengerModel>> getByPassport(@PathVariable String passport) {
//		List<Passenger> all = service.findByFullName(passport);
//		List<PassengerModel> converted = new ArrayList<>();
//		for (Passenger passenger : all) {
//			converted.add(entity2model(passenger));
//		}
//		return new ResponseEntity<List<PassengerModel>>(converted, HttpStatus.OK);
//	}
	
	private PassengerModel entity2model(Passenger passenger) {
		PassengerModel e = new PassengerModel();
		e.setId(passenger.getId());
		e.setFull_name(passenger.getFullName());
		e.setBirthday(passenger.getBirthday());
		e.setPassport(passenger.getPassport());
		return e;
	}

	private Passenger model2entity(PassengerModel passengerModel) {
		Passenger e = new Passenger();
		e.setId(passengerModel.getId());
		e.setFullName(passengerModel.getFull_name());
		e.setBirthday(passengerModel.getBirthday());
		e.setPassport(passengerModel.getPassport());
		return e;
	}
}
