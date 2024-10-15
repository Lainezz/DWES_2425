package com.es.tema1.hibernate.ejemploHibernateClase;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cine")
public class Cine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "capacidad", nullable = false)
    private int capacidad;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_direccion")
    private Direccion direccion;


    public Cine() {

    }

    public Cine(String nombre, int capacidad, Direccion direccion) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.direccion = direccion;
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

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}
