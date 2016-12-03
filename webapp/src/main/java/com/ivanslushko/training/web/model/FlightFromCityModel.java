package com.ivanslushko.training.web.model;

import java.sql.Timestamp;

public class FlightFromCityModel {

	private Long id;
	private Integer plane;
	private Integer fromm;
	private String fr_city;
	private Timestamp d_and_t;
	private Integer too;

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

	public Timestamp getD_and_t() {
		return d_and_t;
	}

	public void setD_and_t(Timestamp d_and_t) {
		this.d_and_t = d_and_t;
	}

	public Integer getToo() {
		return too;
	}

	public void setToo(Integer too) {
		this.too = too;
	}

	@Override
	public String toString() {
		return "FlightFromCityModel city id=" + id + ", from: " + fromm + ", date " + d_and_t + ", date " + d_and_t
				+ ", to: " + too + " ]";
	}

	public String getFr_city() {
		return fr_city;
	}

	public void setFr_city(String fr_city) {
		this.fr_city = fr_city;
	}

}
