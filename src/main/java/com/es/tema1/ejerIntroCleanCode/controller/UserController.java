package com.es.tema1.ejerIntroCleanCode.controller;

import com.es.tema1.ejerCRUD.clases.ResponseEntity;
import com.es.tema1.ejerIntroCleanCode.clases.User;
import com.es.tema1.ejerIntroCleanCode.services.UserService;

public class UserController {

    /*
    RECORDAMOS QUE EL CONTROLLER SE ENCARGA DE ADMINISTRAR LAS PETICIONES
    Y RESPUESTAS HTTP
     */
    private UserService userService;
    public UserController() {
        userService = new UserService();
    }

    // Funcion de delete del Controller
    public ResponseEntity deleteUser(String nombre) {

        try {

            // Si el controller obtiene un true, significa que ha ido bien, y que se ha eliminado correctamente
            // TODO: Funcion Service
            return userService.deleteUser(nombre) ?
                    new ResponseEntity(200, "Usuario Eliminado") :
                    new ResponseEntity(400, "Bad Request");


        } catch (Exception e) {
            // Si capturamos una excepción, significa que ha habido un error interno del sistema
            return new ResponseEntity(500, "mensaje:Una excepcion ha ocurrido");

        }
    }

    // IMPLEMENTACION DEL GETUSER()
    public ResponseEntity getUser(String nombre) {

        // Tenemos que llamar al método del Service que se encargue de hacer getUser()
        try {
            // TODO: Llamar al metodo getUser del service
            User u = userService.getUser(nombre);
            return  u == null ?
                    new ResponseEntity(404, "mensaje:Usuario No encontrado") :
                    new ResponseEntity(200, u.toString());

        } catch (Exception e) {
            return new ResponseEntity(500, "Error fatal");
        }
    }

    // IMPLEMENTACION DEL ADDUSER()
    public ResponseEntity addUser(String nombre, String pass) {

        try {
            // Tenemos que llamar al método del Service que se encargue de hacer el addUser()
            User u = userService.addUser(nombre, pass);
            return u == null ?
                    new ResponseEntity(400, "Error al insertar el usuario") :
                    new ResponseEntity(201, u.toString());

        } catch (Exception e) {
            return new ResponseEntity(500, "Error fatal");
        }
    }


    // IMPLEMENTACION DEL UPDATEUSER()
    public ResponseEntity updateUser(String nombre, String nuevoNombre, String nuevaPass) {

        try {
            // Tenemos que llamar al método del Service que se encargue de hacer el updateUser()
            User u = userService.updateUser(nombre, nuevoNombre, nuevaPass);
            return u == null ?
                    new ResponseEntity(400, "Error al actualizar el usuario") :
                    new ResponseEntity(201, u.toString());

        } catch (Exception e) {
            return new ResponseEntity(500, "Error interno del servidor");
        }

    }


}
