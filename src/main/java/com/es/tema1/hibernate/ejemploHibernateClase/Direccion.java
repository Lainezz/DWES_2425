package com.es.tema1.hibernate.ejemploHibernateClase;

import jakarta.persistence.*;

@Entity
@Table(name = "direccion")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "calle", nullable = false, length = 50)
    private String calle;

    @Column(name = "num")
    private int numero;

    @Column(name = "codigo_postal", nullable = false, length = 50)
    private String cp;


    @OneToOne(mappedBy = "direccion", fetch = FetchType.LAZY)
    private Cine cine;


    public Direccion() {

    }

    public Direccion(String calle, int numero, String cp, Cine cine) {
        this.calle = calle;
        this.numero = numero;
        this.cp = cp;
        this.cine = cine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public Cine getCine() {
        return cine;
    }

    public void setCine(Cine cine) {
        this.cine = cine;
    }
}
