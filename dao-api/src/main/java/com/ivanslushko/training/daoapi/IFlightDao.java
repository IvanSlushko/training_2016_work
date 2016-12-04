package com.ivanslushko.training.daoapi;

import java.util.List;

import com.ivanslushko.training.datamodel.ActualFlights;
import com.ivanslushko.training.datamodel.Flight;
import com.ivanslushko.training.datamodel.FlightFromCity;

public interface IFlightDao extends IAbstractDao<Flight> {

	List<FlightFromCity> getFromCity(Long id);

	List<ActualFlights> actualFlights();
}
