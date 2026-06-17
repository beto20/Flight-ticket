package com.idat.vuelos.controller;

import com.idat.vuelos.client.PersonClient;
import com.idat.vuelos.model.dto.FlightRequest;
import com.idat.vuelos.model.dto.FlightResponse;
import com.idat.vuelos.model.dto.PersonRequest;
import com.idat.vuelos.model.dto.PersonResponse;
import com.idat.vuelos.service.FlightService;
import com.idat.vuelos.service.impl.FlightServiceImpl;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("v1/flights")
public class FlightController {

    private static FlightService flightService;
    private PersonClient client;



    public FlightController(FlightServiceImpl flightServiceImpl, PersonClient client) {
        flightService = flightServiceImpl;
        this.client = client;
    }

    @PostMapping("/obtener-cliente")
    public PersonResponse getPerson(@RequestBody PersonRequest request) {
        return client.getPerson(request);
    }

    @GetMapping
    public Iterable<FlightResponse> flights() {
        return flightService.getFlights();
    }

    @PostMapping("/register")
    public void register(@RequestBody FlightRequest flightRequest) {
        flightService.registerFlight(flightRequest);
    }

}
