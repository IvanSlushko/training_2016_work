package com.ivanslushko.training.web.model;

public class PlaneModel {
	private Long id;
	private String bort_number;
	private String model;
	private Integer passenger_count;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Integer getPassenger_count() {
		return passenger_count;
	}

	public void setPassenger_count(Integer passenger_count) {
		this.passenger_count = passenger_count;
	}

	@Override
	public String toString() {
		return "PlaneModel [id=" + id + ", bort №=" + bort_number + ", model " + model + ", passenger count "
				+ passenger_count + " ]";
	}
}
