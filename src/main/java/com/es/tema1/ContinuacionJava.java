package com.es.tema1;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ContinuacionJava {

    public static void main(String[] args) {


        // Usando MessageDigest
        String input = "Your input string";
        try {
            // Create a MessageDigest instance for SHA3-256
            // Podemos pasarle por parámetro otro tipo de cifrado, como el SHA2-256, o el SHA2-512
            MessageDigest digest = MessageDigest.getInstance("SHA3-256");

            // Hash the input string
            // .digest cifra la cadena de caracteres en sí. Le pasamos el UTF_8
            byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));

            // Convert the hash bytes to a hex string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = String.format("%02x", b);
                hexString.append(hex);
            }

            // Print the hash
            System.out.println("SHA3-256 Hash: " + hexString.toString());
        } catch (NoSuchAlgorithmException e) {
            System.err.println("SHA3-256 algorithm not found!");
        }

    }
}
