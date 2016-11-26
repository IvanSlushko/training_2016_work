package com.ivanslushko.training.web.model;

public class TicketModel {
	private Long id;
	private Integer fl_num;
	private Integer passenger;
	private Integer clas;
	private Integer price;
	private Boolean bag;

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
		return "TicketModel [id=" + id + ", flight №=" + fl_num + ", passenger " + passenger + ", class " + clas
				+ ", price " + price + ", baggage " + bag + " ]";
	}
}
