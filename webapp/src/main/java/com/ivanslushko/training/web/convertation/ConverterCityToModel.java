package com.ivanslushko.training.web.convertation;

import org.springframework.core.convert.converter.Converter;

import com.ivanslushko.training.datamodel.City;
import com.ivanslushko.training.web.model.CityModel;

public class ConverterCityToModel implements Converter<City, CityModel> {

	@Override
	public CityModel convert(City city) {
		CityModel e = new CityModel();
		e.setCity_ru(city.getCity_ru());
		e.setCity_en(city.getCity_en());
		e.setCity_by(city.getCity_by());
		e.setId(city.getId());
		return e;
	}

}
