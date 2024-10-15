package com.es.ejemploVideo.controller;

import com.es.ejemploVideo.service.UsuarioService;

public class UsuarioController {

    /*
    - Gestionar las solicitudes
    entrantes (HTTP)
    - Procesar los datos
    necesarios
    - Seleccionar una respuesta
    adecuada
     */

    public int login(String usuario, String password) {

        if (usuario != null && password != null) {
            // Continuamos

            // Llamar al Service
            // Inicializar un objeto de tipo UsuarioService
            UsuarioService usuarioService = new UsuarioService();

            // Llamar al método login() del Service
            if(usuarioService.login(usuario, password) == null) {
                return 401; // 401 -> Unauthorized
            } else {
                return 200;
            }



        } else {
            // Respondemos al cliente con error
            return 400; // 400 -> Bad Request
        }
    }
}
