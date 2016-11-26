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
import com.ivanslushko.training.services.CityService;
import com.ivanslushko.training.web.model.CityModel;

@RestController
@RequestMapping("/city")
public class CityController {

	@Inject
	private CityService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CityModel>> getAll() {
		List<City> all = service.getAll();
		
		List<CityModel> converted = new ArrayList<>();
		for (City city : all) {
			converted.add(entity2model(city));
		}
		return new ResponseEntity<List<CityModel>>(converted, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<CityModel> getById(@PathVariable Long id) {
		City city = service.get(id);
		return new ResponseEntity<CityModel>(entity2model(city), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createNewCity(@RequestBody CityModel cityModel) {
		service.save(model2entity(cityModel));
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public ResponseEntity<Void> updateCity(@RequestBody CityModel cityModel, @PathVariable Long id) {
		City city = model2entity(cityModel);
		city.setId(id);
		service.update(city);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	private CityModel entity2model(City city) {
		CityModel e = new CityModel();
		e.setCity(city.getCity());
		e.setId(city.getId());
		return e;
	}

	private City model2entity(CityModel cityModel) {
		City e = new City();
		e.setId(cityModel.getId());
		e.setCity(cityModel.getCity());
		return e;
	}
}
