
package com.ivanslushko.training.web.convertation;

import org.springframework.core.convert.converter.Converter;

import com.ivanslushko.training.datamodel.Plane;
import com.ivanslushko.training.web.model.PlaneModel;

public class ConverterPlaneToModel implements Converter<Plane, PlaneModel> {

	@Override
	public PlaneModel convert(Plane plane) {
		PlaneModel e = new PlaneModel();
		e.setId(plane.getId());
		e.setBort_number(plane.getBortNumber());
		e.setModel(plane.getModel());
		e.setPassenger_count(plane.getPassengerCount());
		System.out.println("CONVERTER  Plane to MODEL active <<<<<<<<<");
		return e;
	}
}
