package com.example.inmobiliariaac.modelos;

import java.io.Serializable;
import java.util.Objects;

public class Inmueble implements Serializable {
    private int inmuebleId;
    private String direccion;
    private double precio;
    private int cantAmbientes;
    private double latitud;
    private double longitud;
    private Tipo tipo;
    private int tipoId;
    private Uso uso;
    private int usoId;
    private boolean disponibilidad;
    private int propietarioId;
    private String foto;

    public Inmueble() {
    }

    public Inmueble(int inmuebleId, String direccion, double precio, int cantAmbientes, double latitud, double longitud, Tipo tipo, int tipoId, Uso uso, int usoId, boolean disponibilidad, int propietarioId, String foto) {
        this.inmuebleId = inmuebleId;
        this.direccion = direccion;
        this.precio = precio;
        this.cantAmbientes = cantAmbientes;
        this.latitud = latitud;
        this.longitud = longitud;
        this.tipo = tipo;
        this.tipoId = tipoId;
        this.uso = uso;
        this.usoId = usoId;
        this.disponibilidad = disponibilidad;
        this.propietarioId = propietarioId;
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Inmueble{" +
                "inmuebleId=" + inmuebleId +
                ", direccion='" + direccion + '\'' +
                ", precio=" + precio +
                ", cantAambientes=" + cantAmbientes +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", tipo=" + tipo +
                ", tipoId=" + tipoId +
                ", uso=" + uso +
                ", usoId=" + usoId +
                ", disponibilidad=" + disponibilidad +
                ", propietarioId=" + propietarioId +
                ", foto='" + foto + '\'' +
                '}';
    }

    public int getInmuebleId() {
        return inmuebleId;
    }

    public void setInmuebleId(int inmuebleId) {
        this.inmuebleId = inmuebleId;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantAmbientes() {
        return cantAmbientes;
    }

    public void setCantAmbientes(int cantAmbientes) {
        this.cantAmbientes = cantAmbientes;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getTipoId() {
        return tipoId;
    }

    public void setTipoId(int tipoId) {
        this.tipoId = tipoId;
    }

    public Uso getUso() {
        return uso;
    }

    public void setUso(Uso uso) {
        this.uso = uso;
    }

    public int getUsoId() {
        return usoId;
    }

    public void setUsoId(int usoId) {
        this.usoId = usoId;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getPropietarioId() {
        return propietarioId;
    }

    public void setPropietarioId(int propietarioId) {
        this.propietarioId = propietarioId;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}