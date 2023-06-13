package com.example.inmobiliariaac.modelos;

import java.io.Serializable;
import java.util.Objects;

public class Contrato implements Serializable {

    private int contratoId;
    private String fechaInicio;
    private String fechaFinalizacion;
    private Inquilino inquilino;
    private Inmueble inmueble;


    public Contrato() {

    }

    @Override
    public String toString() {
        return "Contrato{" +
                "contratoId=" + contratoId +
                ", fechaInicio='" + fechaInicio + '\'' +
                ", fechaFinalizacion='" + fechaFinalizacion + '\'' +
                ", inquilino=" + inquilino +
                ", inmueble=" + inmueble +
                '}';
    }

    public int getContratoId() {
        return contratoId;
    }

    public void setContratoId(int contratoId) {
        this.contratoId = contratoId;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(String fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public Contrato(int contratoId, String fechaInicio, String fechaFinalizacion, Inquilino inquilino, Inmueble inmueble) {
        this.contratoId = contratoId;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.inquilino = inquilino;
        this.inmueble = inmueble;
    }
}