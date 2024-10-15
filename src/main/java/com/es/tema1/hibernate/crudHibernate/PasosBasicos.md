
## PASOS BÁSICOS PARA EMPEZAR CON HIBERNATE

### 1. Creación de un proyecto Java con Gradle
Para comenzar un proyecto Java en IntelliJ IDEA con Gradle:

1. Abre IntelliJ IDEA y selecciona **New Project**.
2. En la ventana de configuración, selecciona **Java** y **Gradle** como el sistema de construcción. Asegúrate de que está seleccionada la opción de usar el **JDK** adecuado (por ejemplo, JDK 17).
3. Dale un nombre al proyecto, elige la ubicación donde deseas guardarlo, y pulsa **Finish**.
4. IntelliJ IDEA descargará las dependencias de Gradle necesarias para el proyecto.

### 2. Descarga y puesta en marcha de un SGBD para realizar pruebas (XAMPP, etc.)
El siguiente paso es tener una base de datos a la cual Hibernate pueda conectarse. Usualmente, se utiliza MySQL para proyectos pequeños. Puedes seguir estos pasos:

1. Descarga [XAMPP](https://www.apachefriends.org/es/index.html), que incluye MySQL.
2. Instala XAMPP y arranca el servicio de MySQL desde el panel de control de XAMPP.
3. Asegúrate de que MySQL está corriendo para que Hibernate pueda conectarse a la base de datos.

### 3. Descarga de dependencias
Para trabajar con Hibernate, debes añadir las dependencias necesarias en tu archivo `build.gradle`. Aquí te dejo un ejemplo de las dependencias básicas:

```gradle
dependencies {
    implementation 'org.hibernate:hibernate-core:6.0.0.Final'
    implementation 'jakarta.persistence:jakarta.persistence-api:3.1.0'
    implementation 'mysql:mysql-connector-java:8.0.33'
    
    // Para el logging
    implementation 'org.slf4j:slf4j-api:2.0.9'
    implementation 'org.slf4j:slf4j-simple:2.0.9'
}
```

Tras añadir las dependencias, sincroniza Gradle para que las descargue.

### 4. Creación del archivo `persistence.xml`
El archivo `persistence.xml` contiene la configuración para Hibernate y la conexión con la base de datos. Coloca este archivo dentro de la carpeta `src/main/resources/META-INF/`. Asegúrate de crear las carpetas si no existen.

Ejemplo de un `persistence.xml` básico:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="https://jakarta.ee/xml/ns/persistence"
             version="3.1">
    <persistence-unit name="hibernate-example" transaction-type="RESOURCE_LOCAL">
        <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
        <class>com.example.Employee</class> <!-- Añade tus clases aquí -->
        <properties>
            <!-- Propiedades de la conexión -->
            <property name="jakarta.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/hibernate_test"/>
            <property name="jakarta.persistence.jdbc.user" value="root"/>
            <property name="jakarta.persistence.jdbc.password" value=""/>
            <property name="jakarta.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
            
            <!-- Configuración de Hibernate -->
            <property name="hibernate.dialect" value="org.hibernate.dialect.MySQLDialect"/>
            <property name="hibernate.hbm2ddl.auto" value="update"/> <!-- Crea o actualiza tablas automáticamente -->
            <property name="hibernate.show_sql" value="true"/> <!-- Muestra las consultas SQL en consola -->
        </properties>
    </persistence-unit>
</persistence>
```

### 5. Creación de las clases a mapear y anotación de las mismas
Ahora, debes crear las clases de entidad que representan las tablas en la base de datos. Usa anotaciones de JPA (Jakarta Persistence API) para mapear las clases a tablas.

Ejemplo con una clase `Employee`:

```java
import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    public Employee() {
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
}
```

### 6. Instanciación de `EntityManagerFactory` y `EntityManager`
Finalmente, necesitas inicializar el `EntityManagerFactory` y usar `EntityManager` para interactuar con la base de datos.

```java
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateExample {
    public static void main(String[] args) {
        // Crear EntityManagerFactory a partir de persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-example");
        EntityManager em = emf.createEntityManager();

        // Crear una nueva instancia de Employee
        Employee employee = new Employee("John", "Doe");

        // Transacción: Guardar el empleado en la base de datos
        em.getTransaction().begin();
        em.persist(employee);
        em.getTransaction().commit();

        // Cerrar el EntityManager y EntityManagerFactory
        em.close();
        emf.close();
    }
}
```

