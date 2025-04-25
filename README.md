# Sistema de Autenticación

## Descripción
Sistema de autenticación básico desarrollado en Java que permite validar credenciales de usuario y mostrar información personal asociada. El sistema se conecta a una base de datos MySQL para almacenar y recuperar información de usuarios.

## Características
- Autenticación de usuarios mediante nombre de usuario y contraseña
- Recuperación de datos personales del usuario autenticado
- Almacenamiento de información en base de datos MySQL
- Pruebas unitarias para validar la funcionalidad

## Estructura del Proyecto
- **Modelos**: Clases para representar entidades (Usuario, Persona)
- **Autenticación**: Lógica para validar credenciales y obtener datos
- **Interfaz**: Aplicación de consola para interactuar con el sistema
- **Pruebas**: Validación de funcionalidades principales

## Requisitos
- Java 17 o superior
- MySQL 8.0
- Maven 3.8 o superior

## Configuración de Base de Datos
El script para crear la base de datos se encuentra en `src/main/resources/db_script.sql`. Este script crea:
- Base de datos `auth_db`
- Tablas `Persona` y `Usuario`
- Datos de ejemplo para pruebas

## Ejecución
Para ejecutar el proyecto:

```bash
mvn clean compile
mvn exec:java
```

## Pruebas
Para ejecutar las pruebas unitarias:

```bash
mvn test
```

## Desarrollado por
Matías Ignacio Paredes Marquéz.