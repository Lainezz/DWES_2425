package com.es.tema1.ejerProductos.repository;

import com.es.tema1.ejerProductos.model.Empleado;
import com.es.tema1.ejerProductos.model.Producto;

import java.util.*;

public class ProductoRepository implements GenericRepositoryAPI<String, Producto> {

    private List<Producto> bddProductos;

    public ProductoRepository() {
        this.bddProductos = new ArrayList<>();
    }

    // C
    public Producto insert(Producto x) {
        this.bddProductos.add(x);
        return get(x.getId());
    }

    // R
    public Producto get(String key) {
        return bddProductos
                .stream()
                .filter(e -> e.getId().equals(key))
                .findFirst()
                .orElse(null);
    }

    public List<Producto> getAll() {
        return bddProductos.stream().toList();
    }

    // U
    // TODO: hacer U

    // D
    public void delete(String key) {
        Producto prodToDelete = bddProductos
                .stream()
                .filter(e -> e.getId().equals(key))
                .findFirst()
                .orElse(null);

        bddProductos.remove(prodToDelete);
    }
}
