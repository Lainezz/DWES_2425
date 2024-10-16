package com.es.tema1.hibernate.ejemploHibernateClase;

import jakarta.persistence.*;

@Entity
@Table(name="directores")
public class Director {

    @Column(name="nombre", nullable = false)
    private String nombre;

    @Id
    private String dni;

    @OneToOne(mappedBy = "director", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Cine cine;

    public Director() {}

    public Director(String nombre, String dni, Cine cine) {
        this.nombre = nombre;
        this.dni = dni;
        this.cine = cine;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Cine getCine() {
        return cine;
    }

    public void setCine(Cine cine) {
        this.cine = cine;
    }
}
