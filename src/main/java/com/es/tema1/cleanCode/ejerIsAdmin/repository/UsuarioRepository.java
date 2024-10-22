package com.es.tema1.cleanCode.ejerIsAdmin.repository;

import com.es.tema1.cleanCode.ejerIsAdmin.model.Usuario;

import java.util.ArrayList;

public class UsuarioRepository {

    private ArrayList<Usuario> usuarios;

    public UsuarioRepository() {
        this.usuarios = new ArrayList<>();
    }

    public Usuario get(String email) {
        return usuarios.stream().filter(usuario -> usuario.getCorreo().equals(email)).findFirst().orElse(null);
    }

    public Usuario update(String email, Usuario newUsuario) {

        Usuario u = usuarios.stream().filter(usuario -> usuario.getCorreo().equals(email)).findFirst().orElse(null);
        if (u != null) {
            u.setCorreo(newUsuario.getCorreo());
            u.setPassword(newUsuario.getPassword());
            u.setAdmin(newUsuario.isAdmin());
        }
        return u;
    }

    public void delete(String email) {
        usuarios.remove(usuarios.stream().filter(usuario -> usuario.getCorreo().equals(email)).findFirst().orElse(null));
    }

    public Usuario insert(Usuario newUsuario) {

        usuarios.add(newUsuario);
        return usuarios.stream().filter(usuario -> usuario.getCorreo().equals(newUsuario.getCorreo())).findFirst().orElse(null);
    }


}
