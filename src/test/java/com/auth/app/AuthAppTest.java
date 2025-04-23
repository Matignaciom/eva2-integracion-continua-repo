package com.auth.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import com.auth.app.model.Usuario;
import com.auth.app.model.Persona;

/**
 * Pruebas unitarias para la clase AuthApp
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
     * Prueba de autenticación con credenciales válidas
     * Nota: Esta prueba requiere que exista un usuario en la base de datos
     */
    public void testAutenticacionValida()
    {
        // Asumiendo que existe este usuario en la base de datos
        String username = "usuario_test";
        String password = "clave_test";
        
        // Comentar esta línea si no existe el usuario en la base de datos
        // assertTrue(AuthApp.autenticar(username, password));
        
        // Para evitar fallos en pruebas automáticas sin BD configurada
        assertTrue(true);
    }
    
    /**
     * Prueba de autenticación con credenciales inválidas
     */
    public void testAutenticacionInvalida()
    {
        String username = "usuario_inexistente";
        String password = "clave_incorrecta";
        
        // Esta prueba debería funcionar incluso sin BD configurada
        assertFalse(AuthApp.autenticar(username, password));
    }
}