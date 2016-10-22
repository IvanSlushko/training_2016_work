package com.ivanslushko.training.datamodel;

public class Plane extends AbstractModel {

	private String bortNumber;
	private String model;
	private Integer passengerCount;

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

	public Integer getPassengerCount() {
		return passengerCount;
	}

	public void setPassengerCount(Integer passengerCount) {
		this.passengerCount = passengerCount;
	}



}
