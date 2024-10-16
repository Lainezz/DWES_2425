package com.es.tema1.hibernate.crudHibernate.service;

import com.es.tema1.hibernate.crudHibernate.model.Departamento;
import com.es.tema1.hibernate.crudHibernate.model.Empleado;
import com.es.tema1.hibernate.crudHibernate.repository.EmpleadosRepository;
import com.es.tema1.hibernate.crudHibernate.repository.EmpleadosRepositoryAPI;

import java.util.List;

public class EmpleadosService {

    EmpleadosRepositoryAPI repository;

    public EmpleadosService() {
        repository = new EmpleadosRepository("unit_Empleados");
    }

    public void insert(Empleado e) {
        repository.insert(e);
    }

    public List<Empleado> findByEdad(int edad) {
        return repository.findByEdad(edad);

    }

}
