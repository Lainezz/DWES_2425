package com.es.tema1.ejerEmail.repository;

import com.es.tema1.ejerEmail.model.UserEmail;

import java.util.ArrayList;

public class UserEmailRepository implements UserEmailRepositoryAPI {

    // Base de datos ficticia
    ArrayList<UserEmail> bddUserEmail;

    public UserEmailRepository() {
        this.bddUserEmail = new ArrayList<>();
        bddUserEmail.add(new UserEmail("Diego", "diego@diego.es"));
        bddUserEmail.add(new UserEmail("Marta", "marta@diego.es"));
        bddUserEmail.add(new UserEmail("Juan", "juan@diego.es"));
        bddUserEmail.add(new UserEmail("Billy", "billy@diego.es"));
        bddUserEmail.add(new UserEmail("Joe", "joe@diego.es"));
    }

    @Override
    public UserEmail getUserEmail(String email) {
        //return bddUserEmail.stream().filter(user -> user.getEmail().equals(email)).findFirst().orElse(null);
        UserEmail userReturn = null;
        for (UserEmail u : bddUserEmail) {
            if (u.getEmail().equals(email)){
                userReturn = u;
                break;
            }
        }
        return userReturn;
    }

    @Override
    public UserEmail insertUserEmail(UserEmail u) {
        bddUserEmail.add(u);
        // return bddUserEmail.stream().filter(user -> user.getEmail().equals(u.getEmail())).findFirst().orElse(null);
        return getUserEmail(u.getEmail());
    }

    @Override
    public boolean deleteUserEmail(String email) {
        // return bddUserEmail.removeIf(u -> u.getEmail().equals(email));
        return bddUserEmail.remove(getUserEmail(email));
    }
}
