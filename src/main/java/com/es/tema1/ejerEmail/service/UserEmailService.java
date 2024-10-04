package com.es.tema1.ejerEmail.service;

import com.es.tema1.ejerEmail.model.UserEmail;
import com.es.tema1.ejerEmail.repository.BasicRepositoryAPI;
import com.es.tema1.ejerEmail.repository.UserEmailRepository;
import com.es.tema1.ejerEmail.utils.EncryptUtil;
import com.es.tema1.ejerEmail.utils.Validator;

public class UserEmailService implements GenericServiceAPI<String, UserEmail>{

    // Variable UserEmailRepository
    private BasicRepositoryAPI<String, UserEmail> repository;
    public  UserEmailService() {
        this.repository = new UserEmailRepository();
    }


    public boolean checkUserEmail(String email, String password) {

        // 1º Campos OK
        if(Validator.validateNonEmpty(email) || Validator.validateNonEmpty(password)) return false;

        // 2º Llamar a getUser del repository
        UserEmail u = repository.get(email);

        // 3º Comprobar que ese email existe
        if (u == null) return false;

        // 4º Encriptar la password y comprobar que coincide con el de la base de datos
        String passEncrypted = EncryptUtil.encryptPassword(password);

        // Compruebo que ambos campos coinciden
        return email.equals(u.getEmail()) && passEncrypted.equals(u.getPassword());
    }

    public UserEmail get(String email) {

        // Comprobamos que email no esté vacío
        if(Validator.validateEmail(email)) return null;

        // Obtenemos el UserEmail
        UserEmail u = repository.get(email);

        // Devolvemos el UserEmail (puede ser null)
        return u;
    }

    public UserEmail insert(UserEmail u) {

        // Compruebo que el email y nombre no vienen vacios
        if(Validator.validateNonEmpty(u.getEmail())
                || Validator.validateNonEmpty(u.getNombre())
                || Validator.validateNonEmpty(u.getPassword())) return null;

        // Compruebo que nombre no contenga caracteres raros
        if(!Validator.validateName(u.getNombre())) return null;

        // Compruebo el u.getEmail()
        if (!Validator.validateEmail(u.getEmail())) return null;

        // Encripto la contraseña
        String passHashed = EncryptUtil.encryptPassword(u.getPassword());

        // Insertar usuario
        return repository.insert(new UserEmail(u.getNombre(), u.getEmail(), passHashed));
    }

    public boolean delete(String email){

        // Compruebo que el email no viene vacio
        if(email == null || email.trim().isEmpty()) return false;

        // Realizo la eliminacion del usuario
        return repository.delete(email);
    }
}
