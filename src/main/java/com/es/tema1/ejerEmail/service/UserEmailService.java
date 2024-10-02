package com.es.tema1.ejerEmail.service;

import com.es.tema1.ejerEmail.repository.UserEmailRepository;

public class UserEmailService {

    // Variable UserEmailRepository
    private UserEmailRepository repository;
    public  UserEmailService() {
        this.repository = new UserEmailRepository();
    }
}
