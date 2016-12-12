package com.ivanslushko.training.web.model;

public class FlightModel {

	private Long id;
	private Integer plane;
	private Integer fromm;
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

	public void setFromm(Integer fromm) {
		this.fromm = fromm;
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

	@Override
	public String toString() {
		return "FlightModel [id=" + id + ", plane=" + plane + ", from " + fromm + ", date " + d_and_t + ", to " + too
				+ ", start price:  " + start_price + "$ ]";
	}

	public Double getStart_price() {
		return start_price;
	}

	public void setStart_price(Double start_price) {
		this.start_price = start_price;
	}
}
