package com.es.tema1.ejerEmail.service;

public interface GenericServiceAPI<K, T>  {

    T get(K email);
    T insert(T u);
    boolean delete(K email);

}
