# Importador Batch de Productos

Este proyecto es una aplicación Spring Boot que importa datos de productos desde un archivo CSV a una base de datos utilizando Spring Batch.

## Características

- Lee productos desde `src/main/resources/articulos.csv`
- Filtra productos por categoría (`Pantalones`) y precio (`> 100`)
- Persiste los productos válidos en la base de datos
- Endpoint REST para ejecutar el job de importación

## Tecnologías

- Java
- Spring Boot
- Spring Batch
- Spring Data JPA
- postgreSQL
- Maven

## Cómo ejecutar

1. Clona el repositorio.
2. Configura tu base de datos en `application.properties`.
3. Coloca tu archivo CSV en `src/main/resources/articulos.csv`.
4. Compila el proyecto:

   ```bash
   mvn clean install