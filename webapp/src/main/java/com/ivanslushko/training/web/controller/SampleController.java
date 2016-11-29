package com.ivanslushko.training.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ivanslushko.training.services.components.UserDataStorage;
import com.ivanslushko.training.web.model.CityModel;

@RestController
@RequestMapping("/basicAuthSecured")
public class SampleController {
	@Inject
	private ApplicationContext context;

	// Authorization: Basic dmFsaWR1c2VyOnZhbGlkcGFzc3dvcmQ=

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CityModel>> getAll() {
		UserDataStorage userDataStorage = context.getBean(UserDataStorage.class);
		System.out.println("SampleController:" + userDataStorage);

		return new ResponseEntity<List<CityModel>>((MultiValueMap<String, String>) new ArrayList<>(), HttpStatus.OK);
	}

}
