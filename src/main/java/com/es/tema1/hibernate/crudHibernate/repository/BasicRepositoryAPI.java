package com.es.tema1.hibernate.crudHibernate.repository;

import java.util.List;

public interface BasicRepositoryAPI<K, T> {


    /**
     * Inserta nuevo objeto en BDD
     * @param x
     * @return
     */
    T insert(T x);

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
