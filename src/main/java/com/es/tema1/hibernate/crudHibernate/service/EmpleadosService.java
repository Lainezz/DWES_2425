package com.es.tema1.hibernate.crudHibernate.service;

import com.es.tema1.hibernate.crudHibernate.model.Empleado;
import com.es.tema1.hibernate.crudHibernate.repository.impl.EmpleadosRepository;
import com.es.tema1.hibernate.crudHibernate.repository.api.EmpleadosRepositoryAPI;

import java.util.List;

public class EmpleadosService {

    private final EmpleadosRepositoryAPI repository;

    public EmpleadosService() {
        repository = new EmpleadosRepository();
    }

    public void insert(Empleado e) {
        try {
            repository.insert(e);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Empleado> findByEdad(int edad) {
        try {
            return repository.findByEdad(edad);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public Empleado getEmpleado(Long id) {
        try {
            return repository.get(id);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
