package com.es.tema1.hibernate.crudHibernate.repository.impl;

import com.es.tema1.hibernate.crudHibernate.repository.api.BasicRepositoryAPI;
import jakarta.persistence.EntityManager;

import java.util.List;

public abstract class BasicRepositoryImpl<K, T> implements BasicRepositoryAPI<K, T> {

    private Class<T> claseObjeto;

    public abstract EntityManager getEntityManager();

    public abstract void closeEntityManager(EntityManager em);

    public BasicRepositoryImpl(Class<T> claseObjeto) {
        this.claseObjeto = claseObjeto;
    }

    @Override
    public T insert(T x) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(x);
            em.getTransaction().commit();
            return x;
        } catch (Exception e) {
            if(em!=null && em.getTransaction() != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new Exception("Error al insertar");
        } finally {
            closeEntityManager(em);
        }
    }

    @Override
    public T get(K key) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            T x = em.find(claseObjeto, key);
            return x;
        } finally {
            closeEntityManager(em);
        }
    }

    @Override
    public List<T> getAll() {
        return null;
    }

    @Override
    public void delete(K key) {

    }

    @Override
    public T update(T x) {
        return null;
    }


}
