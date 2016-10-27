package com.ivanslushko.training.datamodel;

public class Ticket extends AbstractModel {

	private Integer flNum;
	private Integer passenger;
	private Integer clas;
	private Integer price;
	private Boolean bag;

	public Integer getFlNum() {
		return flNum;
	}

	public void setFlNum(Integer flNum) {
		this.flNum = flNum;
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Boolean getBag() {
		return bag;
	}

	public void setBag(Boolean bag) {
		this.bag = bag;
	}
	   @Override
	    public String toString() {
	        return getId() + "FlNumber: " + flNum + ", passenger= " + passenger + " clas " + clas + " price: " + price + " bag " + bag ;
	    }
}
