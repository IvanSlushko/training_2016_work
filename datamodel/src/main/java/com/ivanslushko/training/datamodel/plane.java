package com.ivanslushko.training.datamodel;

public class plane extends AbstractModel {

	private String bort_number;
	private String model;
	private String resource;

	public String getBort_number() {
		return bort_number;
	}

	public void setBort_number(String bort_number) {
		this.bort_number = bort_number;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

}
