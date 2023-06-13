package com.example.inmobiliariaac.modelos;

public class Usuario {
   private String email;
   private String contraseña;

   public Usuario(String email, String contraseña) {
      this.email = email;
      this.contraseña = contraseña;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public void setContraseña(String contraseña) {
      this.contraseña = contraseña;
   }
}
