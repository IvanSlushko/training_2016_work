package com.ivanslushko.training.web.model;

public class CityModelLocale {

	private Long id;
	private String city;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "CityModelLocale [id=" + id + ", city=" + city + "]";
	}

}
