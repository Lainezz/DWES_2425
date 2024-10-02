# Actividad: Desarrollo de una aplicación Java con login y gestión de usuarios basada en capas (Controller, Service, Repository)
## Objetivo:

Desarrollar una pequeña aplicación donde los usuarios puedan realizar login y administrar otros usuarios (según sus permisos) a través de las siguientes operaciones: Consulta, Modificación, Baja, y Alta. La aplicación estará dividida en tres capas lógicas: Controller, Service, y Repository. El sistema debe cumplir con las especificaciones indicadas para la seguridad y validación de los usuarios.
## Requerimientos de la Aplicación:
### Primera Parte: Login

El usuario debe poder iniciar sesión proporcionando su correo electrónico y contraseña.
- Si las credenciales son correctas, el usuario accederá al sistema. 
- Si las credenciales son incorrectas, se denegará el acceso.

Todos los usuarios registrados se almacenan en la tabla usuarios de la base de datos.

### Segunda Parte: Gestión de Usuarios

Si el usuario tiene permisos de administrador (isAdmin), verá las opciones:
- Consulta: Buscar un usuario por correo electrónico y mostrar su información.
- Modificación: Editar la información de un usuario.
- Baja: Eliminar un usuario específico.
- Alta: Registrar un nuevo usuario proporcionando un ID, correo, contraseña, y la opción de administrador (isAdmin). 
Si el usuario no es administrador, solo podrá realizar consultas.

### Tercera Parte: Especificaciones de la Aplicación

- Las contraseñas deben almacenarse encriptadas en la base de datos. 
- Ninguno de los campos (correo, contraseña) debe exceder los 20 caracteres. 
- El correo debe tener un formato válido (nombre@dominio.com/es). 
- No se permite registrar dos usuarios con el mismo correo.

## Instrucciones:
### 1. Modelo de Usuario

Los estudiantes deben crear la clase User que represente a los usuarios del sistema, incluyendo atributos como ID, correo, contraseña encriptada y permisos de administrador (isAdmin).

### 2. Capa de Repositorio (Repository Layer)

Los estudiantes deben crear una clase UserRepository que maneje las operaciones CRUD relacionadas con los usuarios. Esta clase se encargará de almacenar, recuperar, actualizar y eliminar usuarios de una lista o base de datos.

### 3. Capa de Servicio (Service Layer)

La capa de servicios manejará la lógica de negocio. Esto incluye la validación de correos, encriptación de contraseñas, y la verificación de permisos de administrador (isAdmin).

### 4. Capa de Controlador (Controller Layer)

El controlador manejará el menú de la aplicación, donde los usuarios podrán iniciar sesión y, dependiendo de si son administradores, realizar diversas operaciones.

### 5. Crear la clase Main para ejecutar la aplicación
Finalmente, se crea una clase principal para ejecutar la aplicación y probar las funcionalidades.


## Conclusiones

Esta solución ofrece una solución basada en una arquitectura por capas donde:

1. El Controller maneja las interacciones con el cliente
2. El Service maneja la lógica de negocio (como validaciones o encriptación)
3. El Repository es el responsable de interactuar con la base de datos

Cada parte tiene una responsabilidad única, lo que nos aporta una mayor escalabilidad y mantenibilidad de la app, así como un mayor conocimiento de la estructura básica que una API REST puede tener.
