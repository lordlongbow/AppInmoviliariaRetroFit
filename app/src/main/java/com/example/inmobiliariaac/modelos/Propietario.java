package com.example.inmobiliariaac.modelos;

import java.util.Objects;

public class Propietario {

    private int Id;
    private Long Dni;
    private String Nombre;
    private String Apellido;
    private String Email;
    private String Contraseña;
    private String Telefono;
    private String Foto;

    public Propietario() {
    }

    public Propietario(int id, Long dni, String nombre, String apellido, String email, String contraseña, String telefono, String foto) {
        Id = id;
        Dni = dni;
        Nombre = nombre;
        Apellido = apellido;
        Email = email;
        Contraseña = contraseña;
        Telefono = telefono;
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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String foto) {
        Foto = foto;
    }

    @Override
    public String toString() {
        return "Propietario{" +
                "Id=" + Id +
                ", Dni=" + Dni +
                ", Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", Email='" + Email + '\'' +
                ", Contraseña='" + Contraseña + '\'' +
                ", Telefono='" + Telefono + '\'' +
                ", Foto='" + Foto + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Propietario that = (Propietario) o;
        return Id == that.Id && Objects.equals(Dni, that.Dni) && Objects.equals(Nombre, that.Nombre) && Objects.equals(Apellido, that.Apellido) && Objects.equals(Email, that.Email) && Objects.equals(Contraseña, that.Contraseña) && Objects.equals(Telefono, that.Telefono) && Objects.equals(Foto, that.Foto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Dni, Nombre, Apellido, Email, Contraseña, Telefono, Foto);
    }
}
