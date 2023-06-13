package com.example.inmobiliariaac.modelos;

public class Tipo {
    private int tipoId;
    private String descripcion;

    public Tipo() {

    }

    public Tipo(int tipoId, String descripcion) {
        this.tipoId = tipoId;
        this.descripcion = descripcion;
    }

    public int getTipoId() {
        return tipoId;
    }

    public void setTipoId(int tipoId) {
        this.tipoId = tipoId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Tipo{" +
                "tipoId=" + tipoId +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}