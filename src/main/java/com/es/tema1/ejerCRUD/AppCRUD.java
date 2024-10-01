package com.es.tema1.ejerCRUD;

import com.es.tema1.ejerCRUD.clases.ResponseEntity;
import com.es.tema1.ejerCRUD.clases.User;
import com.es.tema1.ejerCRUD.repository.UserRepository;

import java.util.ArrayList;

public class AppCRUD {


    public static void main(String[] args) {


        ArrayList<User> bddUsers = new ArrayList<>();
        bddUsers.add(new User("Diego", "1234"));
        bddUsers.add(new User("Juan", "1234"));
        bddUsers.add(new User("Paco", "1234"));

        UserRepository userRepository = new UserRepository(bddUsers);

        ResponseEntity r1 = userRepository.getUser("Diego");
        ResponseEntity r2 = userRepository.getUser("ydgey");
        ResponseEntity r3 = userRepository.getUser("");


        ResponseEntity r4 = userRepository.insertUser("Maria", "456");
        ResponseEntity r5 = userRepository.insertUser("Maria", "12334");
        ResponseEntity r6 = userRepository.insertUser("", "");

        ResponseEntity r7 = userRepository.deleteUser("Maria");
        ResponseEntity r8 = userRepository.deleteUser("Maria");
        ResponseEntity r9 = userRepository.deleteUser("");

        ResponseEntity r10 = userRepository.modifyUser("Diego", new User("", "09876"));
        ResponseEntity r11 = userRepository.modifyUser("Diego", new User("Diego", ""));
        ResponseEntity r12 = userRepository.modifyUser("Diego", new User("deijedij", ""));


        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);
        System.out.println(r5);
        System.out.println(r6);
        System.out.println(r7);
        System.out.println(r8);
        System.out.println(r9);
        System.out.println(r10);
        System.out.println(r11);
        System.out.println(r12);

        if (r1.getCodigoRespuesta().containsKey(200)){
            System.out.println("Usuario encontrado");
            System.out.println(r1.getBody());
        }

    }

}
