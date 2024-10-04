package com.es.tema1.ejerEmail.service;

import com.es.tema1.ejerEmail.model.UserEmail;
import com.es.tema1.ejerEmail.repository.BasicRepositoryAPI;
import com.es.tema1.ejerEmail.repository.UserEmailRepository;
import com.es.tema1.ejerEmail.utils.EncryptUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserEmailService {

    // Variable UserEmailRepository
    private BasicRepositoryAPI<String, UserEmail> repository;
    public  UserEmailService() {
        this.repository = new UserEmailRepository();
    }

    public UserEmail getUserEmail(String email) {

        // Comprobamos que email no esté vacío
        if(email == null || email.isEmpty()) return null;

        // Obtenemos el UserEmail
        UserEmail u = repository.get(email);

        // Devolvemos el UserEmail (puede ser null)
        return u;
    }

    public UserEmail insertUserEmail(String nombre, String email, String password) {

        // Compruebo que el email y nombre no vienen vacios
        if(email == null || email.trim().isEmpty()) return null;
        if(nombre == null || nombre.trim().isEmpty()) return null;
        if(password == null || password.trim().isEmpty()) return null;

        // Compruebo que la longitud del nombre es la adecuada
        if(nombre.length() > 15) return null;

        // Compruebo que nombre no contenga caracteres raros
        String regexNombre = "[a-zA-Z0-9]{1,15}$";
        Pattern p = Pattern.compile(regexNombre, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(nombre);
        if(!m.matches()) return null;

        // Compruebo el email
        String regexEmail = "^[\\w-]+@\\w+\\.(com|es)$";
        if (!email.matches(regexEmail)) return null;

        // Encripto la contraseña
        String passHashed = EncryptUtil.encryptPassword(password);

        // Insertar usuario
        return repository.insert(new UserEmail(nombre, email, passHashed));
    }

    public boolean deleteUserEmail(String email){

        // Compruebo que el email no viene vacio
        if(email == null || email.trim().isEmpty()) return false;

        // Realizo la eliminacion del usuario
        return repository.delete(email);
    }
}
