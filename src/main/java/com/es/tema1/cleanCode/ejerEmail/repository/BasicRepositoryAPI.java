package com.es.tema1.cleanCode.ejerEmail.repository;

public interface BasicRepositoryAPI<K, T> {

    T get(K email);
    T insert(T u);
    boolean delete(K email);
}
