package com.es.tema1.cleanCode.ejerProductos.service;

import com.es.tema1.cleanCode.ejerProductos.model.Producto;
import com.es.tema1.cleanCode.ejerProductos.repository.GenericRepositoryAPI;
import com.es.tema1.cleanCode.ejerProductos.repository.ProductoRepository;

public class ProductoService {

    private GenericRepositoryAPI<String, Producto> repository;

    public ProductoService() {
        this.repository = new ProductoRepository();
    }

    public Producto insert(Producto newProduct) {
        // Hacemos las validaciones pertinentes
        if(newProduct == null) return null;

        // Llamamos al insert del Repository
        return repository.insert(newProduct);
    }


}
