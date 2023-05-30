package com.example.inmobiliariaac.modelos;

public class Uso {
    private int UsoId;
    private String Descripcion;
public Uso(){}

    public Uso(int usoId, String descripcion) {
        UsoId = usoId;
        Descripcion = descripcion;
    }

    public int getUsoId() {
        return UsoId;
    }

    public void setUsoId(int usoId) {
        UsoId = usoId;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Uso{" +
                "UsoId=" + UsoId +
                ", Descripcion='" + Descripcion + '\'' +
                '}';
    }
}
