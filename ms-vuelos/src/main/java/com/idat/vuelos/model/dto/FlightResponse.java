package com.idat.vuelos.model.dto;

import java.util.List;

public class FlightResponse {
    public FlightResponse() {
    }

    private float duracion;
    private String origen;
    private String destino;
    List<Menu> menus;
    public static class Menu {
        public Menu() {
        }

        private String opcion;
        private String entrada;
        private String fondo;

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

        public String getOpcion() {
            return opcion;
        }

        public void setOpcion(String opcion) {
            this.opcion = opcion;
        }
    }

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

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}
