package com.auth.app.model;

public class Usuario {
    private String rut;
    private String username;
    private String password;
    
    // Constructor
    public Usuario(String rut, String username, String password) {
        this.rut = rut;
        this.username = username;
        this.password = password;
    }
    
    // Getters y Setters
    public String getRut() {
        return rut;
    }
    
    public void setRut(String rut) {
        this.rut = rut;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}