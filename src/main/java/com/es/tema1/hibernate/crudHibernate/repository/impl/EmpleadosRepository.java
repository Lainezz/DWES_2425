package com.es.tema1.hibernate.crudHibernate.repository.impl;

import com.es.tema1.hibernate.crudHibernate.model.Empleado;
import com.es.tema1.hibernate.crudHibernate.repository.api.EmpleadosRepositoryAPI;
import com.es.tema1.hibernate.crudHibernate.utils.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EmpleadosRepository extends BasicRepositoryImpl<Long, Empleado> implements EmpleadosRepositoryAPI {

    private static final String NAME_PERSISTENCE_UNIT = "unit_Empleados";

    public EmpleadosRepository() {
        super(Empleado.class);
    }
    @Override
    public EntityManager getEntityManager() {
        return HibernateUtil.getEntityManager(NAME_PERSISTENCE_UNIT);
    }
    @Override
    public void closeEntityManager(EntityManager em) {
        HibernateUtil.closeEntityManager(em);
    }


    @Override
    public List<Empleado> findByEdad(int edad) {
        EntityManager em = null;
        try {
            // Abre el EntityManager
            em = getEntityManager();
            String jpql = "SELECT e FROM Empleado e WHERE e.edad = :edad";
            TypedQuery<Empleado> query = em.createQuery(jpql, Empleado.class);
            query.setParameter("edad", edad);
            List<Empleado> listaEmpleados = query.getResultList();

            return listaEmpleados;
        } finally {
            // Cierro el entityManager
            closeEntityManager(em);
        }
    }

}
