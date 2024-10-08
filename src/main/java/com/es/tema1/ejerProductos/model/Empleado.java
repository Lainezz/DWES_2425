package com.es.tema1.ejerProductos.model;

public class Empleado {

    private String dni;
    private String nombre;
    private String dpto;
    private String email;

    public Empleado(String dni, String nombre, String dpto, String email) {
        this.dni = dni;
        this.nombre = nombre;
        this.dpto = dpto;
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDpto() {
        return dpto;
    }

    public void setDpto(String dpto) {
        this.dpto = dpto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
