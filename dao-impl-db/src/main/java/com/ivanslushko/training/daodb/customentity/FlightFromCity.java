package com.ivanslushko.training.daodb.customentity;

import com.ivanslushko.training.datamodel.City;
import com.ivanslushko.training.datamodel.Flight;

public class FlightFromCity {

	private City city;
	private Flight flight;

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Flight getFlight() {
		return flight;
	}

	public  void setFlight(Flight flight) {
		this.flight = flight;
	}

}
