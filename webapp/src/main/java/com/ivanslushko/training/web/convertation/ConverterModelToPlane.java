package com.ivanslushko.training.web.convertation;

import org.springframework.core.convert.converter.Converter;

import com.ivanslushko.training.datamodel.Plane;
import com.ivanslushko.training.web.model.PlaneModel;

public class ConverterModelToPlane implements Converter<PlaneModel, Plane> {

	@Override
	public Plane convert(PlaneModel planeModel) {
		Plane e = new Plane();
		e.setId(planeModel.getId());
		e.setBortNumber(planeModel.getBort_number());
		e.setModel(planeModel.getModel());
		e.setPassengerCount(planeModel.getPassenger_count());
		System.out.println("CONVERTER  Model  to Plane active <<<<<<<<<");
		return e;
	}
}
