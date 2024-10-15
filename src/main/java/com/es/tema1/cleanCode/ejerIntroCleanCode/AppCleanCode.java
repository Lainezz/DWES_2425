package com.es.tema1.cleanCode.ejerIntroCleanCode;

import com.es.tema1.cleanCode.ejerIntroCleanCode.controller.UserController;
import com.es.tema1.cleanCode.ejerIntroCleanCode.clases.ResponseEntity;

public class AppCleanCode {


    public static void main(String[] args) {


        UserController uc = new UserController();
        ResponseEntity re = uc.addUser("lolito", "1234");

        uc.deleteUser("lolito");



    }

}
