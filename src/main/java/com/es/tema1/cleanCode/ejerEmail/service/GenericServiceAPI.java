package com.es.tema1.cleanCode.ejerEmail.service;

public interface GenericServiceAPI<K, T>  {

    T get(K email);
    T insert(T u);
    boolean delete(K email);

}
