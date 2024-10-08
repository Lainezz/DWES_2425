package com.es.tema1.ejemploHibernate;

import com.es.tema1.ejemploHibernate.model.Estudiante;
import com.es.tema1.ejemploHibernate.model.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class AppHiber {


    public static void main(String[] args) {
        /*
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaMySQL");
        EntityManager em = emf.createEntityManager();

        Producto p1 = new Producto("caja", 2);
        Producto p2 = new Producto("tornillo", 2);
        Producto p3 = new Producto("clavo", 2);
        Producto p4 = new Producto("arandela", 2);
        Producto p5 = new Producto("martillo", 2);

        em.getTransaction().begin();

        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.persist(p4);
        em.persist(p5);

        em.getTransaction().commit();*/

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaH2");
        EntityManager em = emf.createEntityManager();

        // Begin transaction
        em.getTransaction().begin();

        // Query the database for all Estudiante records
        List<Estudiante> estudiantes = em.createQuery("SELECT e FROM Estudiante e", Estudiante.class).getResultList();

        // Print out the retrieved Estudiantes
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante);
        }

        // Commit transaction
        em.getTransaction().commit();

        // Close EntityManager and EntityManagerFactory
        em.close();
        emf.close();

    }


}
