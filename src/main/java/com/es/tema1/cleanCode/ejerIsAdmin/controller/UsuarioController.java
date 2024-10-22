package com.es.tema1.cleanCode.ejerIsAdmin.controller;

import com.es.tema1.cleanCode.ejerIsAdmin.model.Usuario;
import com.es.tema1.cleanCode.ejerIsAdmin.service.UsuarioService;
import com.es.tema1.cleanCode.ejerIsAdmin.utils.EncryptUtil;
import com.es.tema1.cleanCode.ejerIsAdmin.utils.RespuestaHTTP;
import com.es.tema1.cleanCode.ejerIsAdmin.utils.Validator;

import java.util.Optional;

public class UsuarioController {

    private UsuarioService service;

    public UsuarioController() {
        service = new UsuarioService();
    }

    public RespuestaHTTP<Usuario> get(String correo) {

        try {
            Usuario u = service.get(correo);
            return u == null
                    ? new RespuestaHTTP<>(404, "Usuario no encontrado")
                    : new RespuestaHTTP<>(200, "OK", u);

        } catch (Exception e) {
            return new RespuestaHTTP<>(500, "INTERNAL SERVER ERROR");
        }


    }

    public RespuestaHTTP<Boolean> login(String correo, String password) {

        try {
            Optional<Boolean> respuestaService = service.login(correo, password);

            if(respuestaService.isEmpty()) {
                return new RespuestaHTTP<>(401, "Usuario no autorizado");
            }

            return respuestaService.get()
                    ? new RespuestaHTTP<>(200, "OK", true)
                    : new RespuestaHTTP<>(200, "OK", false);
        } catch (Exception e) {
            return new RespuestaHTTP<>(500, "INTERNAL SERVER ERROR");
        }



    }


    public RespuestaHTTP<Usuario> update(String correo, Usuario newUsuario) {

        try {
            Usuario u = service.update(correo, newUsuario);

            return u == null
                    ? new RespuestaHTTP<>(400, "BAD REQUEST")
                    : new RespuestaHTTP<>(201, "UPDATED", u);
        } catch (Exception e) {
            return new RespuestaHTTP<>(500, "INTERNAL SERVER ERROR");
        }


    }

    public RespuestaHTTP<Usuario> delete(String correo) {

        try {

            return service.delete(correo) != null
                    ? new RespuestaHTTP<>(204, "DELETED")
                    : new RespuestaHTTP<>(400, "BAD REQUEST");


        } catch (Exception e) {
            return new RespuestaHTTP<>(500, "INTERNAL SERVER ERROR");
        }

    }

    public RespuestaHTTP<Usuario> insert(Usuario newUsuario) {

        try {
            Usuario u = service.insert(newUsuario);

            return u == null
                    ? new RespuestaHTTP<>(400, "BAD REQUEST")
                    : new RespuestaHTTP<>(201, "CREATED", u);


        } catch (Exception e) {
            return new RespuestaHTTP<>(500, "INTERNAL SERVER ERROR");
        }
    }
}
