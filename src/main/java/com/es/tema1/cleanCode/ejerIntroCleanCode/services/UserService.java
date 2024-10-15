package com.es.tema1.cleanCode.ejerIntroCleanCode.services;

import com.es.tema1.cleanCode.ejerIntroCleanCode.clases.User;
import com.es.tema1.cleanCode.ejerIntroCleanCode.repository.UserRepository;

public class UserService {

    /*
    EL SERVICE SE ENCARGA DE LA LOGICA DE NEGOCIO
     */
    private UserRepository userRepository;
    public UserService() {
        this.userRepository = new UserRepository();
    }

    public boolean deleteUser(String nombre) {

        // El nombre es obligatorio
        if(nombre==null || nombre.isEmpty()) return false;

        // Comprobar que el usuario existe en la base de datos
        // TODO: Llamar al método del Repository .getUser()
        User u = userRepository.findUser(nombre);
        if(u == null) {
            return false;
        }

        // Eliminar el usuario y comprobar que ese usuario se ha eliminado correctamente
        // TODO: Llamar al método del Repository .deleteUser() y después llamar a .getUser()
        userRepository.eraseUser(u);
        return userRepository.findUser(nombre) == null;
    }

    public User getUser(String nombre) {

        // El nombre es obligatorio y sea valido
        if(nombre == null || nombre.isEmpty() || nombre.length() > 255) return null;

        // Llamar al metodo getUser del repository
        return userRepository.findUser(nombre);

    }

    public User addUser(String nombre, String pass) {

        // Comprobamos la validez de los campos
        if(nombre == null || nombre.isEmpty() || nombre.length() > 255
                || pass == null || pass.isEmpty() || pass.length() > 255) return null;

        // Compruebo si el usuario ya existe en la base de datos
        if(userRepository.findUser(nombre) != null) return null;

        // Inserto el user dentro de la base de datos
        return userRepository.addUser(new User(nombre, pass));
    }

    public User updateUser(String nombre, String nuevoNombre, String nuevaPass) {

        // Compruebo si, (nombre está vacío) ó (nuevoNombre y nuevaPass están vacíos)
        if(nombre == null || nombre.isEmpty() || nombre.length() > 255 ||
                ((nuevoNombre == null || nuevoNombre.isEmpty() || nuevoNombre.length() > 255)
                && (nuevaPass == null || nuevaPass.isEmpty() || nuevaPass.length() > 255))) return null;

        // Compruebo si el usuario existe dentro de la base de datos
        User oldUser = userRepository.findUser(nombre);
        if(oldUser == null) return null;

        // Actualizo el usuario
        User modifiedUser = new User("", "");
        if(nuevoNombre == null || nuevoNombre.isEmpty()) modifiedUser.setName(oldUser.getName());
        else modifiedUser.setName(nuevoNombre);

        if(nuevaPass == null || nuevaPass.isEmpty()) modifiedUser.setPass(oldUser.getPass());
        else modifiedUser.setPass(nuevaPass);

        return userRepository.updateUser(nombre, modifiedUser);
    }

}
