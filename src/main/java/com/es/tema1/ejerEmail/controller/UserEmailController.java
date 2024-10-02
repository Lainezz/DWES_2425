package com.es.tema1.ejerEmail.controller;

import com.es.tema1.ejerEmail.model.RespuestaHTTP;
import com.es.tema1.ejerEmail.model.UserEmail;
import com.es.tema1.ejerEmail.service.UserEmailService;

public class UserEmailController {

    private UserEmailService service;
    public UserEmailController() {
        this.service = new UserEmailService();
    }

    public RespuestaHTTP getUserEmail(String email) {
        try {
            UserEmail u = service.getUserEmail(email);

            return u != null ?
                    new RespuestaHTTP(200, "TODO OK", u) :
                    new RespuestaHTTP(400, "Bad Request");
        } catch (Exception e) {
            return new RespuestaHTTP(500, "Fatal internal Error");
        }
    }

    public RespuestaHTTP insertUserEmail() {

    }

    public RespuestaHTTP deleteUserEmail() {

    }

}
