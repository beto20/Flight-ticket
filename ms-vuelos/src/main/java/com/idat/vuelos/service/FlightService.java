package com.idat.vuelos.service;

import com.idat.vuelos.model.dto.FlightRequest;
import com.idat.vuelos.model.dto.FlightResponse;


public interface FlightService {

    void registerFlight(FlightRequest flightRequest);
    Iterable<FlightResponse> getFlights();
}
