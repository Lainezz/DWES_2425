package com.es.tema1.hibernate.crudHibernate.model;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "empleados")
public class Empleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "edad")
    private int edad;

    @Enumerated(EnumType.STRING)
    private Departamento dpto;

    public Empleado() {

    }

    public Empleado(String nombre, int edad, Departamento dpto) {
        this.nombre = nombre;
        this.edad = edad;
        this.dpto = dpto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Empleado{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", edad=").append(edad);
        sb.append('}');
        return sb.toString();
    }
}
