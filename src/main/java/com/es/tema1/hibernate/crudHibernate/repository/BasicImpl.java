package com.es.tema1.hibernate.crudHibernate.repository;

import com.es.tema1.hibernate.crudHibernate.utils.HibernateUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public abstract class BasicImpl<K, T> implements BasicRepositoryAPI<K, T> {


    protected EntityManager em;

    public BasicImpl(String namePersistenceUnit) {
        this.em = HibernateUtil.getEntityManager(namePersistenceUnit);
    }

    @Override
    public T insert(T x) {

        em.getTransaction().begin();

        em.persist(x);

        em.getTransaction().commit();


        return null;
    }

    @Override
    public T get(K key) {
        return null;
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
