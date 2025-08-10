# 📦 Delivery API - CRUD con Spring Boot y MongoDB

## 📖 Descripción
Este proyecto es una API REST desarrollada con **Spring Boot** y **MongoDB** para la gestión de pedidos (**Orders**) y repartidores (**Couriers**).  
Incluye reglas de negocio personalizadas, documentación automática con **OpenAPI/Swagger**, y separación por capas para un código limpio y mantenible.

---

## 🚀 Características
- **CRUD de Couriers** (repartidores):
  - Crear, consultar.
  - Control de estado (`DISPONIBLE`, `OCUPADO`).
  
- **CRUD de Orders** (pedidos):
  - Crear, consultar, actualizar y eliminar pedidos.
  - Asignación automática de un repartidor **disponible** al crear una orden.
  - Cambio automático del estado del repartidor a **OCUPADO**.

- **Regla de negocio principal**:
  - No se puede crear una orden si no existen repartidores disponibles.

---

## 🛠 Tecnologías utilizadas
- **Java 17**
- **Spring Boot**
- **Spring Data MongoDB**
- **Lombok**
- **MapStruct**
- **Springdoc OpenAPI (Swagger)**
- **Maven**

---

## 🗄 Base de datos
- **Motor**: MongoDB
- **Base de datos**: `delivery`
- **Colecciones**:
  - `couriers`
  - `orders`

**Connection string en `application.properties`:**
```properties
spring.data.mongodb.uri=mongodb://mongo_user:mongo_pass@localhost:27017/delivery?authSource=admin
```

---

## 📂 Estructura del proyecto
```
src/main/java/com/example/crudmongodb
│
├── controllers      # Controladores REST (Couriers y Orders)
├── services         # Lógica de negocio
├── repositories     # Repositorios MongoDB
├── entities         # Entidades y enums
├── dtos             # DTOs (opcional según diseño)
└── mappers          # MapStruct mappers
```

---

## 📜 Documentación de la API
Una vez ejecutada la aplicación, la documentación Swagger está disponible en:  
🔗 **[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)**

---

## ▶ Ejecución del proyecto
1. **Clonar el repositorio**:
```bash
git clone https://github.com/zotilrk/Xideral
cd repositorio
```

2. **Compilar y ejecutar con Maven**:
```bash
mvn clean install
mvn spring-boot:run
```

3. **Asegurar que MongoDB está corriendo** en local:
```bash
mongod
```

---

## 👨‍💻 Autor
Desarrollado por Juan Carlos Bernal Sandoval 🚀
