package com.idat.vuelos.model.dto;

public class MenuResponse {
    public MenuResponse() {
    }

    private int id;
    private String entrada;
    private String fondo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getFondo() {
        return fondo;
    }

    public void setFondo(String fondo) {
        this.fondo = fondo;
    }
}
