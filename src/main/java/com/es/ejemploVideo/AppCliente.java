package com.es.ejemploVideo;

import com.es.ejemploVideo.controller.UsuarioController;

import java.util.Scanner;

public class AppCliente {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduzca su usuario: ");
        String usuario = scanner.nextLine();

        System.out.println("Introduzca su password: ");
        String password = scanner.nextLine();

        // Llamada al controller
        // Inicializar un objeto de tipo Controller
        UsuarioController usuarioController = new UsuarioController();

        // Llamar al método login de Controller
        if(usuarioController.login(usuario, password) == 200) {
            System.out.println("Bienvenid@");
        } else {
            System.out.println("Fallo al hacer login");
        }


    }
}
