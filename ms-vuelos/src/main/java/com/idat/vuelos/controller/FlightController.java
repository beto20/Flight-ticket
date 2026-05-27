package com.idat.vuelos.controller;

import com.idat.vuelos.model.dto.FlightResponse;
import com.idat.vuelos.service.FlightService;
import com.idat.vuelos.service.impl.FlightServiceImpl;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("v1/flights")
public class FlightController {

    private static FlightService flightService;

    public FlightController(FlightServiceImpl flightServiceImpl) {
        flightService = flightServiceImpl;
    }

    @GetMapping
    public List<FlightResponse> flights() {
        return flightService.getFlights();
    }

    @PostMapping("/register")
    public void register(@RequestBody FlightResponse flightRequest) {
        flightService.registerFlight(flightRequest);
    }

}
