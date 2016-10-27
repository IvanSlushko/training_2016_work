package com.ivanslushko.training.datamodel;

public class Plane extends AbstractModel {

	private String bortNumber;
	private String model;
	private Integer passengerCount;

	public String getBortNumber() {
		return bortNumber;
	}

	public void setBortNumber(String bortNumber) {
		this.bortNumber = bortNumber;
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

	   @Override
	    public String toString() {
	        return getId() + "Plane with bort_num: " + bortNumber + ", have model " + model + ", capacity: " + passengerCount ;
	    }
}
