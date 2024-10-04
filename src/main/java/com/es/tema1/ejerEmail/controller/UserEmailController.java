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

    public RespuestaHTTP insertUserEmail(String nombre, String email, String password) {

        try {
            // TODO: Implementar la logica de insertUserEmail
            UserEmail u = service.insertUserEmail(nombre, email, password);
            return  u != null ?
                    new RespuestaHTTP(200, "Usuario "+email+" insertado", u) :
                    new RespuestaHTTP(400, "Usuario NO insertado");
        } catch (Exception e) {
            return new RespuestaHTTP(500, "Fatal internal Error");
        }
    }

    public RespuestaHTTP deleteUserEmail(String email) {
        try {
            // TODO: Implementar la logica de deleteUserEmail
            return service.deleteUserEmail(email) ?
                    new RespuestaHTTP(200, "Usuario "+email+" eliminado") :
                    new RespuestaHTTP(400, "Usuario NO eliminado");

        } catch (Exception e) {
            return new RespuestaHTTP(500, "Fatal internal Error");
        }
    }

}
