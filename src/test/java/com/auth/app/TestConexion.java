package com.auth.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Prueba de conexión a base de datos
 */
public class TestConexion {
    public static void main(String[] args) {
        String DB_URL = "jdbc:mysql://localhost:3307/auth_db";
        String DB_USER = "root";
        String DB_PASSWORD = "matias123";
        
        System.out.println("Intentando conectar a la base de datos...");
        
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            System.out.println("¡Conexión exitosa a la base de datos!");
            System.out.println("Información: " + conn.getMetaData().getDatabaseProductName() + " " + 
                              conn.getMetaData().getDatabaseProductVersion());
        } catch (SQLException e) {
            System.out.println("Error de conexión:");
            e.printStackTrace();
        }
    }
}