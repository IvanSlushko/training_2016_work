package com.ivanslushko.training.datamodel;

import java.sql.Date;

public class Flight extends AbstractModel {

	private Integer num;
	private String plane;
	private Integer from;
	private Date dAndT;
	private Integer to;

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getPlane() {
		return plane;
	}

	public void setPlane(String plane) {
		this.plane = plane;
	}

	public Integer getFrom() {
		return from;
	}

	public void setFrom(Integer from) {
		this.from = from;
	}

	public Date getdAndT() {
		return dAndT;
	}

	public void setdAndT(Date dAndT) {
		this.dAndT = dAndT;
	}

	public Integer getTo() {
		return to;
	}

	public void setTo(Integer to) {
		this.to = to;
	}

}
