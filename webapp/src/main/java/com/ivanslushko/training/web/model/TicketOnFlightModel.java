package com.ivanslushko.training.web.model;

import java.sql.Date;

public class TicketOnFlightModel {

	public Integer flNum;
	public Date date;
	public Integer plane;
	public Integer frCity;
	public Integer too;
	public Integer passenger;
	public Integer clas;
	public Double price;
	public Boolean bag;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getToo() {
		return too;
	}

	public void setToo(Integer too) {
		this.too = too;
	}

	public Integer getFrCity() {
		return frCity;
	}

	public void setFrCity(Integer frCity) {
		this.frCity = frCity;
	}

	public Integer getPlane() {
		return plane;
	}

	public void setPlane(Integer plane) {
		this.plane = plane;
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

	public Integer getFlNum() {
		return flNum;
	}

	public void setFlNum(Integer flNum) {
		this.flNum = flNum;
	}

	@Override
	public String toString() {
		return "TicketOnFlightModel [date=" + date + ", too=" + too + ", frCity=" + frCity + ", plane=" + plane
				+ ", passenger=" + passenger + ", clas=" + clas + ", price=" + price + ", bag=" + bag + ", flNum="
				+ flNum + "]";
	}

}
