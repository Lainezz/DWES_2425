package com.es.tema1.ejerIntroCleanCode.controller;

import com.es.tema1.ejerCRUD.clases.ResponseEntity;
import com.es.tema1.ejerIntroCleanCode.services.UserService;

public class UserController {

    /*
    RECORDAMOS QUE EL CONTROLLER SE ENCARGA DE ADMINISTRAR LAS PETICIONES
    Y RESPUESTAS HTTP
     */

    // Funcion de delete del Controller
    public ResponseEntity deleteUser(String nombre) {

        try {

            // Si el controller obtiene un true, significa que ha ido bien, y que se ha eliminado correctamente
            // TODO: Funcion Service
            UserService userService = new UserService();
            return userService.deleteUser(nombre) ?
                    new ResponseEntity(200, "Usuario Eliminado") :
                    new ResponseEntity(400, "Bad Request");


        } catch (Exception e) {
            // Si capturamos una excepción, significa que ha habido un error interno del sistema
            return new ResponseEntity(500, "mensaje:Una excepcion ha ocurrido");

        }


    }


}
