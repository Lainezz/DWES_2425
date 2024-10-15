## Hasheando una contraseña
Para hacer un hash de una cadena en Java utilizando el algoritmo **SHA3-256**, puedes usar la clase `MessageDigest` del paquete `java.security`. A continuación te muestro una guía paso a paso sobre cómo hacerlo:

1. Importa los paquetes necesarios.
2. Crea una instancia de `MessageDigest` con el algoritmo "SHA3-256".
3. Actualiza la instancia de `MessageDigest` con el array de bytes de la cadena de entrada.
4. Convierte los bytes resultantes del hash en una cadena hexadecimal para facilitar su lectura.

Aquí tienes un ejemplo completo:

```java
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA3HashExample {
    public static void main(String[] args) {
        String input = "Tu cadena de entrada";
        try {
            // Crear una instancia de MessageDigest para SHA3-256
            MessageDigest digest = MessageDigest.getInstance("SHA3-256");

            // Hacer hash de la cadena de entrada
            byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));

            // Convertir los bytes del hash en una cadena hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = String.format("%02x", b);
                hexString.append(hex);
            }

            // Imprimir el hash
            System.out.println("SHA3-256 Hash: " + hexString.toString());
        } catch (NoSuchAlgorithmException e) {
            System.err.println("¡Algoritmo SHA3-256 no encontrado!");
        }
    }
}
```

### Explicación:

- MessageDigest.getInstance("SHA3-256") crea un objeto MessageDigest que implementa el algoritmo de hash SHA3-256.
- digest.digest(input.getBytes(StandardCharsets.UTF_8)) hace el hash de la cadena de entrada.
- El bucle convierte cada byte del hash en una cadena hexadecimal de dos dígitos.

Este enfoque asegura que tu cadena se hashee de manera segura utilizando SHA3-256, una función criptográfica de hash robusta.

Aquí tienes la respuesta exportada en **Markdown** y en español:

---

## ¿Se puede descifrar una contraseña hasheada?

No, las **contraseñas hasheadas no pueden ser descifradas**. El hashing es un proceso criptográfico unidireccional, lo que significa que una vez que los datos (en este caso, la contraseña) han sido hasheados, no es posible revertir el hash para obtener la contraseña original. Esta es una característica clave que diferencia el hashing de la encriptación.

### ¿Cómo funciona el hashing?

- **Función unidireccional**: El hashing toma una entrada (como una contraseña) y produce una salida de tamaño fijo (el hash), sin importar el tamaño de la entrada. La misma entrada siempre producirá el mismo hash, pero el proceso no se puede revertir.
- **Determinístico**: El hashing siempre produce la misma salida para la misma entrada, pero dado solo el hash, no se puede deducir la entrada original.

### ¿Por qué no se puede descifrar un hash?

1. **Pérdida de información**: Los algoritmos de hashing, como SHA-256 o SHA3-256, reducen la entrada (que puede ser de cualquier longitud) a una salida de tamaño fijo (por ejemplo, 256 bits). No hay forma de recuperar la entrada original a partir de la salida comprimida porque la información original se "pierde" durante el proceso de hashing.

2. **Diseño unidireccional**: Los algoritmos de hashing están diseñados específicamente para ser **irreversibles**. Esto es lo que hace que el hashing sea adecuado para almacenar contraseñas de forma segura. Incluso si un atacante obtiene acceso a las contraseñas hasheadas, no puede recuperar las contraseñas originales directamente.

3. **No se utilizan claves de encriptación**: El hashing no involucra el uso de una clave. En la encriptación, los datos se pueden descifrar con una clave, pero en el hashing, no existe tal clave porque el proceso no es reversible por diseño.

### Prácticas de hashing seguro para contraseñas

- **Salting**: Se añade un "salt" (dato aleatorio) único a cada contraseña antes de hashearla. Esto evita que los atacantes utilicen bases de datos de hashes precomputados (tablas rainbow) para descifrar la contraseña.
- **Peppering**: A veces se usa un valor secreto adicional, conocido como "pepper", junto con el salt para mejorar la seguridad.
- **Funciones de hashing lentas**: Algoritmos como **bcrypt**, **scrypt** o **Argon2** se utilizan para hashear contraseñas porque están diseñados para ser computacionalmente costosos, lo que hace que los ataques de fuerza bruta sean poco prácticos.

### ¿Se pueden "crackear" los hashes?

Aunque los hashes no pueden ser "descifrados", pueden ser vulnerables a ataques como:

- **Ataques de fuerza bruta**: Intentar todas las posibles entradas hasta encontrar la correcta.
- **Tablas rainbow**: Tablas precomputadas de contraseñas comunes y sus hashes.

Sin embargo, con un **salting adecuado**, el uso de algoritmos de hashing fuertes y un costo computacional alto (como en bcrypt, scrypt y Argon2), estos ataques pueden hacerse inviables.

### Resumen

Las contraseñas hasheadas no se pueden descifrar porque el hashing es una función unidireccional diseñada para ser irreversible. En su lugar, para verificar contraseñas, se aplica la misma función de hash a la entrada proporcionada (por ejemplo, en un intento de inicio de sesión) y el hash resultante se compara con el hash almacenado.

Aquí tienes la respuesta exportada en **Markdown** y traducida al español:

---

## Uso de BCrypt en Java

En Java, existen bibliotecas específicamente diseñadas para el hashing con salting y otras características de seguridad similares a bcrypt en Node.js. La biblioteca más popular que ofrece funciones de hashing de contraseñas con bcrypt, scrypt y otras en Java es **BCrypt** del proyecto **Spring Security** o la biblioteca **jBCrypt**, que es una biblioteca independiente para usar bcrypt en Java.

### Usando BCrypt en Java

BCrypt maneja automáticamente el salting, el hashing y la verificación segura de contraseñas, lo que facilita y hace más seguro el manejo de contraseñas, en comparación con la gestión manual de los salts.

#### Implementación paso a paso con jBCrypt:

1. **Agregar la dependencia de jBCrypt**: Si estás usando Maven, agrega la siguiente dependencia a tu archivo `pom.xml`:

   ```xml
   <dependency>
       <groupId>org.mindrot</groupId>
       <artifactId>jbcrypt</artifactId>
       <version>0.4</version>
   </dependency>
   ```

   Si estás usando Gradle, agrega lo siguiente a tu archivo `build.gradle`:

   ```groovy
   implementation 'org.mindrot:jbcrypt:0.4'
   ```

2. **Hasheando una cadena usando BCrypt**: A continuación, se muestra un ejemplo de cómo usar BCrypt para hashear y verificar contraseñas:

   ```java
   import org.mindrot.jbcrypt.BCrypt;

   public class BCryptExample {
       public static void main(String[] args) {
           String password = "Tu cadena de entrada";

           // Hashear la contraseña con un salt generado automáticamente
           String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

           // Imprimir la contraseña hasheada
           System.out.println("Contraseña Hasheada: " + hashedPassword);

           // Verificar si la contraseña coincide con el hash
           boolean matched = BCrypt.checkpw(password, hashedPassword);
           System.out.println("¿Contraseña coincidió?: " + matched);
       }
   }
   ```

### Explicación:
- **`BCrypt.hashpw(password, BCrypt.gensalt())`**: Este método genera un hash con un salt único que se añade automáticamente. `gensalt()` puede recibir un parámetro opcional para ajustar el factor de coste (el valor predeterminado es 10, lo que lo hace más lento pero más seguro).
- **`BCrypt.checkpw(password, hashedPassword)`**: Este método verifica si la contraseña proporcionada coincide con la contraseña hasheada.

### Beneficios de usar BCrypt:
- **Salting Automático**: BCrypt genera automáticamente un salt único para cada hash, lo que hace que el proceso sea menos propenso a errores.
- **Factor de Coste Configurable**: Puedes ajustar el factor de coste (factor de trabajo), lo que aumenta el tiempo computacional necesario para hashear y verificar, añadiendo seguridad con el tiempo.
- **Verificación Incorporada**: BCrypt proporciona métodos seguros para verificar contraseñas sin exponer el riesgo a ataques de temporización.

BCrypt es ampliamente utilizado y altamente recomendado para manejar el hashing seguro de contraseñas en Java, de manera similar a cómo bcrypt se utiliza en Node.js.

--- 


