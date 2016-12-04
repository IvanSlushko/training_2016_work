package com.ivanslushko.training.web.model;

public class ActualFlightsModel {

	private Long id;
	private Integer plane;
	private Integer fromm;
	private String d_and_t;
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
		return "ActualFlightsModel [id=" + id + ", plane=" + plane + ", fromm=" + fromm + 
				", d_and_t=" + d_and_t + ", too=" + too + "]";
	}
	
}
