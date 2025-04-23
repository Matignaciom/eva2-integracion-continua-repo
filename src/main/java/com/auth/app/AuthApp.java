package com.auth.app;

import java.sql.*;
import com.auth.app.model.Usuario;
import com.auth.app.model.Persona;
import java.util.Date;

public class AuthApp {
    private static final String DB_URL = "jdbc:mysql://localhost:3307/auth_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "matias123";

    public static boolean autenticar(String username, String password) {
        String sql = "SELECT * FROM Usuario WHERE username = ? AND password = ?";
        
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, username);
            stmt.setString(2, password);
            
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // Retorna true si encuentra coincidencia
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static Usuario obtenerUsuario(String username) {
        String sql = "SELECT * FROM Usuario WHERE username = ?";
        
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, username);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String rut = rs.getString("rut");
                    String password = rs.getString("password");
                    return new Usuario(rut, username, password);
                }
                return null;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static Persona obtenerPersona(String rut) {
        String sql = "SELECT * FROM Persona WHERE rut = ?";
        
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, rut);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String nombres = rs.getString("nombres");
                    String apellidoPaterno = rs.getString("apellido_paterno");
                    String apellidoMaterno = rs.getString("apellido_materno");
                    String telefono = rs.getString("telefono");
                    Date fechaIngreso = rs.getDate("fecha_ingreso");
                    
                    return new Persona(rut, nombres, apellidoPaterno, apellidoMaterno, 
                                      telefono, fechaIngreso);
                }
                return null;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // Método que obtiene los datos completos de un usuario (información de Usuario y Persona)
    public static Persona obtenerDatosCompletos(String username, String password) {
        if (autenticar(username, password)) {
            Usuario usuario = obtenerUsuario(username);
            if (usuario != null) {
                return obtenerPersona(usuario.getRut());
            }
        }
        return null;
    }
}