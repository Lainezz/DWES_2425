package com.es.tema1.hibernate.ejemploHibernateClase;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AppMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadMySQL");
        EntityManager em = emf.createEntityManager();

        // 1º Empezar una transaccion
        em.getTransaction().begin();

        // 2º Se realizan las operaciones que queramos
        // Vamos a hacer un insert
        Director director = new Director("Pepito", "19019019L", null);
        Direccion dir = new Direccion("Calle Senda Perdida", 8, "11010", null);
        Cine cine = new Cine("Yelmo Cines Bahia Sur", 500, dir, director);
        //em.persist(dir);
        em.persist(cine);

        // 3º Para reflejar los cambios en la BD... commit()
        em.getTransaction().commit();

        // em.close();


        // HACER CONSULTA BDD
        // 1º Abrir la transaccción
        // em.getTransaction().begin();

        // 2º Realizar las operaciones. CONSULTA
        Cine cineBusqueda = em.find(Cine.class, 1);

        System.out.println(cineBusqueda.getNombre());
        System.out.println(cineBusqueda.getDireccion().getCalle());






    }
}
