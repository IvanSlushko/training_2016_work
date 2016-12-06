package com.ivanslushko.training.web.model;

import java.sql.Date;

public class TicketFullModel {
	private Long id;
	private Integer fl_num;
	private Integer passenger;
	private Integer clas;
	private Double price;
	private Boolean bag;
	private Boolean first_reg;
	private String passFN;
	private Date passBirthday;
	private String passport;
	private Integer flPlane;
	private String dAndT;
	private String cityFrom;
	private String cityTo;
	private String bortNum;
	private String planeModel;
	private Integer passengerCount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getFl_num() {
		return fl_num;
	}

	public void setFl_num(Integer fl_num) {
		this.fl_num = fl_num;
	}

	public Integer getPassenger() {
		return passenger;
	}

	public void setPassenger(Integer passenger) {
		this.passenger = passenger;
	}

	public Integer getClas() {
		return clas;
	}

	public void setClas(Integer clas) {
		this.clas = clas;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Boolean getBag() {
		return bag;
	}

	public void setBag(Boolean bag) {
		this.bag = bag;
	}

	public Boolean getFirst_reg() {
		return first_reg;
	}

	public void setFirst_reg(Boolean first_reg) {
		this.first_reg = first_reg;
	}

	public String getPassFN() {
		return passFN;
	}

	public void setPassFN(String passFN) {
		this.passFN = passFN;
	}

	public Date getPassBirthday() {
		return passBirthday;
	}

	public void setPassBirthday(Date passBirthday) {
		this.passBirthday = passBirthday;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public Integer getFlPlane() {
		return flPlane;
	}

	public void setFlPlane(Integer flPlane) {
		this.flPlane = flPlane;
	}

	public String getdAndT() {
		return dAndT;
	}

	public void setdAndT(String dAndT) {
		this.dAndT = dAndT;
	}

	public String getCityFrom() {
		return cityFrom;
	}

	public void setCityFrom(String cityFrom) {
		this.cityFrom = cityFrom;
	}

	public String getCityTo() {
		return cityTo;
	}

	public void setCityTo(String cityTo) {
		this.cityTo = cityTo;
	}

	public String getBortNum() {
		return bortNum;
	}

	public void setBortNum(String bortNum) {
		this.bortNum = bortNum;
	}

	public String getPlaneModel() {
		return planeModel;
	}

	public void setPlaneModel(String planeModel) {
		this.planeModel = planeModel;
	}

	public Integer getPassengerCount() {
		return passengerCount;
	}

	public void setPassengerCount(Integer passengerCount) {
		this.passengerCount = passengerCount;
	}

	@Override
	public String toString() {
		return "TicketFullModel [id=" + id + ", fl_num=" + fl_num + ", passenger=" + passenger + ", clas=" + clas
				+ ", price=" + price + ", bag=" + bag + ", first_reg=" + first_reg + ", passFN=" + passFN
				+ ", passBirthday=" + passBirthday + ", passport=" + passport + ", flPlane=" + flPlane + ", dAndT="
				+ dAndT + ", cityFrom=" + cityFrom + ", cityTo=" + cityTo + ", bortNum=" + bortNum + ", planeModel="
				+ planeModel + ", passengerCount=" + passengerCount + "]";
	}
}
