package com.idat.vuelos.model.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_ticket_vuelo")
public class FlightEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public FlightEntity() {
    }

    private float duracion;
    private String origen;
    private String destino;
    private String tipo; // economic class, business class, regular class
    private String menuOpcion;

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMenuOpcion() {
        return menuOpcion;
    }

    public void setMenuOpcion(String menuOpcion) {
        this.menuOpcion = menuOpcion;
    }
}
