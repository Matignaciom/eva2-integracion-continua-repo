-- Crear la base de datos si no existe
CREATE DATABASE IF NOT EXISTS auth_db;

-- Usar la base de datos
USE auth_db;

-- Crear tabla Persona
CREATE TABLE IF NOT EXISTS Persona (
    rut VARCHAR(12) PRIMARY KEY,
    nombres VARCHAR(100) NOT NULL,
    apellido_paterno VARCHAR(50) NOT NULL,
    apellido_materno VARCHAR(50),
    telefono VARCHAR(15),
    fecha_ingreso DATE NOT NULL
);

-- Crear tabla Usuario
CREATE TABLE IF NOT EXISTS Usuario (
    rut VARCHAR(12) PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL,
    FOREIGN KEY (rut) REFERENCES Persona(rut)
);

-- Insertar datos de ejemplo
INSERT INTO Persona (rut, nombres, apellido_paterno, apellido_materno, telefono, fecha_ingreso)
VALUES ('12345678-9', 'Juan Carlos', 'Pérez', 'González', '+56912345678', '2023-01-15');

INSERT INTO Usuario (rut, username, password)
VALUES ('12345678-9', 'jperez', 'clave123');

-- Usuario de prueba para tests
INSERT INTO Persona (rut, nombres, apellido_paterno, apellido_materno, telefono, fecha_ingreso)
VALUES ('98765432-1', 'Usuario', 'De', 'Prueba', '+56987654321', '2023-04-20');

INSERT INTO Usuario (rut, username, password)
VALUES ('98765432-1', 'usuario_test', 'clave_test');