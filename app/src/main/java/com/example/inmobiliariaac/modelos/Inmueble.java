package com.example.inmobiliariaac.modelos;

import java.io.Serializable;
import java.util.Objects;

public class Inmueble implements Serializable {
    private int InmuebleId;
    private String Direccion;
    private float Precio;
    private int CantAambientes;
    private int Latitud;
    private int Longitud;
    private Tipo Tipo;
    private Uso Uso;
    private boolean Disponibilidad;
    private int PropietarioId;
    private String Foto;

    public Inmueble(){};

    public Inmueble(int inmuebleId, String direccion, float precio, int cantAambientes, int latitud, int longitud, Tipo Tipo, Uso Uso, boolean disponibilidad, int propietarioId, String foto) {
        InmuebleId = inmuebleId;
        Direccion = direccion;
        Precio = precio;
        CantAambientes = cantAambientes;
        Latitud = latitud;
        Longitud = longitud;
        Tipo = Tipo;
        Uso = Uso;
        Disponibilidad = disponibilidad;
        PropietarioId = propietarioId;
        Foto = foto;
    }

    public int getInmuebleId() {
        return InmuebleId;
    }

    public void setInmuebleId(int inmuebleId) {
        InmuebleId = inmuebleId;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float precio) {
        Precio = precio;
    }

    public int getCantAambientes() {
        return CantAambientes;
    }

    public void setCantAambientes(int cantAambientes) {
        CantAambientes = cantAambientes;
    }

    public int getLatitud() {
        return Latitud;
    }

    public void setLatitud(int latitud) {
        Latitud = latitud;
    }

    public int getLongitud() {
        return Longitud;
    }

    public void setLongitud(int longitud) {
        Longitud = longitud;
    }

    public Tipo getTipo() {
        return Tipo;
    }

    public void setTipo(Tipo tipo) {
        Tipo = tipo;
    }

    public Uso getUso() {
        return Uso;
    }

    public void setUso(Uso uso) {
        Uso = uso;
    }

    public boolean isDisponibilidad() {
        return Disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        Disponibilidad = disponibilidad;
    }

    public int getPropietarioId() {
        return PropietarioId;
    }

    public void setPropietarioId(int propietarioId) {
        PropietarioId = propietarioId;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String foto) {
        Foto = foto;
    }

    @Override
    public String toString() {
        return "Inmueble{" +
                "InmuebleId=" + InmuebleId +
                ", Direccion='" + Direccion + '\'' +
                ", Precio=" + Precio +
                ", CantAambientes=" + CantAambientes +
                ", Latitud=" + Latitud +
                ", Longitud=" + Longitud +
                ", Tipo=" + Tipo +
                ", Uso=" + Uso +
                ", Disponibilidad=" + Disponibilidad +
                ", PropietarioId=" + PropietarioId +
                ", Foto='" + Foto + '\'' +
                '}';
    }
}
