package com.ivanslushko.training.web.model;

import java.sql.Timestamp;

public class FlightModel {

	private Long id;
	private Integer plane;
	private Integer fromm;
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

	public void setFromm(Integer fromm) {
		this.fromm = fromm;
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
		return "FlightModel [id=" + id + ", plane=" + plane + ", from " + fromm + ", date " + d_and_t + ", to " + too
				+ " ]";
	}
}
