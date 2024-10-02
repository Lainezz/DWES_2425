package com.es.tema1.ejerEmail.repository;

import com.es.tema1.ejerEmail.model.UserEmail;

public interface BasicRepositoryAPI<K, T> {

    T get(K email);
    T insert(T u);
    boolean delete(K email);
}
