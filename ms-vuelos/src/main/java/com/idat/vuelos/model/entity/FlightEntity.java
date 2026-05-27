package com.idat.vuelos.model.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_vuelo")
public class FlightEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private float duracion;
    private String origen;
    private String destino;
    List<MenuEntity> menus;
}
