
# Actividad: Desarrollo de una aplicación Java basada en capas (sin frameworks)

## Objetivo:
El objetivo de esta actividad es que los estudiantes desarrollen una pequeña aplicación basada en capas (Controller, Service, Repository) en Java puro, sin utilizar frameworks, para entender la importancia de la separación de responsabilidades en una arquitectura REST. La aplicación será un sistema simple de gestión de usuarios donde se podrá crear, buscar y eliminar usuarios. Además, incluirá algo de lógica de negocio para validar que los usuarios tengan un correo válido y que no se dupliquen.

## Requerimientos de la Aplicación:
1. Crear, leer y eliminar usuarios.
2. Los usuarios deben tener un nombre y un correo electrónico válido.
3. No se pueden crear dos usuarios con el mismo correo electrónico.

## Instrucciones:

### 1. Definir el Modelo de Usuario
Crear una clase `User` que represente los datos del usuario.

```java
public class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
```

### 2. Crear la Capa de Repositorio (Repository Layer)
Esta capa almacenará los usuarios en una estructura de datos en memoria, como una lista, y proporcionará métodos para crear, buscar y eliminar usuarios.

```java
import com.es.tema1.ejerIntroCleanCode.clases.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private List<User> users = new ArrayList<>();

    public Optional<User> findByEmail(String email) {
        return users.stream().filter(user -> user.getEmail().equals(email)).findFirst();
    }

    public List<User> findAll() {
        return users;
    }

    public void save(User user) {
        users.add(user);
    }

    public void deleteByEmail(String email) {
        users.removeIf(user -> user.getEmail().equals(email));
    }
}
```

### 3. Crear la Capa de Servicio (Service Layer)
Aquí se añade la lógica de negocio para validar que el correo del usuario no esté duplicado y que tenga un formato correcto.

```java
import com.es.tema1.ejerCRUD.clases.User;

public class UserService {
    private UserRepository userRepository = new UserRepository();

    public User createUser(String name, String email) throws Exception {
        if (!isValidEmail(email)) {
            throw new Exception("Email is not valid.");
        }
        if (userRepository.findByEmail(email).isPresent()) {
            throw new Exception("User with this email already exists.");
        }
        User u = new User(name, email);
        userRepository.save(u);
        return u;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUserByEmail(String email) throws Exception {
        if (!userRepository.findByEmail(email).isPresent()) {
            throw new Exception("User not found.");
        }
        userRepository.deleteByEmail(email);
    }

    private boolean isValidEmail(String email) {
        // Simple validation for email format
        return email.contains("@");
    }
}
```

### 4. Crear la Capa de Controlador (Controller Layer)
El controlador será el encargado de recibir las diferentes peticiones del Main y de contestar con diferentes códigos de estado. El controlador utilizará la capa de servicio para realizar las operaciones de usuario.

```java
import java.util.List;

public class UserController {
    private UserService userService = new UserService();

    public User createUser(String name, String email) {
        try {
            return userService.createUser(name, email);
        } catch (Exception e) {
            return null;
        }
    }

    public List<User> viewAllUsers() {
        try {
            return userService.getAllUsers();
        } catch (Exception e) {
            return null;
        }
    }

    public String deleteUser(String email) {
        try {
            userService.deleteUserByEmail(email);
            return "Usuario Eliminado correctamente";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
```

### 5. Crear la clase Main para ejecutar la aplicación
Finalmente, se crea una clase principal para ejecutar la aplicación y probar las funcionalidades. Este main será el que interactúe con el usuario a través de la consola, simulando peticiones a un API REST.

```java
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserController userController = new UserController();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Create User");
            System.out.println("2. View All Users");
            System.out.println("3. Delete User");
            System.out.println("4. Exit");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Create user:");
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter email:");
                    String email = scanner.nextLine();

                    userController.createUser(name, email);
                    break;
                case "2":
                    System.out.println("All Users:");

                    List<User> users = userController.viewAllUsers();
                    if(users != null) {
                        for (User user : users) {
                            System.out.println(user.getName() + " - " + user.getEmail());
                        }
                    } else {
                        System.out.println("Usuarios no encontrados");
                    }
                    
                    break;
                case "3":
                    System.out.println("Enter email of user to delete:");
                    String email = scanner.nextLine();
                    String mensaje = userController.deleteUser(email);
                    System.out.println(mensaje);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
```

## Descripción de la lógica de negocio:
1. **Validación del correo electrónico**: El correo debe contener el símbolo `@` para ser considerado válido.
2. **Evitar duplicación**: No se permitirá crear un usuario con un correo electrónico que ya exista en el sistema.
3. **Borrar usuarios**: Se podrá eliminar un usuario proporcionando su correo electrónico, si existe.

## Tareas a realizar por los estudiantes:
1. Implementar las clases proporcionadas y asegurarse de que las capas estén correctamente separadas.
2. Ejecutar la aplicación y probar todas las operaciones (crear usuario, listar usuarios, eliminar usuario).
3. Modificar la validación de correo electrónico para que sea más robusta (por ejemplo, asegurarse de que tiene un dominio válido).
4. Implementar una funcionalidad adicional: editar un usuario existente.

## Conclusión:
Con esta actividad, los estudiantes podrán entender cómo dividir una aplicación en capas lógicas claras, cómo organizar su código en términos de responsabilidades, y cómo aplicar una mínima lógica de negocio sin necesidad de un framework externo.
