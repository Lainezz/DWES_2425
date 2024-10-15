
## Guía de Anotaciones JPA

### 1. **`@Entity`**
Anotación que se coloca en la clase para indicar que es una entidad gestionada por JPA, lo que significa que se mapeará a una tabla en la base de datos.

```java
@Entity
public class Employee {
    // ...
}
```

### 2. **`@Table`**
Especifica la tabla en la base de datos con la que se va a mapear la entidad. Se puede utilizar para configurar el nombre de la tabla, el esquema, índices, etc.

**Propiedades comunes:**
- **`name`**: Define el nombre de la tabla.
- **`schema`**: Especifica el esquema de la base de datos.

```java
@Entity
@Table(name = "empleados", schema = "empresa")
public class Employee {
    // ...
}
```

### 3. **`@Id`**
Se usa para indicar el campo que será la clave primaria de la entidad.

```java
@Entity
public class Employee {
    
    @Id
    private Long id;
    
    // ...
}
```

### 4. **`@GeneratedValue`**
Indica cómo se generará el valor de la clave primaria. Generalmente, se utiliza junto con `@Id`.

**Propiedades comunes:**
- **`strategy`**: Define la estrategia de generación de valores. Los valores comunes son:
  - `GenerationType.AUTO`: El proveedor de persistencia elige la estrategia.
  - `GenerationType.IDENTITY`: Se usa una columna auto-incremental de la base de datos.
  - `GenerationType.SEQUENCE`: Se utiliza una secuencia en la base de datos (común en Oracle).
  - `GenerationType.TABLE`: Usa una tabla específica para generar valores de ID.

```java
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
```

### 5. **`@Column`**
Configura los detalles de la columna en la base de datos que se mapeará al atributo de la entidad.

**Propiedades comunes:**
- **`name`**: Nombre de la columna.
- **`nullable`**: Indica si la columna puede ser `NULL` (por defecto es `true`).
- **`length`**: Define la longitud máxima de la columna (aplicable a tipos de cadena, como `String`).
- **`unique`**: Establece si la columna debe tener valores únicos.
- **`insertable` y `updatable`**: Definen si la columna debe ser incluida en sentencias `INSERT` o `UPDATE`.

```java
@Column(name = "first_name", length = 50, nullable = false, unique = true)
private String firstName;
```

### 6. **`@OneToMany`, `@ManyToOne`, `@OneToOne`, `@ManyToMany`**
Estas anotaciones definen las relaciones entre entidades.

- **`@OneToMany`**: Una entidad tiene muchos de otra entidad.
- **`@ManyToOne`**: Muchos de una entidad se relacionan con una entidad.
- **`@OneToOne`**: Una entidad se relaciona con una entidad.
- **`@ManyToMany`**: Muchos de una entidad se relacionan con muchos de otra entidad.

**Propiedades comunes:**
- **`mappedBy`**: Se usa para indicar el campo propietario de la relación.
- **`fetch`**: Define la estrategia de carga (`FetchType.LAZY` o `FetchType.EAGER`).
- **`cascade`**: Define las operaciones en cascada, como `CascadeType.ALL`, `PERSIST`, `MERGE`, etc.

```java
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "department_id")
private Department department;
```

### 7. **`@JoinColumn`**
Indica la columna de unión en una relación de asociación.

**Propiedades comunes:**
- **`name`**: Define el nombre de la columna de la clave externa.
- **`referencedColumnName`**: Indica la columna de la tabla referenciada que actúa como clave externa.

```java
@ManyToOne
@JoinColumn(name = "department_id", referencedColumnName = "id")
private Department department;
```

### 8. **`@Temporal`**
Se utiliza para especificar el tipo de fecha (solo `Date` o `Time`) cuando se trabaja con atributos `java.util.Date` o `java.util.Calendar`.

**Valores posibles:**
- **`TemporalType.DATE`**: Solo la fecha (día, mes, año).
- **`TemporalType.TIME`**: Solo la hora (hora, minuto, segundo).
- **`TemporalType.TIMESTAMP`**: Fecha completa con tiempo.

```java
@Temporal(TemporalType.DATE)
private Date hireDate;
```

### 9. **`@Lob`**
Indica que el campo se debe mapear como un objeto de gran tamaño, como un `BLOB` (Binary Large Object) o `CLOB` (Character Large Object).

```java
@Lob
private byte[] image;
```

### 10. **`@Transient`**
Excluye un campo del mapeo, es decir, no se guardará en la base de datos.

```java
@Transient
private int tempField;
```
