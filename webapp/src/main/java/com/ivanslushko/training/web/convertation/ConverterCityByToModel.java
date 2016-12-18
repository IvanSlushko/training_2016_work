package com.ivanslushko.training.web.convertation;

import org.springframework.core.convert.converter.Converter;

import com.ivanslushko.training.datamodel.City;
import com.ivanslushko.training.web.model.CityModelBy;

public class ConverterCityByToModel implements Converter<City, CityModelBy> {

	@Override
	public CityModelBy convert(City city) {
		CityModelBy e = new CityModelBy();
		e.setCity(city.getCity_by());
		e.setId(city.getId());
		return e;
	}
}