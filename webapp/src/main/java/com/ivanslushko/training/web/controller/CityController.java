package com.ivanslushko.training.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ivanslushko.training.datamodel.City;
import com.ivanslushko.training.services.CityService;
import com.ivanslushko.training.web.model.CityModel;
import com.ivanslushko.training.web.model.CityModelBy;
import com.ivanslushko.training.web.model.CityModelEn;
import com.ivanslushko.training.web.model.CityModelLocale;
import com.ivanslushko.training.web.model.CityModelRu;

@RestController
@RequestMapping("/city")
public class CityController {

	@Inject
	private CityService service;

	@Inject
	ConversionService conversionService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CityModelLocale>> getAll(
			@RequestParam(value = "locale", defaultValue = "en") String locale) {

		List<City> all = service.getAll();
		List<CityModelLocale> converted = new ArrayList<>();

		if (locale.equals("en")) {
			for (City city : all) {
				converted.add(conversionService.convert(city, CityModelEn.class));
			}
		}
		if (locale.equals("ru")) {
			for (City city : all) {
				converted.add(conversionService.convert(city, CityModelRu.class));
			}
		}
		if (locale.equals("by")) {
			for (City city : all) {
				converted.add(conversionService.convert(city, CityModelBy.class));
			}
		}

		return new ResponseEntity<List<CityModelLocale>>(converted, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<CityModelLocale> getById(@RequestParam(value = "locale", defaultValue = "en") String locale,
			@PathVariable Long id) {
		City city = service.get(id);

		CityModelLocale cityModelLocale = null;

		if (locale.equals("en")) {
			cityModelLocale = conversionService.convert(city, CityModelEn.class);
		}
		if (locale.equals("ru")) {
			cityModelLocale = conversionService.convert(city, CityModelRu.class);
		}
		if (locale.equals("by")) {
			cityModelLocale = conversionService.convert(city, CityModelBy.class);
		}
		return new ResponseEntity<CityModelLocale>(cityModelLocale, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createNewCity(@RequestBody CityModel cityModel) {
		service.save(conversionService.convert(cityModel, City.class));
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public ResponseEntity<Void> updateCity(@RequestBody CityModel cityModel, @PathVariable Long id) {
		City city = conversionService.convert(cityModel, City.class);
		city.setId(id);
		service.update(city);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/*
	 * private CityModel entity2model(City city) { CityModel e = new
	 * CityModel(); e.setCity_ru(city.getCity_ru());
	 * e.setCity_en(city.getCity_en()); e.setCity_by(city.getCity_by());
	 * e.setId(city.getId()); return e; }
	 */

	/*
	 * private City model2entity(CityModel cityModel) { City e = new City();
	 * e.setId(cityModel.getId()); e.setCity_ru(cityModel.getCity_ru());
	 * e.setCity_en(cityModel.getCity_en());
	 * e.setCity_by(cityModel.getCity_by());
	 * 
	 * return e; }
	 */
}
