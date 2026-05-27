package com.idat.vuelos.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_menu")
public class MenuEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String entrada;
    private String fondo;
}
