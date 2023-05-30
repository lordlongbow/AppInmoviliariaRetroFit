package com.example.inmobiliariaac.modelos;

public class Tipo {
    private int TipoId;
private String Descripcion;

public Tipo() {

}

    public Tipo(int tipoId, String descripcion) {
        TipoId = tipoId;
        Descripcion = descripcion;
    }

    public int getTipoId() {
        return TipoId;
    }

    public void setTipoId(int tipoId) {
        TipoId = tipoId;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Tipo{" +
                "TipoId=" + TipoId +
                ", Descripcion='" + Descripcion + '\'' +
                '}';
    }
}
