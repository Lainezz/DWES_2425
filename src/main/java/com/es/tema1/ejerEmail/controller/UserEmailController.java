package com.es.tema1.ejerEmail.controller;

import com.es.tema1.ejerEmail.service.UserEmailService;

public class UserEmailController {

    private UserEmailService service;
    public UserEmailController() {
        this.service = new UserEmailService();
    }



}
