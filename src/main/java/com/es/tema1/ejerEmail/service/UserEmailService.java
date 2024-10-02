package com.es.tema1.ejerEmail.service;

import com.es.tema1.ejerEmail.model.UserEmail;
import com.es.tema1.ejerEmail.repository.UserEmailRepository;
import com.es.tema1.ejerEmail.repository.UserEmailRepositoryAPI;

public class UserEmailService {

    // Variable UserEmailRepository
    private UserEmailRepository repository;
    public  UserEmailService() {
        this.repository = new UserEmailRepository();
    }

    public UserEmail getUserEmail(String email) {

        // Comprobamos que email no esté vacío
        if(email == null || email.isEmpty()) return null;

        // Obtenemos el UserEmail
        UserEmail u = repository.getUserEmail(email);

        // Devolvemos el UserEmail (puede ser null)
        return u;
    }

    public UserEmail insertUserEmail() {
        return null;
    }

    public boolean deleteUserEmail(){
        return false;
    }
}
