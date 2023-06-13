package com.example.inmobiliariaac.modelos;

import java.util.Objects;

public class Propietario {

    private int id;
    private int dni;
    private String nombre;
    private String apellido;
    private String email;
    private String contraseña;
    private String domicilio;
    private String telefono;
    private String foto;

    public Propietario() {
    }

    public Propietario(int id, int dni, String nombre, String apellido, String email, String contraseña, String domicilio, String telefono, String foto) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contraseña = contraseña;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Propietario{" +
                "Id=" + id +
                ", Dni=" + dni +
                ", Nombre='" + nombre + '\'' +
                ", Apellido='" + apellido + '\'' +
                ", Email='" + email + '\'' +
                ", Contraseña='" + contraseña + '\'' +
                ", Telefono='" + telefono + '\'' +
                ", Foto='" + foto + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Propietario that = (Propietario) o;
        return id == that.id && Objects.equals(dni, that.dni) && Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido) && Objects.equals(email, that.email) && Objects.equals(contraseña, that.contraseña) && Objects.equals(telefono, that.telefono) && Objects.equals(foto, that.foto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dni, nombre, apellido, email, contraseña, telefono, foto);
    }
}
