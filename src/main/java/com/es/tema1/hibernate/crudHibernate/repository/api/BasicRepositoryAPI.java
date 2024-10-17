package com.es.tema1.hibernate.crudHibernate.repository.api;

import jakarta.persistence.EntityManager;

import java.util.List;

public interface BasicRepositoryAPI<K, T> {


    EntityManager getEntityManager();
    void closeEntityManager(EntityManager em);

    /**
     * Inserta nuevo objeto en BDD
     * @param x
     * @return
     */
    T insert(T x) throws Exception;

    /**
     * Obtiene un registro de la BDD
     * @param key
     * @return
     */
    T get(K key);

    /**
     * Obtiene todos los registros de una tabla
     * @return
     */
    List<T> getAll();

    /**
     * Elimina un registro de la tabla por id
     * @param key
     */
    void delete(K key);

    /**
     * Actualiza un registro de la tabla
     * @param x
     * @return
     */
    T update(T x);

}
