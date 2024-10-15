package com.es.tema1.cleanCode.ejerProductos.repository;

import com.es.tema1.cleanCode.ejerProductos.model.Empleado;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoRepository implements GenericRepositoryAPI<String, Empleado> {

    private ArrayList<Empleado> bddEmpleados;

    public EmpleadoRepository() {
        this.bddEmpleados = new ArrayList<>();
    }

    // C
    public Empleado insert(Empleado empleado) {
        this.bddEmpleados.add(empleado);
        return get(empleado.getDni());
    }

    // R
    public Empleado get(String key) {
        return bddEmpleados
                .stream()
                .filter(e -> e.getDni().equals(key))
                .findFirst()
                .orElse(null);
    }

    public List<Empleado> getAll() {
        return bddEmpleados;
    }

    // U
    // TODO: hacer U

    // D
    public void delete(String key) {
        Empleado empToDelete = bddEmpleados
                .stream()
                .filter(e -> e.getDni().equals(key))
                .findFirst()
                .orElse(null);
        bddEmpleados.remove(empToDelete);
    }
}
