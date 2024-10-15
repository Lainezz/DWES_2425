package com.es.ejemploVideo.repository;

import com.es.ejemploVideo.model.Usuario;

import java.util.ArrayList;

public class UsuarioRepository {


    ArrayList<Usuario> bddUsuarios = new ArrayList<Usuario>();
    /*
    - Interactúa directamente
    con la fuente de datos.
    - Tiene los métodos para
    CRUD
     */

    /**
     * Se comprueba dentro de la base de datos el usuario que se le pasa por parámetros
     * @param usuario
     * @return
     */
    public Usuario get(String usuario) {

        return bddUsuarios.stream()
                .filter(u -> u.getUsuario().equals(usuario))
                .findFirst()
                .orElse(null);
    }

}
