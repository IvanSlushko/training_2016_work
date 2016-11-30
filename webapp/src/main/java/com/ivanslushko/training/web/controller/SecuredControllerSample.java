package com.ivanslushko.training.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ivanslushko.training.datamodel.City;
import com.ivanslushko.training.services.CityService;
import com.ivanslushko.training.services.components.UserDataStorage;
import com.ivanslushko.training.web.model.CityModel;

@RestController
@RequestMapping("/secured")
// @RequestMapping("/basicAuthSecured")
public class SecuredControllerSample {

	@Inject
	private ApplicationContext context;
	@Inject
	private CityService service;

	// Authorization: Basic dmFsaWR1c2VyOnZhbGlkcGFzc3dvcmQ=
	// /secured/city

	@RequestMapping(value = "/city", method = RequestMethod.GET)
	public ResponseEntity<List<CityModel>> getAll() {

		UserDataStorage userDataStorage = context.getBean(UserDataStorage.class);
		System.out.println("SampleController: " + userDataStorage);

		List<City> all = service.getAll();
		List<CityModel> converted = new ArrayList<>();
		for (City city : all) {
			converted.add(entity2model(city));
		}
		return new ResponseEntity<List<CityModel>>(converted, HttpStatus.OK);
	}

	private CityModel entity2model(City city) {
		CityModel e = new CityModel();
		e.setCity(city.getCity());
		e.setId(city.getId());
		return e;
	}
}
