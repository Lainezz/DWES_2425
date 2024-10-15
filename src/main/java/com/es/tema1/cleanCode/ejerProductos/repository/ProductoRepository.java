package com.es.tema1.cleanCode.ejerProductos.repository;

import com.es.tema1.cleanCode.ejerProductos.model.Producto;

import java.util.*;

public class ProductoRepository implements GenericRepositoryAPI<String, Producto> {

    private List<Producto> bddProductos;

    public ProductoRepository() {
        this.bddProductos = new LinkedList<>();
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

    public ArrayList<Producto> getAll() {
        return (ArrayList<Producto>) bddProductos;
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
