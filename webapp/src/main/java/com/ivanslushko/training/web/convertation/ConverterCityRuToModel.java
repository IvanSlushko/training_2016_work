package com.ivanslushko.training.web.convertation;

import org.springframework.core.convert.converter.Converter;

import com.ivanslushko.training.datamodel.City;
import com.ivanslushko.training.web.model.CityModelRu;

public class ConverterCityRuToModel implements Converter<City, CityModelRu> {

	@Override
	public CityModelRu convert(City city) {
		CityModelRu e = new CityModelRu();
		e.setCity(city.getCity_ru());
		e.setId(city.getId());
		return e;
	}
}