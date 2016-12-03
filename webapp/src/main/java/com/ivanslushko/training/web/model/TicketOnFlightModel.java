package com.ivanslushko.training.web.model;

import java.sql.Timestamp;

public class TicketOnFlightModel {

	public Integer flNum;
	public Timestamp date;
	public Integer plane;
	public Integer frCity;
	public Integer too;
	public Integer passenger;
	public Integer clas;
	public Double price;
	public Boolean bag;
	private Boolean first_reg;

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
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

	public Boolean getFirst_reg() {
		return first_reg;
	}

	public void setFirst_reg(Boolean first_reg) {
		this.first_reg = first_reg;
	}

	@Override
	public String toString() {
		return "TicketOnFlightModel [flNum=" + flNum + ", date=" + date + ", plane=" + plane + ", frCity=" + frCity
				+ ", too=" + too + ", passenger=" + passenger + ", clas=" + clas + ", price=" + price + ", bag=" + bag
				+ ", first_reg=" + first_reg + "]";
	}

}
