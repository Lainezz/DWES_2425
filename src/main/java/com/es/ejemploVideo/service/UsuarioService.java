package com.es.ejemploVideo.service;

import com.es.ejemploVideo.model.Usuario;
import com.es.ejemploVideo.repository.UsuarioRepository;

public class UsuarioService {


    /*
    - Contiene la lógica de
    negocio
    - Procesa los datos
    - Coordina las acciones
    entre diferentes
    componentes
     */

    public Usuario login(String usuario, String password) {

        // Realizar logica de negocio
        if(usuario.isEmpty() || usuario.isBlank() || usuario.trim().length() == 0) {
            // return null -> El controller entenderá que ha habido un error
            // return false
            // lanzar una excepción -> El controller debe capturar esa excepción para saber que ha habido un error
            // devolver 0 ->
            // ...
            // La clave sería devolver algo para que el Controller entendiera que ha habido un error
            return null;
        } else if (password.isEmpty() || password.isBlank() || password.trim().length() == 0) {
            return null;
        } else {


            // Continuamos
            // Llamar al repository
            // Instanciamos la clase UsuarioRepository
            UsuarioRepository usuarioRepository = new UsuarioRepository();

            // Llamamos al método que obtenga un usuario de la base de datos
            Usuario usuarioFromBDD = usuarioRepository.get(usuario);

            // Comprobar si el login es correcto
            // Miramos si usuarioFromBDD es null
            if (usuarioFromBDD == null) {
                return null;
            } else if (usuarioFromBDD.getUsuario().equals(usuario) && usuarioFromBDD.getPassword().equals(password)) {
                // Login Correcto
                return usuarioFromBDD;
            } else {
                // Login Incorrecto
                return null;
            }
        }

    }
}
