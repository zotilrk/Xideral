# Proyecto de Pruebas Unitarias con JUnit y Mockito

Este proyecto es una práctica simple para ilustrar el uso de **JUnit 5** y **Mockito** en un entorno Java puro, sin usar Spring Boot.

## 🧪 Objetivo

Demostrar cómo realizar pruebas unitarias utilizando:
- **JUnit 5** para la estructura de las pruebas
- **Mockito** para la creación de objetos simulados (mocks)

## 📦 Tecnologías y herramientas

- Java 17
- Maven
- JUnit 5 (`junit-jupiter`)
- Mockito

## 📁 Estructura del proyecto

```
user-testing/
├── src/
│   ├── main/
│   │   └── java/com/example/user/
│   │       ├── User.java
│   │       ├── UserRepository.java
│   │       └── UserService.java
│   └── test/
│       └── java/com/example/user/
│           └── UserServiceTest.java
├── pom.xml
└── README.md
```

## 🧩 Lógica del proyecto

El sistema se compone de:

- `User`: una clase sencilla que representa a un usuario.
- `UserRepository`: una interfaz simulada para manejar usuarios (en un caso real se conectaría a una base de datos).
- `UserService`: una clase que contiene lógica de negocio sobre usuarios.
- `UserServiceTest`: una clase de prueba que **usa Mockito para simular** `UserRepository` y **verifica el comportamiento** de `UserService`.

## 🧪 Ejecutar pruebas

Para ejecutar las pruebas, puedes usar:

### Desde IntelliJ:
- Haz clic derecho sobre `UserServiceTest.java` → **Run**

### Desde la terminal:
```bash
mvn test
```

## 🧰 Dependencias principales (`pom.xml`)

```xml
<dependencies>
  <!-- JUnit 5 -->
  <dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.9.3</version>
    <scope>test</scope>
  </dependency>

  <!-- Mockito -->
  <dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>5.2.0</version>
    <scope>test</scope>
  </dependency>
</dependencies>
```

