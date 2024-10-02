package com.es.tema1.ejerEmail.repository;

import com.es.tema1.ejerEmail.model.UserEmail;

public interface UserEmailRepositoryAPI {

    // VOY A DEFINIR LOS MÉTODOS QUE DESPUES IMPLEMENTAREMOS
    UserEmail getUserEmail(String email);
    UserEmail insertUserEmail(UserEmail u);
    boolean deleteUserEmail(String email);

}
