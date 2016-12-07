package com.ivanslushko.training.web.model;

public class TicketFullModel {
//	private Long id;
	private String passenger;
	private String ticket;
	private String flight;
	private String plane;

//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}

	public String getPassenger() {
		return passenger;
	}

	public void setPassenger(String passenger) {
		this.passenger = passenger;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getFlight() {
		return flight;
	}

	public void setFlight(String flight) {
		this.flight = flight;
	}

	public String getPlane() {
		return plane;
	}

	public void setPlane(String plane) {
		this.plane = plane;
	}

	@Override
	public String toString() {
		return "TicketFullModel [passenger=" + passenger + ", ticket=" + ticket + ", flight=" + flight
				+ ", plane=" + plane + "]";
	}

}
