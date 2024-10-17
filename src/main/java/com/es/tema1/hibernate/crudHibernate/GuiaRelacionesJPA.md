
# Ejemplos de Relaciones en JPA

## 1. Relación One-to-One

### Ejemplo:
Imagina que tenemos dos entidades: `Persona` y `Pasaporte`. Cada persona tiene un único pasaporte y cada pasaporte pertenece a una sola persona.

```java
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pasaporte_id", referencedColumnName = "id")
    private Pasaporte pasaporte;

    // getters y setters
}

@Entity
public class Pasaporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;

    @OneToOne(mappedBy = "pasaporte")
    private Persona persona;

    // getters y setters
}
```

### Explicación:
En este caso, hemos usado `@OneToOne` para establecer una relación uno a uno entre `Persona` y `Pasaporte`. La anotación `@JoinColumn` define la columna que actúa como clave foránea en la tabla `Persona`, haciendo referencia al `id` de `Pasaporte`. El `cascade = CascadeType.ALL` indica que cualquier operación (persistencia, eliminación, etc.) sobre la entidad `Persona` también afectará a la entidad `Pasaporte`.

---

## 2. Relación One-to-Many

### Ejemplo:
En este caso, tenemos una entidad `Cliente` que puede tener muchas `Ordenes`.

```java
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Orden> ordenes = new ArrayList<>();

    // getters y setters
}

@Entity
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    // getters y setters
}
```

### Explicación:
Aquí utilizamos `@OneToMany` en la entidad `Cliente` para definir que un cliente puede tener muchas órdenes. La propiedad `mappedBy` indica que el lado propietario de la relación está en la entidad `Orden` con la anotación `@ManyToOne`. Además, `orphanRemoval = true` asegura que si eliminamos una orden de la lista en `Cliente`, también será eliminada de la base de datos.

---

## 3. Relación Many-to-One

### Ejemplo:
La relación inversa del ejemplo anterior, donde varias órdenes pueden pertenecer a un solo cliente.

```java
@Entity
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    // getters y setters
}

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "cliente")
    private List<Orden> ordenes = new ArrayList<>();

    // getters y setters
}
```

### Explicación:
En este caso, `@ManyToOne` se utiliza en la entidad `Orden`, que representa que varias órdenes pueden estar asociadas a un solo cliente. `@JoinColumn` especifica la columna que actuará como clave foránea en la tabla de `Orden`.

---

## 4. Relación Many-to-Many

### Ejemplo:
Consideremos dos entidades, `Estudiante` y `Curso`. Un estudiante puede estar matriculado en varios cursos, y un curso puede tener varios estudiantes matriculados.

```java
@Entity
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToMany
    @JoinTable(
      name = "estudiante_curso", 
      joinColumns = @JoinColumn(name = "estudiante_id"), 
      inverseJoinColumns = @JoinColumn(name = "curso_id"))
    private List<Curso> cursos = new ArrayList<>();

    // getters y setters
}

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToMany(mappedBy = "cursos")
    private List<Estudiante> estudiantes = new ArrayList<>();

    // getters y setters
}
```

### Explicación:
La relación `@ManyToMany` se define en ambas entidades `Estudiante` y `Curso`. Con `@JoinTable`, creamos una tabla intermedia llamada `estudiante_curso` que tiene dos columnas: `estudiante_id` y `curso_id`, que son claves foráneas que vinculan ambas tablas. El lado propietario es `Estudiante`, mientras que `Curso` solo referencia la relación usando `mappedBy`.

---

## 5. Relación One-to-Many y Many-to-One Bidireccional

### Ejemplo:
Una relación más común donde tenemos una bidirección entre una entidad `Departamento` y una entidad `Empleado`. Un departamento tiene muchos empleados, y cada empleado pertenece a un departamento.

```java
@Entity
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
    private List<Empleado> empleados = new ArrayList<>();

    // getters y setters
}

@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    // getters y setters
}
```

### Explicación:
Aquí, en `Departamento`, definimos una relación `@OneToMany` con la lista de empleados. En la entidad `Empleado`, la relación `@ManyToOne` indica que un empleado pertenece a un solo departamento. Esta es una relación bidireccional, lo que significa que ambas entidades pueden acceder a los datos de la otra a través de sus respectivas relaciones.

---

## Conclusión:
Cada relación en JPA tiene un propósito específico dependiendo de cómo se estructuran los datos en una base de datos relacional. Estas anotaciones permiten mapear correctamente las relaciones entre entidades en una base de datos, y JPA maneja automáticamente la creación de claves foráneas y tablas intermedias cuando es necesario.
