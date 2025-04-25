package com.auth.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import com.auth.app.model.Usuario;
import com.auth.app.model.Persona;

/**
 * Pruebas para AuthApp
 */
public class AuthAppTest extends TestCase
{
    public AuthAppTest(String testName)
    {
        super(testName);
    }

    public static Test suite()
    {
        return new TestSuite(AuthAppTest.class);
    }

    /**
     * Prueba con credenciales válidas
     */
    public void testAutenticacionValida()
    {
        // Usuario de prueba
        String username = "usuario_test";
        String password = "clave_test";
        
        // Descomentar para prueba real
        assertTrue(AuthApp.autenticar(username, password));
        
        // Alternativa
        // assertTrue(true);
    }
    
    /**
     * Prueba con credenciales inválidas
     */
    public void testAutenticacionInvalida()
    {
        String username = "usuario_inexistente";
        String password = "clave_incorrecta";
        
        assertFalse(AuthApp.autenticar(username, password));
    }
}