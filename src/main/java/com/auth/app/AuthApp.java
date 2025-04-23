package com.auth.app;

import java.sql.*;

public class AuthApp {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/auth_db";
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
}