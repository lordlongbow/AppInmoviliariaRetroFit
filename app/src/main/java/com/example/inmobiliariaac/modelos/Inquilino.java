package com.example.inmobiliariaac.modelos;

public class Inquilino {

    private int Id;
    private Long Dni;
    private String Nombre;
    private String Apellido;
    private String Telefono;
    private String Domicilio;
    private String Foto;

    public Inquilino() {}

    public Inquilino(int id, Long dni, String nombre, String apellido, String telefono, String domicilio, String foto) {
        Id = id;
        Dni = dni;
        Nombre = nombre;
        Apellido = apellido;
        Telefono = telefono;
        Domicilio = domicilio;
        Foto = foto;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Long getDni() {
        return Dni;
    }

    public void setDni(Long dni) {
        Dni = dni;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getDomicilio() {
        return Domicilio;
    }

    public void setDomicilio(String domicilio) {
        Domicilio = domicilio;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String foto) {
        Foto = foto;
    }

    @Override
    public String toString() {
        return "Inquilino{" +
                "Id=" + Id +
                ", Dni=" + Dni +
                ", Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", Telefono='" + Telefono + '\'' +
                ", Domicilio='" + Domicilio + '\'' +
                ", Foto='" + Foto + '\'' +
                '}';
    }
}
