package com.idat.vuelos.service;

import com.idat.vuelos.model.dto.FlightResponse;
import com.idat.vuelos.repository.FlightRepository;

import java.util.List;

public interface FlightService {

    void registerFlight(FlightResponse flightRequest);
    List<FlightResponse> getFlights();
}
