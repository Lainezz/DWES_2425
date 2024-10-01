package com.es.tema1.ejerIntroCleanCode.repository;

import com.es.tema1.ejerIntroCleanCode.clases.ResponseEntity;
import com.es.tema1.ejerIntroCleanCode.clases.User;

import java.util.ArrayList;

public class UserRepository {

    // ArrayList que simula una tabla de User dentro de una base de datos
    private ArrayList<User> bddUsuarios;

    // Constructor, simplemente inicializo el ArrayList
    public UserRepository(ArrayList<User> bddUsuarios) {
        if (bddUsuarios != null) this.bddUsuarios = bddUsuarios;
        else this.bddUsuarios = new ArrayList<>();
    }


    /*
    REPOSITORY SÓLO SE ENCARGA DE ACCESOS A LA BASE DE DATOS
     */
    public User findUser(String nombre) {
        for (User u: bddUsuarios) {
            if(u.getName().equals(nombre)) return u;
        }
        return null;
    }

    public void eraseUser(String nombre) {
        bddUsuarios.remove(findUser(nombre));
    }
    public void eraseUser(User u) {
        bddUsuarios.remove(u);
    }

}
