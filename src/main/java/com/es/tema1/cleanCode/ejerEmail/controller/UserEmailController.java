package com.es.tema1.cleanCode.ejerEmail.controller;

import com.es.tema1.cleanCode.ejerEmail.model.RespuestaHTTP;
import com.es.tema1.cleanCode.ejerEmail.model.UserEmail;
import com.es.tema1.cleanCode.ejerEmail.service.UserEmailService;

public class UserEmailController {

    private UserEmailService service;
    public UserEmailController() {
        this.service = new UserEmailService();
    }

    public RespuestaHTTP login(String email, String password) {

        try {

            if(email == null || email.isEmpty())
                return new RespuestaHTTP(400, "Bad Request");
            if(password == null || password.isEmpty())
                return new RespuestaHTTP(400, "Bad Request");

                // TODO: Llamar al método del service
            boolean respuestaService = service.checkUserEmail(email, password);

            return respuestaService ?
                    new RespuestaHTTP(200, "OK") :
                    new RespuestaHTTP(401, "No autorizado");

        } catch (Exception e) {
            return new RespuestaHTTP(500, "Server Error");
        }

    }


    public RespuestaHTTP getUserEmail(String email) {
        try {
            UserEmail u = service.get(email);

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
            UserEmail u = service.insert(new UserEmail(nombre, email, password));
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
            return service.delete(email) ?
                    new RespuestaHTTP(200, "Usuario "+email+" eliminado") :
                    new RespuestaHTTP(400, "Usuario NO eliminado");

        } catch (Exception e) {
            return new RespuestaHTTP(500, "Fatal internal Error");
        }
    }

}
