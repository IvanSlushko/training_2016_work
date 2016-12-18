package com.ivanslushko.training.web.convertation;

import org.springframework.core.convert.converter.Converter;

import com.ivanslushko.training.datamodel.City;
import com.ivanslushko.training.web.model.CityModelEn;

public class ConverterCityEnToModel implements Converter<City, CityModelEn> {

	@Override
	public CityModelEn convert(City city) {
		CityModelEn e = new CityModelEn();
		e.setCity(city.getCity_en());
		e.setId(city.getId());
		return e;
	}
}
