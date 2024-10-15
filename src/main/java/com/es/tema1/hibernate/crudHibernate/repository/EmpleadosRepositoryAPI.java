package com.es.tema1.hibernate.crudHibernate.repository;

import com.es.tema1.hibernate.crudHibernate.model.Empleado;

import java.util.List;

public interface EmpleadosRepositoryAPI extends BasicRepositoryAPI<Long, Empleado>{

    List<Empleado> findByEdad(int edad);

}
