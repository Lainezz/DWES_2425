package com.es.tema1.cleanCode.ejerEmail.utils;

public class Validator {

    private static final String regexEmail = "^[\\w-]+@\\w+\\.(com|es)$";
    private static final String regexNombre = "[a-zA-Z0-9]{1,15}$";
    public static boolean validateEmail(String email) {
        return !email.matches(regexEmail);
    }
    public static boolean validateName(String nombre) {
        return !nombre.matches(regexNombre);
    }

    public static boolean validateNonEmpty(String input) {
        return (input == null || input.trim().isEmpty());
    }



}
