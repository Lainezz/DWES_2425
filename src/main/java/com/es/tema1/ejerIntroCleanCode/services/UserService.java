package com.es.tema1.ejerIntroCleanCode.services;

import com.es.tema1.ejerIntroCleanCode.clases.User;
import com.es.tema1.ejerIntroCleanCode.repository.UserRepository;

public class UserService {

    /*
    EL SERVICE SE ENCARGA DE LA LOGICA DE NEGOCIO
     */

    public boolean deleteUser(String nombre) {

        // El nombre es obligatorio
        if(nombre==null || nombre.isEmpty()) return false;

        // Comprobar que el usuario existe en la base de datos
        // TODO: Llamar al método del Repository .getUser()
        UserRepository userRepository = new UserRepository(null);
        User u = userRepository.findUser(nombre);
        if(u == null) {
            return false;
        }

        // Eliminar el usuario y comprobar que ese usuario se ha eliminado correctamente
        // TODO: Llamar al método del Repository .deleteUser() y después llamar a .getUser()
        userRepository.eraseUser(u);
        return userRepository.findUser(nombre) == null;




    }
}
