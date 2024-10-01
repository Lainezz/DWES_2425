package com.es.tema1.ejerLogin;

import com.es.tema1.ejerLogin.clases.Persona;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        // Declarar un arrayList de objetos de tipo persona
        // Tipo nombre = new Tipo();
        ArrayList<Persona> listaPersonas = new ArrayList<>();

        // Crear un objeto de tipo Persona
        // Clase nombreObjeto = new Clase();
        Persona persona1 = new Persona("Manuel", "12345");
        listaPersonas.add(persona1);
        //
        Persona persona2 = new Persona("Paco", "4321");
        listaPersonas.add(persona2);
        //
        listaPersonas.add(new Persona("Julio", "j3h3h"));
        //
        listaPersonas.add(new Persona("Sergio", "567"));
        //
        listaPersonas.add(2, new Persona("Diego", "123457890"));

        // Menu que se repite hasta pulsar 0
        boolean flag = false;
        Scanner scan = new Scanner(System.in);
        String nombre, pass;
        do {

            System.out.print("Introduzca su nombre de usuario: ");
            nombre = scan.nextLine();

            System.out.print("Introduzca su password: ");
            pass = scan.nextLine();

//            for (Persona p: listaPersonas) {
//                if(p.getNombre().equals(nombre) && p.getPass().equals(pass)) {
//                    flag = true;
//                    break;
//                }
//            }
            flag = listaPersonas.contains(new Persona(nombre, pass));


        } while (!flag);

        System.out.println("Bienvenid@");





    }

}
