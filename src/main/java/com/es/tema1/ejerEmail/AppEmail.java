package com.es.tema1.ejerEmail;

import com.es.tema1.ejerEmail.controller.UserEmailController;
import com.es.tema1.ejerEmail.model.RespuestaHTTP;

import java.util.Scanner;

public class AppEmail {


    public static void main(String[] args) {

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
                    \t4. Login
                    \t0. Salir
                    """);

            opcion = scan.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Insertar usuario");
                    System.out.println("Inserte el nuevo nombre: ");
                    String newNombre = scan.nextLine();
                    System.out.println("Inserte el nuevo email: ");
                    String newEmail = scan.nextLine();
                    System.out.println("Inserte la nueva password: ");
                    String newPass = scan.nextLine();

                    RespuestaHTTP rInsert = controller.insertUserEmail(newNombre, newEmail, newPass);

                    if (rInsert.getCodigoRespuesta() == 200) {
                        System.out.println(rInsert.getUserEmail());
                    } else {
                        System.out.println(rInsert.getMensajeRespuesta());
                    }


                    break;
                case "2":
                    System.out.println("Inserte el email: ");
                    // TODO: leer por teclado
                    String email = scan.nextLine();
                    RespuestaHTTP rGet = controller.getUserEmail(email);

                    if (rGet.getCodigoRespuesta() == 200) {
                        System.out.println(rGet.getUserEmail());
                    } else {
                        System.out.println(rGet.getMensajeRespuesta());
                    }
                    break;

                case "3":

                    System.out.println("Eliminar usuario");
                    System.out.println("Inserte el email a eliminar: ");
                    String bajaEmail = scan.nextLine();

                    RespuestaHTTP rEliminar = controller.deleteUserEmail(bajaEmail);

                    if (rEliminar.getCodigoRespuesta() == 200) {
                        System.out.println(rEliminar.getUserEmail());
                    } else {
                        System.out.println(rEliminar.getMensajeRespuesta());
                    }

                    break;


                case "4":
                    System.out.println("Login");

                    System.out.println("Inserte el email: ");
                    String loginEmail = scan.nextLine();
                    System.out.println("Inserte la password: ");
                    String loginPass = scan.nextLine();

                    RespuestaHTTP rLogin = controller.login(loginEmail, loginPass);

                    if (rLogin.getCodigoRespuesta() == 200) {
                        System.out.println(rLogin.getMensajeRespuesta());
                    } else {
                        System.out.println(rLogin.getMensajeRespuesta());
                    }


                    break;
                case "0":
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Error! Elija opción entre 0 y 3");
                    break;
            }
        }
    }
}
