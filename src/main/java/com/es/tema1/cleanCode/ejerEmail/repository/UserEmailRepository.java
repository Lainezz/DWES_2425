package com.es.tema1.cleanCode.ejerEmail.repository;

import com.es.tema1.cleanCode.ejerEmail.model.UserEmail;

import java.util.ArrayList;

public class UserEmailRepository implements BasicRepositoryAPI<String, UserEmail> {

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
    public UserEmail get(String email) {
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
    public UserEmail insert(UserEmail u) {
        bddUserEmail.add(u);

        // return bddUserEmail.stream().filter(user -> user.getEmail().equals(u.getEmail())).findFirst().orElse(null);
        return get(u.getEmail());
    }

    @Override
    public boolean delete(String email) {
        // return bddUserEmail.removeIf(u -> u.getEmail().equals(email));
        return bddUserEmail.remove(get(email));
    }
}
