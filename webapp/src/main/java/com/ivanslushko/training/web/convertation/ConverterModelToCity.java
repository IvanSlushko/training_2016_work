package com.ivanslushko.training.web.convertation;

import org.springframework.core.convert.converter.Converter;

import com.ivanslushko.training.datamodel.City;
import com.ivanslushko.training.web.model.CityModel;

public class ConverterModelToCity implements Converter<CityModel, City> {

	@Override
	public City convert(CityModel cityModel) {
		City e = new City();
		e.setId(cityModel.getId());
		e.setCity_ru(cityModel.getCity_ru());
		e.setCity_en(cityModel.getCity_en());
		e.setCity_by(cityModel.getCity_by());
		return e;
	}
}
