package com.ivanslushko.training.datamodel;

import java.sql.Date;

public class Flight extends AbstractModel {

	private Integer plane;
	private Integer fromm;
	private Date dAndT;
	private Integer too;

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

	public Date getdAndT() {
		return dAndT;
	}

	public void setdAndT(Date dAndT) {
		this.dAndT = dAndT;
	}

	public Integer getToo() {
		return too;
	}

	public void setToo(Integer too) {
		this.too = too;
	}

	@Override
	public String toString() {
		return "Reys " + getId() + ", plane= " + plane + ", from " + fromm + " city at date " + dAndT + " to " + too
				+ " city. ";
	}

}
