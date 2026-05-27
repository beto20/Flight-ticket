package com.idat.vuelos.service.impl;

import com.idat.vuelos.model.dto.FlightRequest;
import com.idat.vuelos.model.dto.FlightResponse;
import com.idat.vuelos.model.entity.FlightEntity;
import com.idat.vuelos.model.entity.MenuEntity;
import com.idat.vuelos.model.entity.PersonEntity;
import com.idat.vuelos.repository.FlightRepository;
import com.idat.vuelos.service.FlightService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FlightServiceImpl implements FlightService {

    private static FlightRepository repository;

    public FlightServiceImpl(FlightRepository repository) {
        this.repository = repository;
    }


    @Override
    public void registerFlight(FlightRequest dto) {

        var entity = new FlightEntity();
        entity.setDestino(dto.getDestino());
        entity.setOrigen(dto.getOrigen());
        entity.setDuracion(dto.getDuracion());

        var person = new PersonEntity();
        person.setNombre(dto.getPerson().getNombre());
        person.setApellido(dto.getPerson().getApellido());

        entity.setPerson(person);

        var menus = new ArrayList<MenuEntity>();
        dto.getMenus().forEach(x -> {
            var menu = new MenuEntity();
            menu.setEntrada(x.getEntrada());
            menu.setFondo(x.getFondo());

            menus.add(menu);
        });

        entity.setMenus(menus);

        repository.save(entity);
    }


    @Override
    public Iterable<FlightResponse> getFlights() {
        var entities = repository.findAll();

        var flights = new ArrayList<FlightResponse>();

        entities.forEach(x -> {
            var dto = new FlightResponse();
            dto.setDestino(x.getDestino());
            dto.setOrigen(x.getOrigen());
            dto.setDuracion(x.getDuracion());

            var menus = new ArrayList<FlightResponse.Menu>();

            x.getMenus().forEach(m -> {
                var menu = new FlightResponse.Menu();
                menu.setEntrada(m.getEntrada());
                menu.setFondo(m.getFondo());


                menus.add(menu);
            });

            dto.setMenus(menus);


            flights.add(dto);
        });

        return flights;
    }
}
