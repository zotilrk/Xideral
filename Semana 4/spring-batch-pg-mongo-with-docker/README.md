# Spring Batch: PostgreSQL → MongoDB (H2 metadata)

Proyecto base con **Spring Boot 3.3.x** y **Java 17** para ejecutar un **Job de Spring Batch** que:
- Lee de **PostgreSQL** (Spring Data JPA)
- Procesa / transforma con **MapStruct**
- Escribe en **MongoDB** (Spring Data Mongo)
- Guarda **metadatos de Spring Batch en H2**
- Expone un endpoint REST para **lanzar el Job**
- Incluye **Swagger/OpenAPI**, **Lombok**, **tests** (unit + MockMvc) y **JaCoCo** con reporte **HTML**

## Requisitos
- Java 17
- Maven 3.8+
- Docker (opcional para levantar Postgres/Mongo)
  
## Configuración rápida
Edita `src/main/resources/application.yml` con tus credenciales de Postgres y la URI de Mongo.
Por defecto:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/tu_db
    username: tu_usuario
    password: tu_password
  data:
    mongodb:
      uri: mongodb://localhost:27017/batchdb
```

## Ejecutar (dev)
```bash
mvn clean spring-boot:run
```

Abrir **Swagger UI**:
```
http://localhost:8080/swagger-ui.html
```

Ejecutar Job vía REST:
```bash
curl -X POST "http://localhost:8080/api/batch/customers/run"
```

## Esquema de ejemplo (PostgreSQL)
```sql
CREATE TABLE customers (
  id BIGSERIAL PRIMARY KEY,
  first_name VARCHAR(100),
  last_name  VARCHAR(100),
  email      VARCHAR(200),
  status     VARCHAR(20)
);

INSERT INTO customers (first_name,last_name,email,status) VALUES
('Ada','Lovelace','ada@computing.org','ACTIVE'),
('Alan','Turing','alan@ai.uk','INACTIVE');
```

## Docker compose (opcional)
Crea un archivo `docker-compose.yml` como este:
```yaml
services:
  postgres:
    image: postgres:16
    environment:
      POSTGRES_DB: tu_db
      POSTGRES_USER: tu_usuario
      POSTGRES_PASSWORD: tu_password
    ports: ["5432:5432"]
  mongo:
    image: mongo:6
    ports: ["27017:27017"]
```
Levántalo con:
```bash
docker compose up -d
```

## Tests y cobertura (JaCoCo)
Ejecuta:
```bash
mvn clean verify
```
El reporte HTML quedará en:
```
target/site/jacoco/index.html
```

## Notas técnicas
- El job usa `RepositoryItemReader` con `CustomerRepository` (JPA) y `RepositoryItemWriter` con `CustomerDocRepository` (Mongo).
- Los metadatos de Spring Batch se almacenan en **H2** usando un `@BatchDataSource` dedicado (ver `DataSourceConfig`).

---
Happy batching! 🚀
