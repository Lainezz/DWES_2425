package com.es.tema1.hibernate;

import com.es.tema1.hibernate.crudHibernate.model.Departamento;
import com.es.tema1.hibernate.crudHibernate.model.Empleado;
import com.es.tema1.hibernate.crudHibernate.service.EmpleadosService;
import com.es.tema1.hibernate.crudHibernate.utils.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


public class TestEmpleado {

    @Test
    public void testModelEmpleado() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_Empleados");
        EntityManager em = emf.createEntityManager();

    }

    @Test
    public void testHibernateUtil() {

        //EntityManagerFactory emf = HibernateUtil.getEntityManagerFactory("unit_Empleados");
        EntityManager em = HibernateUtil.getEntityManager("unit_Empleados");

    }

    @Test
    void testHibernateUtil2() {

        //EntityManagerFactory emf = HibernateUtil.getEntityManagerFactory("unit_Empleados");
        ExceptionInInitializerError e = Assertions.assertThrows(ExceptionInInitializerError.class, () ->
                HibernateUtil.getEntityManager("unit_Empleadoscmikejf")
        );

    }

    @Test
    void testInsert() {

        EmpleadosService service = new EmpleadosService();
        Empleado e = new Empleado("Diego", 34, Departamento.INFORMATICA);
        service.insert(e);

        List<Empleado> lista = service.findByEdad(34);
        lista.forEach(System.out::println);

        Empleado e2 = service.getEmpleado(3L);
        System.out.println(e2);
    }
}
