package com.ivanslushko.training.datamodel;

public class Plane extends AbstractModel {

	private String bortNumber;
	private String model;
	private String passengerCount;

	public String getBort_number() {
		return bortNumber;
	}

	public void setBort_number(String bort_number) {
		this.bortNumber = bort_number;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getResource() {
		return passengerCount;
	}

	public void setResource(String resource) {
		this.passengerCount = resource;
	}

}
