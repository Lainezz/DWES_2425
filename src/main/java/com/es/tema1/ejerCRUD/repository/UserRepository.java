package com.es.tema1.ejerCRUD.repository;

import com.es.tema1.ejerCRUD.clases.ResponseEntity;
import com.es.tema1.ejerCRUD.clases.User;

import java.util.ArrayList;

public class UserRepository {

    // ArrayList que simula una tabla de User dentro de una base de datos
    private ArrayList<User> bddUsuarios;

    // Constructor, simplemente inicializo el ArrayList
    public UserRepository(ArrayList<User> bddUsuarios) {
        if (bddUsuarios != null) this.bddUsuarios = bddUsuarios;
        else this.bddUsuarios = new ArrayList<>();
    }

    /**
     * Método para obtener un usuario de la base de datos
     * @param nombre
     * @return {@link ResponseEntity ResponseEntity.class}
     */
    public ResponseEntity getUser(String nombre) {

        // Si el campo nombre viene vacío, devuelvo un 400-Bad Request
        if (nombre == null || nombre.isEmpty()) return new ResponseEntity(400, "");
        else { // Si no viene vacío, busco a dicho usuario en el sistema
            User u = bddUsuarios.stream().filter(user -> user.getName().equals(nombre)).findFirst().orElse(null); // Busco al usuario por su nombre
            return u!=null ? // Si no es null, significa que lo he encontrado.
                    new ResponseEntity(200, u.toString()) : // Si lo he encontrado, devuelvo 200-OK y el usuario encontrado
                    new ResponseEntity(404, nombre); // Si no lo he encontrado, devuelvo un 404-Not Found
        }
    }


    /**
     * Método que inserta un usuario en el ArrayList
     * @param nombre nombre del usuario a insertar (no debe ser vacío ni null)
     * @param pass password del usuario a insertar (no debe ser vacío ni null)
     * @return {@link ResponseEntity ResponseEntity.class}
     */
    public ResponseEntity insertUser(String nombre, String pass) {

        // Primero compruebo si los campos vienen rellenos, si no vienen rellenos, devuelvo un 400-Bad Request
        if (nombre == null || nombre.isEmpty() || pass == null || pass.isEmpty()) return new ResponseEntity(400, "");

        // Creo el objeto de tipo User
        User u = new User(nombre, pass);

        // Si el usuario ya existe en la base de datos, devuelvo un 409-Conflict. Significa que hay conflicto porque ya existe
        if (bddUsuarios.contains(u)) {
            return new ResponseEntity(409, u.toString());
        } else { // Si no existe, lo inserto y compruebo que efectivamente se ha insertado
            bddUsuarios.add(u); // Lo anado al ArrayList
            return bddUsuarios.stream().filter(user -> user.getName().equals(u.getName())).findFirst().orElse(null) != null ? // Compruebo que ahora sí existe en el ArrayList
                    new ResponseEntity(201, u.toString()) : // Si ahora existe, significa que se ha insertado bien. Devuelvo un 201-Created
                    new ResponseEntity(500, "Error al insertar el usuario"); // Si no se ha insertado por cualquier cosa, devuelvo un 500-Internal Server Error
        }
    }

    /**
     * Método para eliminar un usuario de la base de datos
     * @param nombre
     * @return {@link ResponseEntity ResponseEntity.class}
     */
    public ResponseEntity deleteUser(String nombre) {

        // Primero creo un objeto de tipo usuario
        User u = new User(nombre, "");

        // Compruebo si el usuario está en la base de datos. Si no está, devuelvo un 404-Not Found
        if (!bddUsuarios.contains(u)) {
            return new ResponseEntity(404, u.toString());
        } else { // Si el usuario sí se encuentra en la base de datos, lo elimino y compruebo que se ha eliminado correctamente
            bddUsuarios.remove(u); // Lo elimino
            return bddUsuarios.stream().filter(user -> user.getName().equals(u.getName())).findFirst().orElse(null) == null ? // Compruebo si el usuario sigue existiendo o no en la base de datos
                    new ResponseEntity(200, u.toString()) : // Si es null, significa que el user ya no está en la base de datos. Devuelvo un 200-OK
                    new ResponseEntity(500, "Error al eliminar el usuario"); // Si no es null, significa que el usuario, por cualquier razon, no se ha eliminado correctamente. Devuelvo un 500 error del servidor
        }
    }

    /**
     * Método para modificar un usuario de la base de datos
     * @param nombre
     * @param modifiedUser
     * @return {@link ResponseEntity ResponseEntity.class}
     */
    public ResponseEntity modifyUser(String nombre, User modifiedUser) {

        // Primero obtengo el usuario buscandolo por su nombre
        User u = bddUsuarios.stream().filter(user -> user.getName().equals(nombre)).findFirst().orElse(null);

        // Si el usuario no se ha encontrado, significa que no existe dicho usuario. Devuelvo un 404 not found
        if(u == null) {
            return new ResponseEntity(404, nombre);
        }

        // Si el campo nombre del objeto modifiedUser se encuentra relleno, significa que quieren cambiar el nombre
        if (modifiedUser.getName() != null && !modifiedUser.getName().trim().isEmpty() && modifiedUser.getName().trim().length() > 0) {
            if(bddUsuarios.contains(new User(modifiedUser.getName(), ""))) {
                return new ResponseEntity(409, modifiedUser.toString());
            }
            u.setName(modifiedUser.getName());
        }

        // Si el campo pass del objeto modifiedUser se encuentra relleno, significa que quieren cambiar el pass
        if(modifiedUser.getPass() != null && !modifiedUser.getPass().trim().isEmpty() && modifiedUser.getPass().trim().length() > 0){
            u.setPass(modifiedUser.getPass());
        }

        // Devuelvo un 200-OK que significa que el usuario se ha cambiado correctamente
        return new ResponseEntity(200, u.toString());

    }

}
