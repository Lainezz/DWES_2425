package com.es.tema1.ejerIntroCleanCode.repository;

import com.es.tema1.ejerIntroCleanCode.clases.User;

import java.util.ArrayList;

public class UserRepository {

    // ArrayList que simula una tabla de User dentro de una base de datos
    private ArrayList<User> bddUsers;

    // Constructor, simplemente inicializo el ArrayList
    public UserRepository() {
        this.bddUsers = new ArrayList<>();
        bddUsers.add(new User("Diego", "1234"));
        bddUsers.add(new User("Juan", "1234"));
        bddUsers.add(new User("Paco", "1234"));
        bddUsers.add(new User("Maria", "123456"));
        bddUsers.add(new User("xPeke", "backdoor"));
        bddUsers.add(new User("Caps", "Overrated"));
    }


    /*
    REPOSITORY SÓLO SE ENCARGA DE ACCESOS A LA BASE DE DATOS
     */
    public User findUser(String nombre) {
        for (User u: bddUsers) {
            if(u.getName().equals(nombre)) return u;
        }
        return null;
    }

    public void eraseUser(String nombre) {
        bddUsers.remove(findUser(nombre));
    }
    public void eraseUser(User u) {
        bddUsers.remove(u);
    }

    public User addUser(User u) {
        bddUsers.add(u);
        return findUser(u.getName());
    }

    public User updateUser(String nombre, User modifiedUser) {

        User oldUser = bddUsers.stream().filter(u -> u.getName().equals(nombre)).findFirst().orElse(null);
        if(oldUser != null) {
            oldUser.setName(modifiedUser.getName());
            oldUser.setPass(modifiedUser.getPass());
        }
        return oldUser;
    }
}
