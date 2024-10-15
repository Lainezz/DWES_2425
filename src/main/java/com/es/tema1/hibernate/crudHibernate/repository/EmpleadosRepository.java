package com.es.tema1.hibernate.crudHibernate.repository;

import com.es.tema1.hibernate.crudHibernate.model.Empleado;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EmpleadosRepository extends BasicImpl<Long, Empleado> implements EmpleadosRepositoryAPI{
    public EmpleadosRepository(String namePersistenceUnit) {
        super(namePersistenceUnit);
    }

    @Override
    public List<Empleado> findByEdad(int edad) {
        em.getTransaction().begin();

        String jpql = "SELECT e FROM Empleado e WHERE e.edad = :edad";
        TypedQuery<Empleado> query = em.createQuery(jpql, Empleado.class);
        query.setParameter("edad", edad);
        return query.getResultList();
    }

    /*
    @Override
    public Empleado insert(Empleado newEmp) {

        return null;
    }

    @Override
    public Empleado get(Long id) {
        return null;
    }

    @Override
    public List<Empleado> getAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Empleado update(Empleado updatedEmp) {
        return null;
    }

    @Override
    public List<Empleado> findByEdad(int edad) {
        return null;
    }

    */
}
