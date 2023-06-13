package com.example.inmobiliariaac.modelos;

public class Uso {
    private int usoId;
    private String descripcion;

    public Uso(int usoId, String descripcion) {
        this.usoId = usoId;
        this.descripcion = descripcion;
    }

    public Uso() {
    }

    public int getUsoId() {
        return usoId;
    }

    public void setUsoId(int usoId) {
        this.usoId = usoId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Uso{" +
                "usoId=" + usoId +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}