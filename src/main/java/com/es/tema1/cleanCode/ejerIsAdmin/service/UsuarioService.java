package com.es.tema1.cleanCode.ejerIsAdmin.service;

import com.es.tema1.cleanCode.ejerIsAdmin.model.Usuario;
import com.es.tema1.cleanCode.ejerIsAdmin.repository.UsuarioRepository;
import com.es.tema1.cleanCode.ejerIsAdmin.utils.EncryptUtil;
import com.es.tema1.cleanCode.ejerIsAdmin.utils.Validator;

import java.util.Optional;

public class UsuarioService {

    private UsuarioRepository repository;

    public UsuarioService() {
        repository = new UsuarioRepository();
    }

    public Usuario get(String id) {

        if(id == null || id.isEmpty()) {
            return null;
        }
        return repository.get(id);
    }

    public Optional<Boolean> login(String correo, String password) {

        if(correo == null || correo.isEmpty() || password == null || password.isEmpty()) {
            return Optional.empty();
        }
        return repository.get(correo).isAdmin() ? Optional.of(true) : Optional.of(false);
    }


    public Usuario update(String correo, Usuario newUsuario) {

        if(correo == null || correo.isEmpty()) {
            return null;
        }

        Usuario userToUpdate = repository.get(correo);

        if (userToUpdate == null) {
            return null;
        }

        if(newUsuario.getPassword() != null && !newUsuario.getPassword().isEmpty()) {
            String encryptedPass = EncryptUtil.encryptPassword(newUsuario.getPassword());
            if(!userToUpdate.getPassword().equals(encryptedPass)) {
                userToUpdate.setPassword(newUsuario.getPassword());
            }
        }
        if(newUsuario.getCorreo() != null && !newUsuario.getCorreo().isEmpty() && !userToUpdate.getCorreo().equals(newUsuario.getCorreo())) {
            if(Validator.validateEmail(newUsuario.getCorreo())) {
                userToUpdate.setCorreo(newUsuario.getCorreo());
            }
        }
        if (userToUpdate.isAdmin() != newUsuario.isAdmin()) {
            userToUpdate.setAdmin(newUsuario.isAdmin());
        }

        return repository.update(correo, userToUpdate);

    }

    public Usuario delete(String correo) {

        if(correo == null || correo.isEmpty()) {
            return null;
        }
        repository.delete(correo);
        return repository.get(correo);

    }

    public Usuario insert(Usuario newUsuario) {

        // Comprobamos id
        if(newUsuario == null || newUsuario.getCorreo() == null || newUsuario.getCorreo().isEmpty()) {
            return null;
        }


        // Comprobamos duplicado
        if (repository.get(newUsuario.getCorreo()) != null) {
            return null;
        }

        // Comprobamos campos vacios
        if(newUsuario.getPassword() == null || newUsuario.getPassword().isEmpty()) {
            return null;
        }

        // COmprobamos validez email
        if(!Validator.validateEmail(newUsuario.getCorreo())) {
            return null;
        }

        // Encriptamos password
        String encryptedPass = EncryptUtil.encryptPassword(newUsuario.getPassword());

        newUsuario.setPassword(encryptedPass);

        return repository.insert(newUsuario);
    }

}
