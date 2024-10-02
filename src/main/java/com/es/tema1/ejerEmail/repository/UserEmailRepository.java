package com.es.tema1.ejerEmail.repository;

import com.es.tema1.ejerEmail.model.UserEmail;

import java.util.ArrayList;

public class UserEmailRepository implements UserEmailRepositoryAPI {

    // Base de datos ficticia
    ArrayList<UserEmail> bddUserEmail;

    public UserEmailRepository() {
        this.bddUserEmail = new ArrayList<>();
        bddUserEmail.add(new UserEmail("Diego", "diego@diego.es"));
        bddUserEmail.add(new UserEmail("Marta", "marta@diego.es"));
        bddUserEmail.add(new UserEmail("Juan", "juan@diego.es"));
        bddUserEmail.add(new UserEmail("Billy", "billy@diego.es"));
        bddUserEmail.add(new UserEmail("Joe", "joe@diego.es"));
    }

    @Override
    public UserEmail getUserEmail(String email) {
        return null;
    }

    @Override
    public UserEmail insertUserEmail(UserEmail u) {
        return null;
    }

    @Override
    public boolean deleteUserEmail(String email) {
        return false;
    }
}
