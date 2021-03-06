package com.elterabit.beans;

import java.io.Serializable;

public class Videojuego implements Serializable {

    private String id;
    private String nombre;
    private String plataforma;
    private Integer jugadores;
    private String genero;
    private String desarrollador;
    private String formato;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPlataforma() { return plataforma;  }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public Integer getJugadores() {
        return jugadores;
    }

    public void setJugadores(Integer jugadores) {
        this.jugadores = jugadores;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }
}
