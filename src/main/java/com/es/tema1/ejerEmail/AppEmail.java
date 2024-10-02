package com.es.tema1.ejerEmail;

import com.es.tema1.ejerEmail.controller.UserEmailController;
import com.es.tema1.ejerEmail.model.RespuestaHTTP;

import java.util.Scanner;

public class AppEmail {


    public static void main(String[] args) {
        // TODO:

        UserEmailController controller = new UserEmailController();

        System.out.println("Bienvenid@ a la app más molona del mundo");
        String opcion = "";
        Scanner scan = new Scanner(System.in);
        while (!opcion.equals("0")) {


            System.out.println("""
                    Elija opción:
                    \t1. Insertar Usuario
                    \t2. Obtener usuario
                    \t3. Eliminar usuario
                    \t0. Salir
                    """);
            // TODO: Leer por teclado opcion
            opcion = scan.nextLine();

            switch (opcion) {
                case "1":

                case "2":
                    System.out.println("Inserte el email: ");
                    // TODO: leer por teclado
                    String email = scan.nextLine();
                    RespuestaHTTP r = controller.getUserEmail(email);

                    if(r.getCodigoRespuesta() == 200) {
                        System.out.println(r.getUserEmail());
                    } else {
                        System.out.println(r.getMensajeRespuesta());
                    }
                    break;

                case "3":

                case "0":
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Error! Elija opción entre 0 y 3");
            }

        }



    }
}
