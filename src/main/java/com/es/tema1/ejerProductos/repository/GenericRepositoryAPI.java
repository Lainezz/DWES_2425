package com.es.tema1.ejerProductos.repository;

import java.util.List;

public interface GenericRepositoryAPI<K,T> {

    T insert(T x);
    T get(K key);
    List<T> getAll();
    void delete(K key);
}
