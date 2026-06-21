package com.idat.vuelos.service.impl;

import com.idat.vuelos.client.MenuClient;
import com.idat.vuelos.client.PersonClient;
import com.idat.vuelos.model.dto.*;
import com.idat.vuelos.model.entity.FlightEntity;
import com.idat.vuelos.model.mapper.PersonMapper;
import com.idat.vuelos.repository.FlightRepository;
import com.idat.vuelos.service.FlightService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    private static FlightRepository repository;
    private static PersonClient personClient;
    private static MenuClient menuClient;

    public FlightServiceImpl(FlightRepository repository, PersonClient personClient, MenuClient menuClient) {
        this.repository = repository;
        this.personClient = personClient;
        this.menuClient = menuClient;
    }


    @Override
    public void registerFlight(FlightRequest dto) {
        var entity = new FlightEntity();
        entity.setDestino(dto.getDestino());
        entity.setOrigen(dto.getOrigen());
        entity.setDuracion(dto.getDuracion());

//        entity.setPerson(PersonMapper.MAPPER.toPersonEntity(getPersonInformation(dto.getPerson())));
        entity.setTipo(dto.getTipo());

        getMenusInformation().forEach(x -> {
            System.out.println("TIPO: "+ x.getTipo());
            System.out.println("DTO: "+ dto.getTipo());
            if (x.getTipo().contains(dto.getTipo())) {

                System.out.println("getOpcion: "+ x.getOpcion());

                entity.setMenuOpcion(x.getOpcion());
            }
        });

        repository.save(entity);
    }

    private PersonResponse getPersonInformation(FlightRequest.Person dto) {
        return personClient.getPerson(PersonMapper.MAPPER.toPersonRequest(dto));
    }

    private List<MenuResponse> getMenusInformation() {
        return menuClient.getMenus();
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

            getMenusInformation().forEach(m -> {
                var menu = new FlightResponse.Menu();
                menu.setOpcion(m.getOpcion());
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
