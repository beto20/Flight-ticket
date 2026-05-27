package com.idat.vuelos.service.impl;

import com.idat.vuelos.model.dto.FlightResponse;
import com.idat.vuelos.repository.FlightRepository;
import com.idat.vuelos.service.FlightService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    private static FlightRepository repository;

    public FlightServiceImpl(FlightRepository repository) {
        this.repository = repository;
    }

    private List<FlightResponse> flights = new ArrayList<FlightResponse>();

    @Override
    public void registerFlight(FlightResponse flightRequest) {
//        flights.add(flightRequest);
        repository.save();
    }


    @Override
    public List<FlightResponse> getFlights() {
        var menu1 = new FlightResponse.Menu();
        menu1.setEntrada("Ocopa");
        menu1.setFondo("Tallarines");

        var menu2 = new FlightResponse.Menu();
        menu2.setEntrada("Sopa");
        menu2.setFondo("Estofado");

        var f1 = new FlightResponse();
        f1.setDuracion(3.5f);
        f1.setOrigen("Lima");
        f1.setDestino("Chiclayo");
        f1.setMenus(List.of(menu1, menu2));

        var f2 = new FlightResponse();
        f2.setDuracion(12.5f);
        f2.setOrigen("Boston");
        f2.setDestino("Lima");
        f2.setMenus(List.of(menu2));

//        return List.of(f1, f2);
        return flights;
    }
}
