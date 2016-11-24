package com.ivanslushko.training.web.model;

public class CityModel {

	private Long id;
	private String city;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "CityModel [id=" + id + ", city=" + city + "]";
	}

}
