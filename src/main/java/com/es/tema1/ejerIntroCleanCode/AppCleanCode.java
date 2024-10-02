package com.es.tema1.ejerIntroCleanCode;

import com.es.tema1.ejerIntroCleanCode.clases.ResponseEntity;
import com.es.tema1.ejerIntroCleanCode.controller.UserController;

public class AppCleanCode {


    public static void main(String[] args) {


        UserController uc = new UserController();
        ResponseEntity re = uc.addUser("lolito", "1234");

        uc.deleteUser("lolito");



    }

}
