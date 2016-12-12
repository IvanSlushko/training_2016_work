package com.ivanslushko.training.web.model;

public class FlightFromCityModel {

	private Long id;
	private Integer plane;
	private Integer fromm;
	private String fr_city;
	private String d_and_t;
	private Integer too;
	private Double start_price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPlane() {
		return plane;
	}

	public void setPlane(Integer plane) {
		this.plane = plane;
	}

	public Integer getFromm() {
		return fromm;
	}

	public void setFromm(Integer integer) {
		this.fromm = integer;
	}

	public String getD_and_t() {
		return d_and_t;
	}

	public void setD_and_t(String d_and_t) {
		this.d_and_t = d_and_t;
	}

	public Integer getToo() {
		return too;
	}

	public void setToo(Integer too) {
		this.too = too;
	}

	public String getFr_city() {
		return fr_city;
	}

	public void setFr_city(String fr_city) {
		this.fr_city = fr_city;
	}

	public Double getStart_price() {
		return start_price;
	}

	public void setStart_price(Double start_price) {
		this.start_price = start_price;
	}
	
	@Override
	public String toString() {
		return "FlightFromCityModel city id=" + id + ", from: " + fromm + ", date " + d_and_t + ", date " + d_and_t
				+ ", to: " + too + ", start price:  " + start_price + " ]";
	}
}
