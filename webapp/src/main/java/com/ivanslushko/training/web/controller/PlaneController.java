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

import com.ivanslushko.training.datamodel.Plane;
import com.ivanslushko.training.services.PlaneService;
import com.ivanslushko.training.web.model.PlaneModel;

@RestController
@RequestMapping("/plane")
public class PlaneController {

	@Inject
	private PlaneService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PlaneModel>> getAll() {
		List<Plane> all = service.getAll();

		List<PlaneModel> converted = new ArrayList<>();
		for (Plane plane : all) {
			converted.add(entity2model(plane));
		}
		return new ResponseEntity<List<PlaneModel>>(converted, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<PlaneModel> getById(@PathVariable Long id) {
		Plane plane = service.get(id);
		return new ResponseEntity<PlaneModel>(entity2model(plane), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createNewPlane(@RequestBody PlaneModel planeModel) {
		service.save(model2entity(planeModel));
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public ResponseEntity<Void> updatePlane(@RequestBody PlaneModel planeModel, @PathVariable Long id) {
		Plane plane = model2entity(planeModel);
		plane.setId(id);

		service.update(plane);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	private PlaneModel entity2model(Plane plane) {
		PlaneModel e = new PlaneModel();
		e.setId(plane.getId());
		e.setBort_number(plane.getBortNumber());
		e.setModel(plane.getModel());
		e.setPassenger_count(plane.getPassengerCount());
		return e;
	}

	private Plane model2entity(PlaneModel planeModel) {
		Plane e = new Plane();
		e.setId(planeModel.getId());
		e.setBortNumber(planeModel.getBort_number());
		e.setModel(planeModel.getModel());
		e.setPassengerCount(planeModel.getPassenger_count());
		return e;
	}
}
