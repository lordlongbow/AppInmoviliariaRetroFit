package com.example.inmobiliariaac.modelos;

import java.io.Serializable;
import java.util.Objects;

public class Contrato implements Serializable {

    private int ContratoId;
    private String FechaInicio;
    private String FechaFinalizacion;
    private Inquilino inquilino;
    private Inmueble inmueble;


    public Contrato() {

    }

    public Contrato(int contratoId, String fechaInicio, String fechaFinalizacion, Inquilino inquilino, Inmueble inmueble) {
        ContratoId = contratoId;
        FechaInicio = fechaInicio;
        FechaFinalizacion = fechaFinalizacion;
        this.inquilino = inquilino;
        this.inmueble = inmueble;
    }

    public int getContratoId() {
        return ContratoId;
    }

    public void setContratoId(int contratoId) {
        ContratoId = contratoId;
    }

    public String getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        FechaInicio = fechaInicio;
    }

    public String getFechaFinalizacion() {
        return FechaFinalizacion;
    }

    public void setFechaFinalizacion(String fechaFinalizacion) {
        FechaFinalizacion = fechaFinalizacion;
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

    @Override
    public String toString() {
        return "Contrato{" +
                "ContratoId=" + ContratoId +
                ", FechaInicio='" + FechaInicio + '\'' +
                ", FechaFinalizacion='" + FechaFinalizacion + '\'' +
                ", inquilino=" + inquilino +
                ", inmueble=" + inmueble +
                '}';
    }
}
